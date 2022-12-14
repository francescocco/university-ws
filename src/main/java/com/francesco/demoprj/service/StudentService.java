package com.francesco.demoprj.service;

import com.francesco.demoprj.model.Student;
import com.francesco.demoprj.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> retrieveAllStudents() {

        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(student -> students.add(student));

        return students;
    }

    public Student retrieveStudentById(Integer id){

        Optional<Student> studentOptional = studentRepository.findById(id);

        return studentOptional.orElse(null);
    }

    public Student saveStudent(Student studentToSave){

        if(studentToSave.getName() == null || studentToSave.getSurname().isEmpty())
            return null;

        Optional<Student> checkedClient = studentRepository.findStudentByName(studentToSave.getName());

        if(checkedClient.isPresent())
            return null;

        return studentRepository.save(studentToSave);

    }

    public void deleteStudentById(Integer id){
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Student studentToUpdate){

        if(studentToUpdate.getId() == null)
            return null;
        Optional<Student> checkedStudent = studentRepository.findStudentByName(studentToUpdate.getName());

        if(checkedStudent.isPresent())
            return null;

        return studentRepository.save(studentToUpdate);
    }

}
