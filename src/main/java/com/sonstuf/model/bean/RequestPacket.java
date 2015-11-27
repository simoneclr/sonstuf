package com.sonstuf.model.bean;

import com.fasterxml.jackson.annotation.JsonFilter;

/**
 * @author hypertesto
 */
@JsonFilter("requestFilter")
public class RequestPacket {

	private String category;
	private String place;
	private String time;
	private String postTimestamp;
	private String description;
	private String title;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPostTimestamp() {
		return postTimestamp;
	}

	public void setPostTimestamp(String postTimestamp) {
		this.postTimestamp = postTimestamp;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle () {
		return title;
	}

	public void setTitle (String title) {
		this.title = title;
	}
}
