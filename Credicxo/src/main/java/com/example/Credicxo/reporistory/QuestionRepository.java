package com.example.Credicxo.reporistory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Credicxo.modal.QuestionEntity;
import com.example.Credicxo.modal.SignUpData;

@Repository
public interface QuestionRepository extends CrudRepository<QuestionEntity, Integer> {

}
