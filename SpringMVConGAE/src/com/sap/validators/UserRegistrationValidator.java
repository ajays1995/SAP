package com.sap.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sap.form.UserRegistrationInput;

public class UserRegistrationValidator implements Validator 
{
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"  
			   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";  
	private String MOBILE_PATTERN = "[0-9]{10}";
	private Pattern pattern;  
	private Matcher matcher;  

	@Override
	public boolean supports(Class<?> clazz) 
	{
		return UserRegistrationInput.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) 
	{
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "required.firstName","First Name is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "required.lastName","Last Name is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "required.gender","Gender is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.email","Email is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "required.phoneNumber","Phone Number is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.password","Password is required");
		
		UserRegistrationInput ui = (UserRegistrationInput)target;
		
		if(!ui.getPassword().equals(ui.getConfirmPassword()))
		{
			errors.reject("password", "notmatch.password");
		}
		
		if(ui.getEmail()!=null && !ui.getEmail().isEmpty())
		{
			pattern = Pattern.compile(EMAIL_PATTERN);
			matcher = pattern.matcher(ui.getEmail());
			
			if(!matcher.matches())
			{
				errors.reject("email", "email.notdesiredformat");
			}
		}
		if(ui.getPhoneNumber()!=null && !ui.getPhoneNumber().isEmpty())
		{
			pattern = Pattern.compile(MOBILE_PATTERN);
			matcher = pattern.matcher(ui.getPhoneNumber());
			
			if(!matcher.matches())
			{
				errors.reject("phoneNumber", "phoneNumber.notdesiredformat");
			}
		}
		
		
	}

}
