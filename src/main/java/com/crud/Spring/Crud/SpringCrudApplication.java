package com.crud.Spring.Crud;

import com.crud.Spring.Crud.model.Student;
import com.crud.Spring.Crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.time.LocalDate;


@SpringBootApplication
public class SpringCrudApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;
	@Override
	public void run(String... args) throws Exception {
		Student student = new Student();
		student.setName("Gok");
		student.setEmail("gokul@gmail.com");
		Date dateOfBirth = new Date(System.currentTimeMillis());
		student.setDateOfBirth(dateOfBirth);
		studentRepository.save(student);

		Student student1 = new Student();
		student1.setName("Rishab");
		student1.setEmail("rishu@gmail.com");
//		Date dateOfBirth1 = new Date(System.currentTimeMillis());
//		student1.setDateOfBirth(dateOfBirth1);
		LocalDate dateOfBirth2 = LocalDate.of(1995, 8, 15); // Example date
		student1.setDateOfBirth(Date.valueOf(dateOfBirth2));
		studentRepository.save(student1);

		//Postman Link:
		//http://localhost:8080/api/v1/students
		//http://localhost:8080/api/v1/students
		//http://localhost:8080/api/v1/students/7
		//http://localhost:8080/api/v1/students/3
		//http://localhost:8080/api/v1/students/5

	}
}
