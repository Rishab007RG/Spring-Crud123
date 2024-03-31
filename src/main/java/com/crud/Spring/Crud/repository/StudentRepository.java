package com.crud.Spring.Crud.repository;

import com.crud.Spring.Crud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface StudentRepository extends JpaRepository<Student, Long > {
    //all crud methods

}
