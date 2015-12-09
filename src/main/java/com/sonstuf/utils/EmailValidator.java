package com.sonstuf.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
	
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			
	public static boolean validateEmail (String emailAddress) {
		
		Pattern pattern;
		Matcher matcher;
		
		pattern = Pattern.compile (EMAIL_PATTERN);
		matcher = pattern.matcher (emailAddress);
		
		return matcher.matches ();
	}
}
