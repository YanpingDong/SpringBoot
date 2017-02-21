package org.bootapp.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.bootapp.model.CompositeObjectData;
import org.bootapp.validator.constraints.CompositeObjectNotEmpty;

public class CompositeValidation implements ConstraintValidator<CompositeObjectNotEmpty,CompositeObjectData>{

	@Override
	public void initialize(CompositeObjectNotEmpty constraintAnnotation) {		
	}

	@Override
	public boolean isValid(CompositeObjectData value,
			ConstraintValidatorContext context) {
		if(value.getMap() != null && !value.getMap().isEmpty())
		   return true;
		return false;
	}

}
