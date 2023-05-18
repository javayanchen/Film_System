package com.film.pojo;

import java.util.Date;

/**
 * @author lzl
 * @version 1.0
 * @description: 用户实体类
 * @date 2023/5/11 9:16
 */
public class User {
	private Integer userId;
	private String userName;
	private String userPassword;
	private String email;
	private Role role;
	private Date createTime;
	private Integer status;


	public User() {
	}

	public User(Integer userId, String userName, String userPassword, String email, Role role, Date createTime, Integer status) {
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.email = email;
		this.role = role;
		this.createTime = createTime;
		this.status = status;
	}

	/**
	 * 获取
	 * @return userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * 设置
	 * @param userId
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * 获取
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 获取
	 * @return userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * 设置
	 * @param userPassword
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * 获取
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 设置
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 获取
	 * @return role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * 设置
	 * @param role
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * 获取
	 * @return createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
		return "User{userId = " + userId + ", userName = " + userName + ", userPassword = " + userPassword + ", email = " + email + ", role = " + role + ", createTime = " + createTime + ", status = " + status + "}";
	}
}
