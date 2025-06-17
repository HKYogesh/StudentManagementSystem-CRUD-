package org.jsp.student_rest.exception;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(DataAlreayExistsException.class)
	public ResponseEntity<HashMap<String, String>> handle(DataAlreayExistsException exception) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("message", exception.getMessage());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}

	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<HashMap<String, String>> handle() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("message", "url not mapped");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}

	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<HashMap<String, String>> handle(DataNotFoundException exception) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("message", exception.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}

}
