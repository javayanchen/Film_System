package com.film.pojo;

/**
 * @author lzl
 * @version 1.0
 * @description: 体育类
 * @date 2023/5/11 9:16
 */
public class SportType {
	private Integer sportTypeId;
	private FilmType filmType;
	private String sportTypeName;
	public SportType() {
	}

	public SportType(Integer sportTypeId, FilmType filmType, String sportTypeName) {
		this.sportTypeId = sportTypeId;
		this.filmType = filmType;
		this.sportTypeName = sportTypeName;
	}

	/**
	 * 获取
	 * @return sportTypeId
	 */
	public Integer getSportTypeId() {
		return sportTypeId;
	}

	/**
	 * 设置
	 * @param sportTypeId
	 */
	public void setSportTypeId(Integer sportTypeId) {
		this.sportTypeId = sportTypeId;
	}

	/**
	 * 获取
	 * @return filmType
	 */
	public FilmType getFilmType() {
		return filmType;
	}

	/**
	 * 设置
	 * @param filmType
	 */
	public void setFilmType(FilmType filmType) {
		this.filmType = filmType;
	}

	/**
	 * 获取
	 * @return sportTypeName
	 */
	public String getSportTypeName() {
		return sportTypeName;
	}

	/**
	 * 设置
	 * @param sportTypeName
	 */
	public void setSportTypeName(String sportTypeName) {
		this.sportTypeName = sportTypeName;
	}

	public String toString() {
		return "SportType{sportTypeId = " + sportTypeId + ", filmType = " + filmType + ", sportTypeName = " + sportTypeName + "}";
	}
}
