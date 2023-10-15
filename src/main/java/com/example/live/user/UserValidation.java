package com.example.live.user;

import java.util.regex.Pattern;

public class UserValidation {

	public static boolean patternMatches(String emailAddress, String regexPattern) {
		return Pattern.compile(regexPattern)
				.matcher(emailAddress)
				.matches();
	}

	public static boolean testEmail(String emailAddress ) throws Exception {
		String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
				+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		if (patternMatches(emailAddress, regexPattern))
			return(patternMatches(emailAddress, regexPattern));
		else throw new Exception("Wrong email");

	}


	public static boolean testPhone(String emailAddress ) throws Exception {
		String regexPattern= "^(\\\\+\\\\d{1,3}( )?)?((\\\\(\\\\d{3}\\\\))|\\\\d{3})[- .]?\\\\d{3}[- .]?\\\\d{4}$" 
				+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$" 
				+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
		if (patternMatches(emailAddress, regexPattern))
			return(patternMatches(emailAddress, regexPattern));
		else throw new Exception("Wrong phone format");
	}




}
