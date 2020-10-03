package com.example.Credicxo.reporistory;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.Credicxo.modal.PerformaceEntity;

public interface performanceRepository extends CrudRepository<PerformaceEntity, Integer> {

	public PerformaceEntity findByEmailaddress(String emailaddress);
	
	
	@Query(value = "select top 10 * from  Performace_Entity order by percentage desc",nativeQuery = true)
	public List<PerformaceEntity> foo();
}