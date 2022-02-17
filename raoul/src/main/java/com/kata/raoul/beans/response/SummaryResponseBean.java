package com.kata.raoul.beans.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kata.raoul.domain.Client;
import com.kata.raoul.domain.Operation;

public class SummaryResponseBean implements Serializable
{
	/** Default value included to remove warning. Remove or modify at will. **/
	private static final long serialVersionUID = 1L;
	
	public SummaryResponseBean() 
	{
		
	}
	
	public SummaryResponseBean(Client client, List<Operation> operations) 
	{
		this.client = new ClientResponseBean(client);
		this.finalBalance = client.getCurrentBalance();
		for (Operation operation : operations) {
			this.operations.add(new OperationResponseBean(operation));
		}
	}
	
	public SummaryResponseBean(Client client, List<Operation> operations, BigDecimal balance) 
	{
		this.client = new ClientResponseBean(client);
		this.finalBalance = client.getCurrentBalance();
		for (Operation operation : operations) {
			this.operations.add(new OperationResponseBean(operation));
		}
		this.balance = balance;
	}
	
	private ClientResponseBean client;
	
	private List<OperationResponseBean> operations = new ArrayList<OperationResponseBean>();
	
	private BigDecimal balance = BigDecimal.ZERO;

	@JsonProperty("final_balance")
	private BigDecimal finalBalance = BigDecimal.ZERO;

	public ClientResponseBean getClient() {
		return client;
	}

	public void setClient(ClientResponseBean client) {
		this.client = client;
	}

	public List<OperationResponseBean> getOperations() {
		return operations;
	}

	public void setOperations(List<OperationResponseBean> operations) {
		this.operations = operations;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

}
