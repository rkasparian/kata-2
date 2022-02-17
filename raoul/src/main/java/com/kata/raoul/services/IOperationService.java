package com.kata.raoul.services;

import java.util.Date;
import java.util.List;

import com.kata.raoul.domain.Operation;

public interface IOperationService {

	public void makeClientOperation(Operation operation) throws Exception;
	
	public List<Operation> getClientOperations(Long clientId, Date dateFrom, Date dateTo) throws Exception;
	
}
