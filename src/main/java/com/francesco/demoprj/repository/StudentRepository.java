package com.francesco.demoprj.repository;

import com.francesco.demoprj.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Integer> {


    Optional<Student> findStudentByName(String nome);
}
