package com.kata.raoul.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kata.raoul.wrappers.ResponseWrapper;
import com.sun.istack.NotNull;
import com.kata.raoul.domain.Client;
import com.kata.raoul.beans.request.ClientRequestBean;
import com.kata.raoul.beans.response.ClientResponseBean;
import com.kata.raoul.services.IClientService;

@RestController
@RequestMapping("/clients")
public class ClientsController {

	@Autowired
	protected IClientService clientServices;
	
	protected static Log LOG = LogFactory.getLog(ClientsController.class.getName());
	
	@PostMapping(value = {"/create", "/update"})
	public ResponseEntity<ResponseWrapper> createClient(@RequestBody ClientRequestBean clientRequest)
	{
		try {
			Client client = new Client(clientRequest.getFirstName(), clientRequest.getLastName(), clientRequest.getPhoneNumber(), clientRequest.getEmail());
			clientServices.saveClient(client);
		} catch (Exception e) {
			//log exception here
			String localizedMessage = e.getLocalizedMessage();
			System.out.println(localizedMessage);
			LOG.error(localizedMessage);
			return new ResponseEntity<ResponseWrapper>(new ResponseWrapper(e), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<ResponseWrapper>(HttpStatus.OK);
	}

	@GetMapping("/info/{id}")
	public ResponseEntity<ResponseWrapper> getClientInfo(@PathVariable @NotNull Long id)
	{
		ClientResponseBean clientBean = null;
		try {
			Client client = clientServices.getClientInfo(id);
			clientBean = new ClientResponseBean(client);
		} catch (Exception e) {
			//log exception here
			String localizedMessage = e.getLocalizedMessage();
			System.out.println(localizedMessage);
			LOG.error(localizedMessage);
			return new ResponseEntity<ResponseWrapper>(new ResponseWrapper(e), HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<ResponseWrapper>(new ResponseWrapper(clientBean), HttpStatus.OK);
	}

}
