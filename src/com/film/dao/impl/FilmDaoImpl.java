package com.film.dao.impl;

import com.film.dao.BaseDao;
import com.film.dao.FilmDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.film.*;
import com.film.dao.FilmTypeDao;
import com.film.pojo.Film;

/**
 * @author lzl
 * @version 1.0
 * @description: TODO
 * @date 2023/5/11 9:23
 */
public class FilmDaoImpl implements FilmDao {
	FilmTypeDao filmTypeDao = new FilmTypeDaoImpl();

	/**
	 * @description: 按浏览量查询上映影视
	 * @param:
	 * @return: java.util.List<com.film.pojo.Film>
	 * @author lzl
	 * @date: 2023/5/11 18:23
	 */
	@Override
	public List<Film> getFilmsByfilmViews() {
		List<Film> fileList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "select * from film where status=1 order by film_views";
		try {
			connection = BaseDao.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Film film = new Film();
				film.setFilmId(Integer.valueOf(resultSet.getInt(1)));
				film.setFilmName(resultSet.getString(2));
				film.setFilmType(filmTypeDao.getFilmTypeByTypeId(resultSet.getInt(3)));
				film.setFilmIdId(resultSet.getInt(4));
				film.setFilmTime(resultSet.getString(5));
				film.setFilmViews(resultSet.getInt(6));
				film.setFilmAuthor(resultSet.getString(7));
				film.setFilmIntro(resultSet.getString(8));
				film.setFilmImage(resultSet.getString(9));
				film.setFilmVideo(resultSet.getString(10));
				fileList.add(film);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(resultSet, preparedStatement, connection);
		}
		return fileList;
	}

