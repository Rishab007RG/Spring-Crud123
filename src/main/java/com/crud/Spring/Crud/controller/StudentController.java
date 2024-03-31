package com.crud.Spring.Crud.controller;

import com.crud.Spring.Crud.exception.ResourceNotFoundException;
import com.crud.Spring.Crud.model.Student;
import com.crud.Spring.Crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/students")
public class  StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getEmployeeById(@PathVariable long id) {
        Student employee = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
        return ResponseEntity.ok(employee);
    }


    @PutMapping("{id}")
    public ResponseEntity<Student> updateEmployee(@PathVariable long id, @RequestBody Student studentDetails) {
        Student updateStudents = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        updateStudents.setName(studentDetails.getName());
        updateStudents.setEmail(studentDetails.getEmail());
        updateStudents.setDateOfBirth(studentDetails.getDateOfBirth());

        studentRepository.save(updateStudents);

        return ResponseEntity.ok(updateStudents);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id) {

        Student student = studentRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        studentRepository.delete(student);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}