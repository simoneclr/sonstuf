package com.sonstuf.utils.serializers;

import java.io.IOException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.sonstuf.model.bean.User;
import com.sonstuf.utils.ProjectGlobals;

public class UserSerializer<T extends User> extends JsonSerializer<T> {
	
	@Override
	public void serialize (T object, JsonGenerator jsonGenerator, SerializerProvider arg2)
			throws IOException, JsonProcessingException {
		
		SimpleDateFormat sdf;
		
		sdf = new SimpleDateFormat (ProjectGlobals.DATE_OUTPUT_FORMAT);
		
		jsonGenerator.writeStartObject ();
		
		jsonGenerator.writeNumberField ("idUser", object.getIdUser ());
		jsonGenerator.writeStringField ("name", object.getName ());
		jsonGenerator.writeStringField ("surname", object.getSurname ());
		jsonGenerator.writeStringField ("telephone", object.getPhone ());
		jsonGenerator.writeStringField ("email", object.getEmail ());
		jsonGenerator.writeStringField ("bithdate", sdf.format (object.getBirthDate ()));
		jsonGenerator.writeNumberField ("rankO", object.getRankO ());
		jsonGenerator.writeNumberField ("rankR", object.getRankR ());
		
		
		jsonGenerator.writeEndObject ();
	}

}