	/**
	 * @description: 管理员修改影视时，根据filmId查film-根据filmId查询影视
	 * @param: typeId
	 * @return: java.util.List<com.film.pojo.Film>
	 * @author lzl
	 * @date: 2023/5/11 17:16
	 */
	@Override
	public Film getFilmsByFilmId(Integer filmId) {
		Film film = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "select * from film where film_id = ?";
		try {
			connection = BaseDao.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setObject(1,filmId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				film = new Film();
				film.setFilmId(Integer.valueOf(resultSet.getInt(1)));
				film.setFilmName(resultSet.getString(2));
				film.setFilmType(filmTypeDao.getFilmTypeByTypeId(resultSet.getInt(3)));
				film.setFilmIdId(resultSet.getInt(4));
				film.setFilmTime(resultSet.getString(5));
				film.setFilmViews(resultSet.getInt(6));
				film.setFilmAuthor(resultSet.getString(7));
				film.setFilmIntro(resultSet.getString(8));
				film.setFilmImage(resultSet.getString(9));
				film.setFilmVideo(resultSet.getString(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(resultSet, preparedStatement, connection);
		}
		return film;
	}

	/**
	 * @description: 查询不同类型的上映影视
	 * @param: typeId
	 * @return: java.util.List<com.film.pojo.Film>
	 * @author lzl
	 * @date: 2023/5/11 18:23
	 */
	@Override
	public List<Film> getFilmsByTypeId(Integer typeId) {
		List<Film> fileList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "select * from film where status=1 and type_id=? order by film_views desc";
		try {
			connection = BaseDao.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setObject(1,typeId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Film film = new Film();
				film.setFilmId(Integer.valueOf(resultSet.getInt(1)));
				film.setFilmName(resultSet.getString(2));
				film.setFilmType(filmTypeDao.getFilmTypeByTypeId(resultSet.getInt(3)));
				film.setFilmIdId(resultSet.getInt(4));
				film.setFilmTime(resultSet.getString(5));
				film.setFilmViews(resultSet.getInt(6));
				film.setFilmAuthor(resultSet.getString(7));
				film.setFilmIntro(resultSet.getString(8));
				film.setFilmImage(resultSet.getString(9));
				film.setFilmVideo(resultSet.getString(10));
				fileList.add(film);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(resultSet, preparedStatement, connection);
		}
		return fileList;
	}

	/**
	 * @description: 管理员模糊查询时-模糊查询的总行数
	 * @param: fileName
	fileAuthor
	typeId
	 * @return: java.lang.Integer
	 * @author lzl
	 * @date: 2023/5/11 18:23
	 */
	@Override
	public Integer getTotalCounts(String fileName, String fileAuthor, Integer typeId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		//	恒成立条件，便于sql拼接
		String sql = "select count(1) from film where status !=0";
		if (fileName != null && fileName != "") {
			//	注意最前面加空格, 模糊字符串的单引号
			sql += " and film_name like '%"+fileName+"%'";
		}
		if (fileAuthor != null && fileAuthor != "") {
			//	注意最前面加空格, 模糊字符串的单引号
			sql += " and film_author like '%"+fileAuthor+"%'";
		}
		if (typeId != null) {
			//	注意最前面加空格, 模糊字符串的单引号
			sql += " and type_id ="+typeId;
		}
		try {
			connection = BaseDao.getConnection();
			preparedStatement= connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(resultSet,preparedStatement,connection);
		}
		return 0;
	}

	/**
	 * @description: 管理员模糊查询时-模糊查询的分页数据
	 * @param: pageIndex
	pageSize
	fileName
	fileAuthor
	typeId
	 * @return: java.util.List<com.film.pojo.Film>
	 * @author lzl
	 * @date: 2023/5/11 18:24
	 */
	@Override
	public List<Film> getFilmsByMulti(Integer pageIndex, Integer pageSize, String fileName, String fileAuthor, Integer typeId) {
		List<Film> fileList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Boolean flag = false;
		//	恒成立条件，便于sql拼接
		String sql = "select * from film where status!=0";
		if (fileName != null && fileName != "") {
			//	注意最前面加空格, 模糊字符串的单引号
			sql += " and film_name like '%"+fileName+"%'";
		}
		if (fileAuthor != null && fileAuthor != "") {
			//	注意最前面加空格, 模糊字符串的单引号
			sql += " and film_author like '%"+fileAuthor+"%'";
		}
		if (typeId != null) {
			//	注意最前面加空格, 模糊字符串的单引号
			sql += " and type_id ="+typeId;
		}
		if (pageIndex != null && pageSize != null) {
			//	注意最前面加空格, 模糊字符串的单引号, 会对吗？
			sql += " order by film_views desc  limit ?,?";
			flag = true;
		}
		try {
			connection = BaseDao.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			if (flag) {
				preparedStatement.setObject(1,(pageIndex-1)*pageSize);
				preparedStatement.setObject(2,pageSize);
			}
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Film film = new Film();
				film.setFilmId(Integer.valueOf(resultSet.getInt(1)));
				film.setFilmName(resultSet.getString(2));
				film.setFilmType(filmTypeDao.getFilmTypeByTypeId(resultSet.getInt(3)));
				film.setFilmIdId(resultSet.getInt(4));
				film.setFilmTime(resultSet.getString(5));
				film.setFilmViews(resultSet.getInt(6));
				film.setFilmAuthor(resultSet.getString(7));
				film.setFilmIntro(resultSet.getString(8));
				film.setFilmImage(resultSet.getString(9));
				film.setFilmVideo(resultSet.getString(10));
				film.setStatus(resultSet.getInt(11));
				fileList.add(film);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(resultSet, preparedStatement, connection);
		}
		return fileList;
	}

	/**
	 * @description: 普通用户查询不同影视的不同类型
	 * @param: pageIndex
	pageSize
	fileName
	fileAuthor
	typeId
	 * @return: java.util.List<com.film.pojo.Film>
	 * @author lzl
	 * @date: 2023/5/11 18:20
	 */
	@Override
	public List<Film> getFilmsByTypeIdId(Integer typeId, Integer typeIdId) {
		List<Film> fileList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "select * from film where type_id=? and type_id_id=? order by film_views desc ";
		try {
			connection = BaseDao.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setObject(1,typeId);
			preparedStatement.setObject(2,typeIdId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Film film = new Film();
				film.setFilmId(Integer.valueOf(resultSet.getInt(1)));
				film.setFilmName(resultSet.getString(2));
				// 存储影视类型对象，便于根据影视类型编号，获取影视类型名称
				film.setFilmType(filmTypeDao.getFilmTypeByTypeId(resultSet.getInt(3)));
				// 这个也改成上面那种，待改
				film.setFilmIdId(resultSet.getInt(4));
				film.setFilmTime(resultSet.getString(5));
				film.setFilmViews(resultSet.getInt(6));
				film.setFilmAuthor(resultSet.getString(7));
				film.setFilmIntro(resultSet.getString(8));
				film.setFilmImage(resultSet.getString(9));
				film.setFilmVideo(resultSet.getString(10));
				fileList.add(film);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(resultSet, preparedStatement, connection);
		}
		return fileList;
	}

	/**
	 * @description: 管理员添加影视
	 * @param: film
	 * @return: boolean
	 * @author lzl
	 * @date: 2023/5/11 18:32
	 */
	@Override
	public boolean addFilm(Film film) {
		// status默认为1，所以修改时，可以填null，默认为1？
		String sql = "insert into film values(null,?,?,?,?,0,?,?,?,?,2)";
		return BaseDao.operation(sql,film.getFilmName(),film.getFilmType().getTypeId(),film.getFilmIdId(),film.getFilmTime(),film.getFilmAuthor(),film.getFilmIntro(),film.getFilmImage(),film.getFilmImage());
	}

	/**
	 * @description: 普通用户点击影视图片(或标题)链接，增加浏览量
	 * @param:
	 * @return: boolean
	 * @author lzl
	 * @date: 2023/5/12 16:30
	 */
	@Override
	public boolean addFilmViews(Integer filmId) {
//		Film film = getFilmsByFilmId(filmId);
//		int views = film.getFilmViews();
//		views++;
		String sql = "update film set film_views=film_views+1 where film_id="+filmId;
		return BaseDao.operation(sql);
	}

	/**
	 * @description: 管理员修改多个或单个影视，修改其状态，实现影视逻辑删除
	 * @param: filmIds
	 * @return: boolean
	 * @author lzl
	 * @date: 2023/5/11 18:32
	 */
	@Override
	public boolean updateFilmByStatus(String filmIds) {
		String sql = "update film set status = 0 where film_id in ("+filmIds+")";
		return BaseDao.operation(sql);
	}

	/**
	 * @description: 管理员修改影视
	 * @param: film
	 * @return: boolean
	 * @author lzl
	 * @date: 2023/5/11 18:32
	 */
	@Override
	public boolean updateFilm(Film film) {
		String sql = "update film set film_name=?, type_id=?, type_id_id=?, film_time=?, film_views=?, film_author=?, film_intro=?, film_image=?, film_video=?,status=? where film_id=?";
		return BaseDao.operation(sql,film.getFilmName(),film.getFilmType().getTypeId(),film.getFilmIdId(),film.getFilmTime(),film.getFilmViews(),film.getFilmAuthor(),film.getFilmIntro(),film.getFilmImage(),film.getFilmVideo(),film.getStatus(),film.getFilmId());
	}

	/**
	 * @return java.util.List<com.film.pojo.Film>
	 * @Author yanchen
	 * @Description //TODO 按照影视浏览量的降序查询出前八位的影视浏览量和影视名称
	 * @Date 9:22 2023/5/16 0016
	 * @Param []
	 **/
	@Override
	public List<Film> getFilms() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Film> list = new ArrayList<Film>();
		String sql = "select film_views,film_name from film order by film_views desc limit 8;";
		conn = BaseDao.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Film film = new Film();
				film.setFilmViews(rs.getInt(1));
				film.setFilmName(rs.getString(2));
				list.add(film);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(rs,pstmt,conn);
		}
		return null;
	}
}
