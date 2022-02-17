package com.kata.raoul.services;

import com.kata.raoul.domain.Client;

public interface IClientService {

	public void saveClient(Client client);
	
	public Client getClientInfo(Long clientId) throws Exception;
}
