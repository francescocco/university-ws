package com.francesco.demoprj.controller;

import com.francesco.demoprj.model.Student;
import com.francesco.demoprj.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "/api/v2/students")
public class StudentControllerHateoas {


    @Autowired
    private StudentService studentService;


    @GetMapping
    public ResponseEntity<CollectionModel<Student>> getAllStudents(){

        List<Student> students = studentService.retrieveAllStudents();

        if(students == null || students.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        students.forEach(student -> {
            Link selfLink = linkTo(StudentController.class).slash(student.getId()).withSelfRel();
            student.add(selfLink);
        });
        CollectionModel<Student> result = CollectionModel.of(students);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EntityModel<Student>> createStudent(@Valid @RequestBody Student studentToSave){

        Student student = studentService.saveStudent(studentToSave);

        if(student == null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Link selfLink = linkTo(StudentController.class).slash(student.getId()).withSelfRel();
        student.add(selfLink);
        return new ResponseEntity<>(EntityModel.of(student), HttpStatus.CREATED);
    }



//    @DeleteMapping("/{studentId}")
//    public ResponseEntity<String> deleteStudent(@PathVariable Integer studentId){
//        studentService.deleteStudentById(studentId);
//        Student deleteStudent = studentService.retrieveStudentById(studentId);
//
//        if(deleteStudent != null){
//            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//        return new ResponseEntity<>(String.format("Student %d correctly deleted!", studentId), HttpStatus.OK);
//    }
//
//    @PutMapping
//    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
//        Student updatedStudent = studentService.updateStudent(student);
//        if(updatedStudent==null){
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
//    }
}

