package com.film.pojo;

/**
 * @author lzl
 * @version 1.0
 * @description: 角色类
 * @date 2023/5/11 9:16
 */
public class Role {
	private Integer roleId;
	private String roleName;


	public Role() {
	}

	public Role(Integer roleId, String roleName) {
		this.roleId = roleId;
		this.roleName = roleName;
	}

	/**
	 * 获取
	 * @return roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * 设置
	 * @param roleId
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 * 获取
	 * @return roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * 设置
	 * @param roleName
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String toString() {
		return "Role{roleId = " + roleId + ", roleName = " + roleName + "}";
	}
}
