package org.jsp.student_rest.entity;

import org.jsp.student_rest.dto.StudentDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Student {
	@Id
	@GeneratedValue(generator = "id")
	@SequenceGenerator(initialValue = 101001, allocationSize = 1, name = "id")
	private int id;
	private String name;
	private Long mobile;
	private Integer maths;
	private Integer science;
	private Integer english;
	private Double percentage;

	public Student(StudentDTO dto) {
		this.name = dto.getName();
		this.mobile = dto.getMobile();
		this.english = dto.getEnglish();
		this.maths = dto.getMaths();
		this.science = dto.getScience();
		this.percentage = (dto.getEnglish() + dto.getMaths() + dto.getScience()) / 3.0;
	}
}
