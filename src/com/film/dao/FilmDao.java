package com.film.dao;

import com.film.pojo.Film;

import java.util.List;

/**
 * @author lzl
 * @version 1.0
 * @description: TODO
 * @date 2023/5/11 9:20
 */
// 需求：1.管理员分页模糊查询影视：模糊查询的总行数+模糊查询的分页数据
// 2.首页按上传时间顺序查询上映影视
// 3.分页查询电影下的不同类型影视：用户点击左导航的电影(设置超链接锚点)并传影视类型id给右边页面，右边页面开始加载，执行Ajax，按电影类型，显示所有上映电影，用Ajax+循环实现。每次循环传送影视类型id和电影类型id(自增的)给FilmServlet，然后Ajax对返回的数据进行渲染输出
public interface FilmDao {

	/**
	 * @description:  按浏览量查询上映影视
	 * @param:
	 * @return: java.util.List<com.film.pojo.Film>
	 * @author lzl
	 * @date: 2023/5/11 17:05
	 */
	List<Film> getFilmsByfilmViews();

	/**
	 * @description: 管理员修改影视时，根据filmId查film-根据filmId查询影视
	 * @param: typeId
	 * @return: java.util.List<com.film.pojo.Film>
	 * @author lzl
	 * @date: 2023/5/11 17:16
	 */
	Film getFilmsByFilmId(Integer filmId);

	/**
	 * @description: 查询不同类型的上映影视
	 * @param: typeId
	 * @return: java.util.List<com.film.pojo.Film>
	 * @author lzl
	 * @date: 2023/5/11 17:16
	 */
	List<Film> getFilmsByTypeId(Integer typeId);

	/**
	 * @description: 管理员模糊查询时-模糊查询的总行数
	 * @param: fileName
	fileAuthor
	typeId
	 * @return: java.lang.Integer
	 * @author lzl
	 * @date: 2023/5/11 17:19
	 */
	Integer getTotalCounts(String fileName, String fileAuthor, Integer typeId);

	/** 
	 * @description: 管理员模糊查询时-模糊查询的分页数据
	 * @param: pageIndex
	pageSize
	fileName
	fileAuthor
	typeId 
	 * @return: java.util.List<com.film.pojo.Film> 
	 * @author lzl
	 * @date: 2023/5/11 18:20
	 */
	List<Film> getFilmsByMulti(Integer pageIndex, Integer pageSize, String fileName, String fileAuthor, Integer typeId);

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
	List<Film> getFilmsByTypeIdId(Integer typeId, Integer typeIdId);
	
	/** 
	 * @description: 管理员添加影视
	 * @param: film 
	 * @return: boolean 
	 * @author lzl
	 * @date: 2023/5/11 18:30
	 */ 
	boolean addFilm(Film film);
	
	/** 
	 * @description: 普通用户点击影视图片(或标题)链接，增加浏览量
	 * @param:  
	 * @return: boolean 
	 * @author lzl
	 * @date: 2023/5/12 16:30
	 */ 
	boolean addFilmViews(Integer filmId);
	
	/** 
	 * @description:  管理员修改多个或单个影视，修改其状态，实现影视逻辑删除
	 * @param: filmIds 
	 * @return: boolean 
	 * @author lzl
	 * @date: 2023/5/11 18:28
	 */ 
	boolean updateFilmByStatus(String filmIds);
	
	/** 
	 * @description: 管理员修改影视
	 * @param: film 
	 * @return: boolean 
	 * @author lzl
	 * @date: 2023/5/11 18:35
	 */ 
	boolean updateFilm(Film film);

	/**
	 * @return java.util.List<com.film.pojo.Film>
	 * @Author yanchen
	 * @Description //TODO 用于统计影视浏览量前八位的浏览量数据，形成图标展示
	 * @Date 9:21 2023/5/16 0016
	 * @Param []
	 **/
	public List<Film> getFilms();
}
