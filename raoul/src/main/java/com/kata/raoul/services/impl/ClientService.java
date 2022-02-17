package com.kata.raoul.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kata.raoul.domain.Client;
import com.kata.raoul.repository.ClientRepository;
import com.kata.raoul.services.IClientService;

@Component
public class ClientService implements IClientService {
	
	@Autowired
	ClientRepository clientRepository;

	@Override
	public void saveClient(Client client) {
		clientRepository.save(client);
	}

	@Override
	public Client getClientInfo(Long clientId) throws Exception {
		// TODO Auto-generated method stub
		Optional<Client> optionalClient = clientRepository.findById(clientId);
		return optionalClient.isPresent() ? optionalClient.get() : null;
	}

}
