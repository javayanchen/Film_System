package com.film.pojo;

import java.util.Date;

/**
 * @author lzl
 * @version 1.0
 * @description: TODO
 * @date 2023/5/11 9:16
 */
public class Comment {
	private Integer commentId;
	private User user;
	private Film film;
	private String content;
	private Date commentTime;


	public Comment() {
	}

	public Comment(Integer commentId, User user, Film film, String content, Date commentTime) {
		this.commentId = commentId;
		this.user = user;
		this.film = film;
		this.content = content;
		this.commentTime = commentTime;
	}

	/**
	 * 获取
	 * @return commentId
	 */
	public Integer getCommentId() {
		return commentId;
	}

	/**
	 * 设置
	 * @param commentId
	 */
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	/**
	 * 获取
	 * @return user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 设置
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 获取
	 * @return film
	 */
	public Film getFilm() {
		return film;
	}

	/**
	 * 设置
	 * @param film
	 */
	public void setFilm(Film film) {
		this.film = film;
	}

	/**
	 * 获取
	 * @return content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 设置
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 获取
	 * @return commentTime
	 */
	public Date getCommentTime() {
		return commentTime;
	}

	/**
	 * 设置
	 * @param commentTime
	 */
	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

	public String toString() {
		return "Comment{commentId = " + commentId + ", user = " + user + ", film = " + film + ", content = " + content + ", commentTime = " + commentTime + "}";
	}
}
