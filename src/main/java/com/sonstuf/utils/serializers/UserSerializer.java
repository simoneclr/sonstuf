package com.sonstuf.utils.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.sonstuf.model.bean.User;
import com.sonstuf.utils.ProjectGlobals;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.TreeSet;

public class UserSerializer<T extends User> extends JsonSerializer<T> {
	
	private Set<String> attributesToSerialize;
	
	public UserSerializer () {
		super ();
		
		attributesToSerialize = null;
	}
	
	public UserSerializer (String... attributes) {
		super ();
		
		attributesToSerialize = new TreeSet<String> ();
		
		for (String attribute : attributes) {
			attributesToSerialize.add (attribute);
		}
	}
	
	@Override
	public void serialize (T object, JsonGenerator jsonGenerator, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		
		SimpleDateFormat sdf;
		
		sdf = new SimpleDateFormat (ProjectGlobals.DATE_OUTPUT_FORMAT);
		
		jsonGenerator.writeStartObject ();
		
		if (attributesToSerialize == null || attributesToSerialize.contains ("idUser"))
			jsonGenerator.writeNumberField ("idUser", object.getIdUser ());
		
		if (attributesToSerialize == null || attributesToSerialize.contains ("name"))
			jsonGenerator.writeStringField ("name", object.getName ());

		if (attributesToSerialize == null || attributesToSerialize.contains ("surname"))
			jsonGenerator.writeStringField ("surname", object.getSurname ());

		if (attributesToSerialize == null || attributesToSerialize.contains ("telephone"))
			jsonGenerator.writeStringField ("telephone", object.getPhone ());

		if (attributesToSerialize == null || attributesToSerialize.contains ("email"))
			jsonGenerator.writeStringField ("email", object.getEmail ());

		if (attributesToSerialize == null || attributesToSerialize.contains ("birthdate"))
			jsonGenerator.writeStringField ("birthdate", sdf.format (object.getBirthDate ()));

		if (attributesToSerialize == null || attributesToSerialize.contains ("rankO"))
			jsonGenerator.writeNumberField ("rankO", object.getRankO ());

		if (attributesToSerialize == null || attributesToSerialize.contains ("rankR"))
			jsonGenerator.writeNumberField ("rankR", object.getRankR ());
		
		jsonGenerator.writeEndObject ();
	}

}
