package com.sonstuf.utils.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.sonstuf.model.bean.RequestRank;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;


public class RequestRankSerializer<T extends RequestRank> extends JsonSerializer<T> {
	private final Set<String> attributesToSerialize;

	public RequestRankSerializer() {
		super();
		attributesToSerialize = null;
	}

	public RequestRankSerializer(String... attributes) {
		super();
		attributesToSerialize = new TreeSet<>();
		for (String attribute : attributes) {
			attributesToSerialize.add(attribute);
		}
	}

	@Override
	public void serialize(T o, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException {
		jsonGenerator.writeStartObject();
		if (attributesToSerialize == null || attributesToSerialize.contains("idRequest"))
			jsonGenerator.writeNumberField("idRequest", o.getIdRequest());

		if (attributesToSerialize == null || attributesToSerialize.contains("rank"))
			jsonGenerator.writeNumberField("rank", o.getRank());

		if (attributesToSerialize == null || attributesToSerialize.contains("comment"))
			jsonGenerator.writeStringField("comment", o.getComment());

		jsonGenerator.writeEndObject();

		provider.getFilterProvider();
	}
}
