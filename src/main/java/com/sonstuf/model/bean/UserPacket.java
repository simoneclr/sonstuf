package com.sonstuf.model.bean;

import com.fasterxml.jackson.annotation.JsonFilter;

/**
 * @author hypertesto
 */
@JsonFilter("userFilter")
public class UserPacket {

	private String name;
	private double rankR;
	private double rankO;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRankR() {
		return rankR;
	}

	public void setRankR(double rankR) {
		this.rankR = rankR;
	}

	public double getRankO() {
		return rankO;
	}

	public void setRankO(double rankO) {
		this.rankO = rankO;
	}
}
