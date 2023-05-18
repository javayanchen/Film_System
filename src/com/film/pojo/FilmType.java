package com.film.pojo;

/**
 * @author lzl
 * @version 1.0
 * @description: TODO
 * @date 2023/5/11 9:16
 */

public class FilmType {
	private Integer TypeId;
	private String TypeName;


	public FilmType() {
	}

	public FilmType(Integer TypeId, String TypeName) {
		this.TypeId = TypeId;
		this.TypeName = TypeName;
	}

	/**
	 * 获取
	 * @return TypeId
	 */
	public Integer getTypeId() {
		return TypeId;
	}

	/**
	 * 设置
	 * @param TypeId
	 */
	public void setTypeId(Integer TypeId) {
		this.TypeId = TypeId;
	}

	/**
	 * 获取
	 * @return TypeName
	 */
	public String getTypeName() {
		return TypeName;
	}

	/**
	 * 设置
	 * @param TypeName
	 */
	public void setTypeName(String TypeName) {
		this.TypeName = TypeName;
	}

	public String toString() {
		return "FilmType{TypeId = " + TypeId + ", TypeName = " + TypeName + "}";
	}
}
