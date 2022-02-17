package com.kata.raoul.services.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kata.raoul.domain.Client;
import com.kata.raoul.domain.Operation;
import com.kata.raoul.domain.OperationType;
import com.kata.raoul.repository.OperationRepository;
import com.kata.raoul.services.IClientService;
import com.kata.raoul.services.IOperationService;

@Component
public class OperationService implements IOperationService {
	
	@Autowired
	IClientService clientService;
	
	@Autowired
	OperationRepository operationRepository;

	@Transactional
	@Override
	public void makeClientOperation(Operation operation) throws Exception {
		operationRepository.save(operation);
		Client client = clientService.getClientInfo(operation.getClient().getId());
		if (client != null) {
			OperationType operationType = operation.getOperationType();
			BigDecimal currentBalance = client.getCurrentBalance();
			boolean needsUpdate = false;
			if (operationType.getId().equals(OperationType.DEPOSIT)) {
				client.setCurrentBalance(currentBalance.add(operation.getAmount()));
				needsUpdate = true;
			} else if (operationType.getId().equals(OperationType.DEPOSIT)) {
				client.setCurrentBalance(currentBalance.subtract(operation.getAmount()));
				needsUpdate = true;
			}
			if (needsUpdate)
				clientService.saveClient(client);
		}
	}
	
	@Override
	public List<Operation> getClientOperations(Long clientId, Date dateFrom, Date dateTo) throws Exception {
		// TODO Auto-generated method stub
		return operationRepository.getOperations(clientId, dateFrom, dateTo);
	}

}
