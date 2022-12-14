package com.francesco.demoprj.controller;

import com.francesco.demoprj.model.Student;
import com.francesco.demoprj.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/students")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){

        List<Student> students = studentService.retrieveAllStudents();

        if(students == null || students.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);


        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer studentId){

        Student students = studentService.retrieveStudentById(studentId);

        if(students == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(students, HttpStatus.OK);

    }


    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student studentToSave){

        Student students = studentService.saveStudent(studentToSave);

        if(students == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer studentId){
        studentService.deleteStudentById(studentId);
        Student deleteStudent = studentService.retrieveStudentById(studentId);

        if(deleteStudent != null){
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(String.format("Student %d correctly deleted!", studentId), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        Student updatedStudent = studentService.updateStudent(student);
        if(updatedStudent==null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }
}

