package com.sonstuf.utils.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.sonstuf.model.CategoryModel;
import com.sonstuf.model.bean.Request;
import com.sonstuf.utils.ProjectGlobals;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.TreeSet;

public class RequestSerializer<T extends Request> extends JsonSerializer<T> {
	private Set<String> attributesToSerialize;

	public RequestSerializer() {
		super();

		attributesToSerialize = null;
	}

	public RequestSerializer(String... attributes) {
		super();

		attributesToSerialize = new TreeSet<>();

		for (String attribute : attributes) {
			attributesToSerialize.add(attribute);
		}
	}


	@Override
	public void serialize(T o, JsonGenerator jsonGenerator, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		jsonGenerator.writeStartObject();

		if (attributesToSerialize == null || attributesToSerialize.contains("idRequest"))
			jsonGenerator.writeNumberField("idRequest", o.getIdRequest());

		if (attributesToSerialize == null || attributesToSerialize.contains("title"))
			jsonGenerator.writeStringField("title", o.getTitle());

		if (attributesToSerialize == null || attributesToSerialize.contains("description"))
			jsonGenerator.writeStringField("description", o.getDescription());

		if (attributesToSerialize == null || attributesToSerialize.contains("place"))
			jsonGenerator.writeStringField("place", o.getPlace());

		if (attributesToSerialize == null || attributesToSerialize.contains("datetime"))
			jsonGenerator.writeStringField("datetime", o.getDateTime());

		if (attributesToSerialize == null || attributesToSerialize.contains("photo"))
			jsonGenerator.writeStringField("photo", o.getPhoto());

		if (attributesToSerialize == null || attributesToSerialize.contains("idUser"))
			jsonGenerator.writeNumberField("idUser", o.getIdUser());

		if (attributesToSerialize == null || attributesToSerialize.contains("idCategory"))
			jsonGenerator.writeNumberField("idCategory", o.getIdCategory());

		if (attributesToSerialize == null || attributesToSerialize.contains("category"))
			try {
				jsonGenerator.writeStringField("category",
						CategoryModel.getCategoryById(o.getIdCategory()).getName());
			} catch (SQLException | NamingException e) {

				e.printStackTrace();
			}

		if (attributesToSerialize == null || attributesToSerialize.contains("status"))
			jsonGenerator.writeNumberField("status", o.getStatus());

		if (attributesToSerialize == null || attributesToSerialize.contains("postTimeStamp")) {
			SimpleDateFormat df = new SimpleDateFormat(ProjectGlobals.DATE_OUTPUT_FORMAT);
			String formattedDate = df.format(o.getPostTime());
			jsonGenerator.writeStringField("postTimeStamp", formattedDate);
		}

		if (attributesToSerialize == null || attributesToSerialize.contains("time")) {
			jsonGenerator.writeStringField("time", o.getDateTime());
		}


		jsonGenerator.writeEndObject();

		provider.getFilterProvider();
	}

}
