package org.jsp.student_rest.service;

import java.util.ArrayList;
import java.util.List;

import org.jsp.student_rest.dto.StudentDTO;
import org.jsp.student_rest.entity.Student;
import org.jsp.student_rest.exception.DataAlreayExistsException;
import org.jsp.student_rest.exception.DataNotFoundException;
import org.jsp.student_rest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	@Autowired
	StudentRepository repository;

	public Student saveStudent(StudentDTO dto) {
		if (!repository.existsByMobile(dto.getMobile())) {
			Student student = new Student(dto);
			repository.save(student);
			return student;
		} else {
			throw new DataAlreayExistsException("Mobile Number Already Exists " + dto.getMobile());
		}
	}

	public List<Student> saveMultipleStudents(List<StudentDTO> dtos) {
		List<Student> students = new ArrayList<Student>();
		for (StudentDTO dto : dtos) {
			if (repository.existsByMobile(dto.getMobile())) {
				throw new DataAlreayExistsException("Mobile number already exists : " + dto.getMobile());
			} else {
				students.add(repository.save(new Student(dto)));
			}
		}
		return students;
	}

	public Page<Student> fetchStudent(String sort, boolean desc, int page, int data) {
		Sort sortBasedOn = Sort.by(sort);
		if (desc) {
			sortBasedOn = sortBasedOn.descending();
		}

		Pageable pageable = PageRequest.of(page - 1, data, sortBasedOn);
		Page<Student> records = repository.findAll(pageable);

		if (!records.isEmpty()) {
			return records;
		} else {
			throw new DataNotFoundException();
		}
	}

	public Object deleteRecord(long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return "Deleted Successfully";
		} else {
			throw new DataNotFoundException("Id doesn't exist");
		}
	}

	public Object updateRecord(Student student) {
		repository.save(student);
		return "Updated Successfully";
	}

}
