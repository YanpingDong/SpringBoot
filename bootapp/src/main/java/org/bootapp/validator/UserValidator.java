package org.bootapp.validator;

import org.bootapp.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(target instanceof User)
		{
			ValidationUtils.rejectIfEmpty(errors, "id", null,"Id is empty.");
			User user = (User) target;
			if( user.getName().equalsIgnoreCase(""))
			{
				errors.rejectValue("name", "401", "please imput name");
			}	
		}
		
			
	}
	
}