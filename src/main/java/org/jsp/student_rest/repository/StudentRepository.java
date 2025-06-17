package org.jsp.student_rest.repository;

import org.jsp.student_rest.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

	boolean existsByMobile(Long mobile);

}
