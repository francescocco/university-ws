package com.francesco.demoprj.controller;

import com.francesco.demoprj.model.Exams;
import com.francesco.demoprj.service.ExamsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/exam")
public class ExamsController {

    private static final Logger logger = LoggerFactory.getLogger(ExamsController.class);

    @Autowired
    private ExamsService examService;

    @GetMapping
    public ResponseEntity<List<Exams>> getAllExamss(){

        List<Exams> exams = examService.retrieveAllExamss();

        if(exams == null || exams.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);


        return new ResponseEntity<>(exams, HttpStatus.OK);
    }

    @GetMapping("/{examId}")
    public ResponseEntity<Exams> getExamsById(@PathVariable Integer examId){

        Exams exams = examService.retrieveExamsById(examId);

        if(exams == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(exams, HttpStatus.OK);

    }


    @PostMapping
    public ResponseEntity<Exams> createExams(@RequestBody Exams examToSave){

        Exams exams = examService.saveExams(examToSave);

        if(exams == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(exams, HttpStatus.OK);
    }

    @DeleteMapping("/{examId}")
    public ResponseEntity<String> deleteExams(@PathVariable Integer examId){
        examService.deleteExamsById(examId);
        Exams deleteExams = examService.retrieveExamsById(examId);

        if(deleteExams != null){
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(String.format("Exams %d correctly deleted!", examId), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Exams> updateExams(@RequestBody Exams exam){
        Exams updatedExams = examService.updateExams(exam);
        if(updatedExams==null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(updatedExams, HttpStatus.OK);
    }

}
