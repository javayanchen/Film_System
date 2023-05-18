package com.film.dao;

import com.film.pojo.FilmType;

/**
 * @author lzl
 * @version 1.0
 * @description: TODO
 * @date 2023/5/11 9:20
 */
public interface FilmTypeDao {
	/** 
	 * @description: 根据typeId查影视类型
	 * @param: typeId 
	 * @return: com.film.pojo.FilmType 
	 * @author lzl
	 * @date: 2023/5/12 10:00
	 */ 
	FilmType getFilmTypeByTypeId(Integer typeId);
}
