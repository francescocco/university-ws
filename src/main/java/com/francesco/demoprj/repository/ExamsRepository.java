package com.francesco.demoprj.repository;

import com.francesco.demoprj.model.Exams;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ExamsRepository extends CrudRepository<Exams, Integer> {


    Optional<Exams> findExamsByCodiceEsame(Integer code);
}
