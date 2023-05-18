package com.film.pojo;

/**
 * @author lzl
 * @version 1.0
 * @description: 电影类
 * @date 2023/5/11 9:16
 */
public class MovieType {
	private Integer movieTypeId;
	private FilmType filmType;
	private String movieTypeName;


	public MovieType() {
	}

	public MovieType(Integer movieTypeId, FilmType filmType, String movieTypeName) {
		this.movieTypeId = movieTypeId;
		this.filmType = filmType;
		this.movieTypeName = movieTypeName;
	}

	/**
	 * 获取
	 * @return movieTypeId
	 */
	public Integer getMovieTypeId() {
		return movieTypeId;
	}

	/**
	 * 设置
	 * @param movieTypeId
	 */
	public void setMovieTypeId(Integer movieTypeId) {
		this.movieTypeId = movieTypeId;
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
	 * @return movieTypeName
	 */
	public String getMovieTypeName() {
		return movieTypeName;
	}

	/**
	 * 设置
	 * @param movieTypeName
	 */
	public void setMovieTypeName(String movieTypeName) {
		this.movieTypeName = movieTypeName;
	}

	public String toString() {
		return "MovieType{movieTypeId = " + movieTypeId + ", filmType = " + filmType + ", movieTypeName = " + movieTypeName + "}";
	}
}
