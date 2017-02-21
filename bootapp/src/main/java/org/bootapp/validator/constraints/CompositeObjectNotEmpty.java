package org.bootapp.validator.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.bootapp.validator.CompositeValidation;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=CompositeValidation.class)
public @interface  CompositeObjectNotEmpty {
	
	String message() default"CompositeObject can not be empty";  
    
	Class<?>[] groups() default {};  
	      
    Class<? extends Payload>[] payload() default {}; 
}
