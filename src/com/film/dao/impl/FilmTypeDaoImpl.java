package com.film.dao.impl;

import com.film.dao.BaseDao;
import com.film.dao.FilmTypeDao;
import com.film.pojo.FilmType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author lzl
 * @version 1.0
 * @description: TODO
 * @date 2023/5/11 9:23
 */
public class FilmTypeDaoImpl implements FilmTypeDao {
	/**
	 * @description: 根据typeId查影视类型
	 * @param: typeId
	 * @return: com.film.pojo.FilmType
	 * @author lzl
	 * @date: 2023/5/12 9:59
	 */
	@Override
	public FilmType getFilmTypeByTypeId(Integer typeId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "select * from film_type where type_id="+typeId;

		try {
			connection = BaseDao.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				FilmType filmType = new FilmType(resultSet.getInt(1),resultSet.getString(2));
				return filmType;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
