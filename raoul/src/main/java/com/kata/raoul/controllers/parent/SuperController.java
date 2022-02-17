package com.kata.raoul.controllers.parent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.kata.raoul.wrappers.ResponseWrapper;

public class SuperController {

	protected static Log LOG = LogFactory.getLog(SuperController.class.getName());
	
	protected ResponseEntity<ResponseWrapper> extracted(Exception e) {
		//log exception here
		String localizedMessage = e.getLocalizedMessage();
		System.out.println(localizedMessage);
		LOG.error(localizedMessage);
		return new ResponseEntity<ResponseWrapper>(new ResponseWrapper(e), HttpStatus.BAD_REQUEST);
	}
}
