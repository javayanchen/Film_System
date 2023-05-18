package com.film.pojo;

/**
 * @author lzl
 * @version 1.0
 * @description: TODO
 * @date 2023/5/11 9:16
 */
public class Film {
	// 影视编号
	private Integer filmId;
	// 影视名称
	private String filmName;
	// 影视类型
	private FilmType filmType;
	// 不同影视下的不同类型编号
	private Integer filmIdId;
	// 影视时长
	private String filmTime;
	// 浏览量
	private Integer filmViews;
	// 影视导演
	private String filmAuthor;
	// 影视简介
	private String filmIntro;
	// 影视图片路径
	private String filmImage;
	// 影视视频路径
	private String filmVideo;
	// 影视状态 0-下映 1-上映，默认为1
	private Integer status;


	public Film() {
	}

	public Film(Integer filmId, String filmName, FilmType filmType, Integer filmIdId, String filmTime, Integer filmViews, String filmAuthor, String filmIntro, String filmImage, String filmVideo, Integer status) {
		this.filmId = filmId;
		this.filmName = filmName;
		this.filmType = filmType;
		this.filmIdId = filmIdId;
		this.filmTime = filmTime;
		this.filmViews = filmViews;
		this.filmAuthor = filmAuthor;
		this.filmIntro = filmIntro;
		this.filmImage = filmImage;
		this.filmVideo = filmVideo;
		this.status = status;
	}

	/**
	 * 获取
	 * @return filmId
	 */
	public Integer getFilmId() {
		return filmId;
	}

	/**
	 * 设置
	 * @param filmId
	 */
	public void setFilmId(Integer filmId) {
		this.filmId = filmId;
	}

	/**
	 * 获取
	 * @return filmName
	 */
	public String getFilmName() {
		return filmName;
	}

	/**
	 * 设置
	 * @param filmName
	 */
	public void setFilmName(String filmName) {
		this.filmName = filmName;
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
	 * @return filmIdId
	 */
	public Integer getFilmIdId() {
		return filmIdId;
	}

	/**
	 * 设置
	 * @param filmIdId
	 */
	public void setFilmIdId(Integer filmIdId) {
		this.filmIdId = filmIdId;
	}

	/**
	 * 获取
	 * @return filmTime
	 */
	public String getFilmTime() {
		return filmTime;
	}

	/**
	 * 设置
	 * @param filmTime
	 */
	public void setFilmTime(String filmTime) {
		this.filmTime = filmTime;
	}

	/**
	 * 获取
	 * @return filmViews
	 */
	public Integer getFilmViews() {
		return filmViews;
	}

	/**
	 * 设置
	 * @param filmViews
	 */
	public void setFilmViews(Integer filmViews) {
		this.filmViews = filmViews;
	}

	/**
	 * 获取
	 * @return filmAuthor
	 */
	public String getFilmAuthor() {
		return filmAuthor;
	}

	/**
	 * 设置
	 * @param filmAuthor
	 */
	public void setFilmAuthor(String filmAuthor) {
		this.filmAuthor = filmAuthor;
	}

	/**
	 * 获取
	 * @return filmIntro
	 */
	public String getFilmIntro() {
		return filmIntro;
	}

	/**
	 * 设置
	 * @param filmIntro
	 */
	public void setFilmIntro(String filmIntro) {
		this.filmIntro = filmIntro;
	}

	/**
	 * 获取
	 * @return filmImage
	 */
	public String getFilmImage() {
		return filmImage;
	}

	/**
	 * 设置
	 * @param filmImage
	 */
	public void setFilmImage(String filmImage) {
		this.filmImage = filmImage;
	}

	/**
	 * 获取
	 * @return filmVideo
	 */
	public String getFilmVideo() {
		return filmVideo;
	}

	/**
	 * 设置
	 * @param filmVideo
	 */
	public void setFilmVideo(String filmVideo) {
		this.filmVideo = filmVideo;
	}

	/**
	 * 获取
	 * @return status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 设置
	 * @param status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	public String toString() {
		return "Film{filmId = " + filmId + ", filmName = " + filmName + ", filmType = " + filmType + ", filmIdId = " + filmIdId + ", filmTime = " + filmTime + ", filmViews = " + filmViews + ", filmAuthor = " + filmAuthor + ", filmIntro = " + filmIntro + ", filmImage = " + filmImage + ", filmVideo = " + filmVideo + ", status = " + status + "}";
	}
}
