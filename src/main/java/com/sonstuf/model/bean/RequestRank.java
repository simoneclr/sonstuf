package com.sonstuf.model.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class RequestRank {
	
	private int idRequest;
	private int rank;
	private String comment;

	/**
	 * @return the idRequest
	 */
	public int getIdRequest() {
		return idRequest;
	}

	/**
	 * @param idRequest the idRequest to set
	 */
	public void setIdRequest(int idRequest) {
		this.idRequest = idRequest;
	}

	/**
	 * @return the rank
	 */
	public int getRank () {
		return rank;
	}

	/**
	 * @param rank the rank to set
	 */
	public void setRank (int rank) {
		this.rank = rank;
	}

	/**
	 * @return the comment
	 */
	public String getComment () {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment (String comment) {
		this.comment = comment;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
