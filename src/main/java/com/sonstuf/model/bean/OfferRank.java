package com.sonstuf.model.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class OfferRank {
	
	private int idRank;
	private int rank;
	private String comment;

	/**
	 * @return the idRank
	 */

	public int getIdRank () {
		return idRank;
	}
	/**
	 * @param idRank the idRank to set
	 */

	public void setIdRank (int idRank) {
		this.idRank = idRank;
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
