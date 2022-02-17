package com.kata.raoul.repository.impl;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.kata.raoul.domain.Client;
import com.kata.raoul.repository.ClientRepository;

public class ClientRepositoryImpl implements ClientRepository {

	@Autowired
	EntityManager entityManager;
	
	private synchronized Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	
	@Override
	public <S extends Client> S save(S entity) {
		// TODO Auto-generated method stub
		Session session = getSession();
		session.saveOrUpdate(entity);
		session.flush();
		session.close();
		return entity;
	}

	@Override
	public <S extends Client> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Client> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.of(entityManager.find(Client.class, id));
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Client> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Client> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Client entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Client> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
