package com.kata.raoul.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kata.raoul.wrappers.ResponseWrapper;
import com.kata.raoul.domain.Client;
import com.kata.raoul.domain.Operation;
import com.kata.raoul.domain.OperationType;
import com.kata.raoul.beans.request.OperationRequestBean;
import com.kata.raoul.beans.request.StatementRequestBean;
import com.kata.raoul.beans.response.SummaryResponseBean;
import com.kata.raoul.services.IClientService;
import com.kata.raoul.services.IOperationService;

@RestController
@RequestMapping("/operations")
public class OperationsController {

	@Autowired
	protected IOperationService operationServices;

	@Autowired
	protected IClientService clientServices;
	
	protected static Log LOG = LogFactory.getLog(OperationsController.class.getName());
	
	@PostMapping("/deposit")
	public ResponseEntity<ResponseWrapper> makeClientDeposit(@RequestBody OperationRequestBean operationRequest)
	{
		try {
			operationServices.makeClientOperation(new Operation(new OperationType(OperationType.DEPOSIT), new Client(operationRequest.getClientId()), operationRequest.getAmount(), operationRequest.getDate()));
		} catch (Exception e) {
			//log exception here
			String localizedMessage = e.getLocalizedMessage();
			System.out.println(localizedMessage);
			LOG.error(localizedMessage);
			return new ResponseEntity<ResponseWrapper>(new ResponseWrapper(e), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<ResponseWrapper>(HttpStatus.OK);
	}

	@PostMapping("/withdrawal")
	public ResponseEntity<ResponseWrapper> makeClientWithdrawal(@RequestBody OperationRequestBean operationRequest)
	{
		try {
			operationServices.makeClientOperation(new Operation(new OperationType(OperationType.WITHDRAWAL), new Client(operationRequest.getClientId()), operationRequest.getAmount(), operationRequest.getDate()));
		} catch (Exception e) {
			//log exception here
			String localizedMessage = e.getLocalizedMessage();
			System.out.println(localizedMessage);
			LOG.error(localizedMessage);
			return new ResponseEntity<ResponseWrapper>(new ResponseWrapper(e), HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<ResponseWrapper>(HttpStatus.OK);
	}

	@PostMapping("/statement")
	public ResponseEntity<ResponseWrapper> getClientStatement(@RequestBody StatementRequestBean statementRequest)
	{
		SummaryResponseBean summary = null;
		try {
			Long clientId = statementRequest.getClientId();
			Client client = clientServices.getClientInfo(clientId);
			List<Operation> clientOperations = operationServices.getClientOperations(clientId, statementRequest.getDateFrom(), statementRequest.getDateTo());
			BigDecimal balance = BigDecimal.ZERO;
			if(!CollectionUtils.isEmpty(clientOperations))
			{
				for (Operation operation : clientOperations)
				{
					OperationType operationTypeId = operation.getOperationType();
					BigDecimal operationAmount = operation.getAmount();
					
					if(operationTypeId.getId().equals(OperationType.DEPOSIT))
						balance = balance.add(operationAmount);
					else if(operationTypeId.getId().equals(OperationType.WITHDRAWAL))
						balance = balance.subtract(operationAmount);
				}
			}
			summary = new SummaryResponseBean(client, clientOperations, balance);
		} catch (Exception e) {
			//log exception here
			String localizedMessage = e.getLocalizedMessage();
			System.out.println(localizedMessage);
			LOG.error(localizedMessage);
			return new ResponseEntity<ResponseWrapper>(new ResponseWrapper(e), HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<ResponseWrapper>(new ResponseWrapper(summary), HttpStatus.OK);
	}
}
