package com.example.Credicxo.reporistory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Credicxo.modal.SignUpData;
@Repository
public interface SignUpdataRepository extends CrudRepository<SignUpData, Integer> {

}
