package com.sonstuf.model.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Bean della categoria
 * Created by hypertesto on 17/11/15.
 */
public class Category {

	private int idCategory;
	private String name;
	private String description;

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
