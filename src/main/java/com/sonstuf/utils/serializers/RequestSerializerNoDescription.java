package com.sonstuf.utils.serializers;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.naming.NamingException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.sonstuf.model.CategoryModel;
import com.sonstuf.model.bean.Request;
import com.sonstuf.utils.ProjectGlobals;

public class RequestSerializerNoDescription<T extends Request> extends JsonSerializer<T> {

	@Override
	public void serialize (T o, JsonGenerator jsonGenerator, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		
		SimpleDateFormat sdf;
		
		sdf = new SimpleDateFormat (ProjectGlobals.DATETIME_OUTPUT_FORMAT);
		
		jsonGenerator.writeStartObject ();
		
		try {
			jsonGenerator.writeStringField ("category",
					CategoryModel.getCategoryById (o.getIdCategory ()).getName ());
		} catch (SQLException | NamingException e) {
			
			e.printStackTrace();
		}
		jsonGenerator.writeStringField ("title", o.getTitle ());
		jsonGenerator.writeStringField ("place", o.getPlace ());
		jsonGenerator.writeStringField ("time", o.getDateTime ());
		jsonGenerator.writeStringField ("postTimeStamp", sdf.format (o.getPostTime ()));
		
		jsonGenerator.writeEndObject ();
	}

}
