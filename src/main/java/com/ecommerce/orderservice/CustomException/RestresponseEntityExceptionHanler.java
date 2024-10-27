package com.ecommerce.orderservice.CustomException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ecommerce.orderservice.external.response.Errorresponse;

@ControllerAdvice
public class RestresponseEntityExceptionHanler extends ResponseEntityExceptionHandler {
	
	
	@ExceptionHandler(ExcectionCustom.class)
	public ResponseEntity<Errorresponse> handlecustomException(ExcectionCustom exception){
		
		return new ResponseEntity<>(new Errorresponse().builder()
				.errorResponse(exception.getMessage())
				.errorCode(exception.getErrorCode())
				.build(),HttpStatus.valueOf(exception.getStatus()));
		
		
	}

}
