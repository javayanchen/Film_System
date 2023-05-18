package com.film.pojo;

/**
 * @author lzl
 * @version 1.0
 * @description: TODO
 * @date 2023/5/11 9:16
 */
public class DramaType {
	private Integer dramaTypeId;
	private FilmType filmType;
	private String dramaTypeName;


	public DramaType() {
	}

	public DramaType(Integer dramaTypeId, FilmType filmType, String dramaTypeName) {
		this.dramaTypeId = dramaTypeId;
		this.filmType = filmType;
		this.dramaTypeName = dramaTypeName;
	}

	/**
	 * 获取
	 * @return dramaTypeId
	 */
	public Integer getDramaTypeId() {
		return dramaTypeId;
	}

	/**
	 * 设置
	 * @param dramaTypeId
	 */
	public void setDramaTypeId(Integer dramaTypeId) {
		this.dramaTypeId = dramaTypeId;
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
	 * @return dramaTypeName
	 */
	public String getDramaTypeName() {
		return dramaTypeName;
	}

	/**
	 * 设置
	 * @param dramaTypeName
	 */
	public void setDramaTypeName(String dramaTypeName) {
		this.dramaTypeName = dramaTypeName;
	}

	public String toString() {
		return "DramaType{dramaTypeId = " + dramaTypeId + ", filmType = " + filmType + ", dramaTypeName = " + dramaTypeName + "}";
	}
}
