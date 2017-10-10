package com.pravin.component;

import java.util.ArrayList;
import java.util.List;

import com.pravin.domain.FieldErrorMessage;
import com.pravin.domain.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author Pravin Pachbhai
 * 
 */

@ControllerAdvice
public class ControllerValidationHandler {

	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ValidationError processValidationError(final MethodArgumentNotValidException ex){
		ValidationError validationError = new ValidationError();
		final BindingResult bindingResult = ex.getBindingResult();
		List<FieldError> errors =  bindingResult.getFieldErrors();
		for (FieldError fieldError: errors) {
			validationError.addMessage(new FieldErrorMessage(fieldError.getField(), fieldError.getDefaultMessage()));
		}
		return validationError;
	}
	
}
