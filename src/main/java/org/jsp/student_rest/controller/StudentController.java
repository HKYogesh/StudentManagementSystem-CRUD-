package org.jsp.student_rest.controller;

import java.util.List;

import org.jsp.student_rest.dto.StudentDTO;
import org.jsp.student_rest.entity.Student;
import org.jsp.student_rest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RequestMapping("/api/v1/")
@RestController // combination of @Controller & @ResponseBody
public class StudentController {
	@Autowired
	StudentService service;

	// save a record
	@PostMapping("/student")
	@Operation(summary = "Add Record")
	public ResponseEntity<Student> saveStudent(@RequestBody StudentDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.saveStudent(dto));
	}

	// save multiple records
	@PostMapping("/students")
	@Operation(summary = "Add Multiple Records")
	public ResponseEntity<List<Student>> saveMultipleStudents(@RequestBody List<StudentDTO> dtos) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.saveMultipleStudents(dtos));
	}

	// fetch all records
	@GetMapping("/fetch_student")
	@Operation(summary = "Fetch Records")
	public ResponseEntity<Page<Student>> fetchStudent(@RequestParam(defaultValue = "id") String sort,
			@RequestParam(defaultValue = "false") boolean desc, @RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int data) {
		return ResponseEntity.status(HttpStatus.OK).body(service.fetchStudent(sort, desc, page, data));
	}

	// Delete Records
	@DeleteMapping("/student/{id}")
	@Operation(summary = "Delete By ID")
	public ResponseEntity<Object> deleteRecord(@PathVariable long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.deleteRecord(id));
	}

	// Update Records
	@PutMapping("/student")
	@Operation(summary = "Update Record")
	public ResponseEntity<Object> updateRecord(@RequestBody Student student) {
		return ResponseEntity.status(HttpStatus.OK).body(service.updateRecord(student));
	}
}
