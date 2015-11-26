package com.sonstuf.utils;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface JsonPacket {
	
	public String toJSON () throws JsonProcessingException;
}
