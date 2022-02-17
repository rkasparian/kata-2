package com.kata.raoul.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kata.raoul.domain.Operation;

public interface OperationRepository extends CrudRepository<Operation, Long> {
	
	List<Operation> getOperations(long clientId, Date dateFrom, Date dateTo);

}
