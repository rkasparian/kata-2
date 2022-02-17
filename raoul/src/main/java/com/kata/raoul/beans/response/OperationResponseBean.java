package com.kata.raoul.beans.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kata.raoul.domain.Operation;

public class OperationResponseBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OperationResponseBean(Operation operation) {
		SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		this.operationType = operation.getOperationType().getName();
		this.amount = operation.getAmount();
		this.date = dateTimeFormatter.format(operation.getOperationDate());
	}

	@JsonProperty("operation_type")
	private String operationType;
	
	private BigDecimal amount;
	
	private String date;

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
