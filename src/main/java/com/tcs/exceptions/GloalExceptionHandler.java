package com.tcs.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tcs.payload.ApiResponse;

@RestControllerAdvice
public class GloalExceptionHandler {

	@ExceptionHandler(ResourceNotfoundexceptions.class)
	public ResponseEntity<ApiResponse> resourceNotfound(ResourceNotfoundexceptions ex) {

		String message = ex.getMessage();

		ApiResponse apireponse = new ApiResponse(message, false);

		apireponse.setMassage(message);

		return new ResponseEntity<ApiResponse>(new ApiResponse(message, true), HttpStatus.OK);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>>handelmethodArgNotvalidException(MethodArgumentNotValidException ex) {
		
		Map<String, String>resp=new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error)->{
			
		      String field = ((FieldError)error).getField();
		      String message = error.getDefaultMessage();
		      resp.put(field, message);
		});
		
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
	}


	
}
