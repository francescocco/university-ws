package com.francesco.demoprj.service;

import com.francesco.demoprj.model.Exams;
import com.francesco.demoprj.repository.ExamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExamsService {

    @Autowired
    ExamsRepository examRepository;

    public List<Exams> retrieveAllExamss() {

        List<Exams> exams = new ArrayList<>();
        examRepository.findAll().forEach(exam -> exams.add(exam));

        return exams;
    }

    public Exams retrieveExamsById(Integer id){

        Optional<Exams> examOptional = examRepository.findById(id);

        return examOptional.orElse(null);
    }

    public Exams saveExams(Exams examToSave){

        if(examToSave.getCodiceEsame() == null || examToSave.getNomeEsame().isEmpty())
            return null;

        Optional<Exams> checkedClient = examRepository.findExamsByCodiceEsame(examToSave.getCodiceEsame());

        if(checkedClient.isPresent())
            return null;

        return examRepository.save(examToSave);

    }

    public void deleteExamsById(Integer id){
        examRepository.deleteById(id);
    }

    public Exams updateExams(Exams examToUpdate){

        if(examToUpdate.getId() == null)
            return null;

        Optional<Exams> checkedExams = examRepository.findExamsByCodiceEsame(examToUpdate.getCodiceEsame());

        if(checkedExams.isPresent())
            return null;

        return examRepository.save(examToUpdate);
    }

}
