package com.rafael.cursomc.services.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = ClienteUpdateValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ClienteUpdate {

	/*public ClienteInsert() {
		// TODO Auto-generated constructor stub
	}*/

	String message() default "Erro de Validação";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
