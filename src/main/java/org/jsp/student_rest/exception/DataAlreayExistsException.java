package org.jsp.student_rest.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DataAlreayExistsException extends RuntimeException {
	String message = "Data already exists";
}
