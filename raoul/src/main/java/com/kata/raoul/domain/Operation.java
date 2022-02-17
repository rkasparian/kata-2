package com.kata.raoul.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Operation implements Serializable
{
	/** Default value included to remove warning. Remove or modify at will. **/
	private static final long serialVersionUID = 1L;
	
	public Operation() {
		
	}

	public Operation(Long id) {
		this.id = id;
	}
	
	public Operation(OperationType operationType, Client client, BigDecimal amount, Date date)
	{
		this.operationType = operationType;
		this.client = client;
		this.amount = amount;
		this.operationDate = date;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client", nullable = false)
	private Client client;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "operation_type", nullable = false)
	private OperationType operationType;

	@Column(nullable = false)
	private BigDecimal amount = BigDecimal.ZERO;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date operationDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public OperationType getOperationType() {
		return operationType;
	}

	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}
	
}
