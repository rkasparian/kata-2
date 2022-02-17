package com.kata.raoul.repository.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.kata.raoul.domain.Operation;
import com.kata.raoul.repository.OperationRepository;

public class OperationRepositoryImpl implements OperationRepository{

	@Autowired
	EntityManager entityManager;
	
	private synchronized Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	
	@Override
	public <S extends Operation> S save(S entity) {
		// TODO Auto-generated method stub
		Session session = getSession();
		session.saveOrUpdate(entity);
		session.flush();
		session.close();
		return entity;
	}

	@Override
	public <S extends Operation> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Operation> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Operation> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Operation> findAllById(Iterable<Long> ids) {
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
	public void delete(Operation entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Operation> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Operation> getOperations(long clientId, Date dateFrom, Date dateTo) {
		Session session = getSession();
		List<Operation> operations = new ArrayList<Operation>();
		if (dateFrom != null && dateTo != null) {
			operations = (List<Operation>) session.createQuery("SELECT k FROM Operation k WHERE k.client.id = :clientId AND k.operationDate BETWEEN :start AND :end ORDER BY k.operationDate ASC")
					.setParameter("start", dateFrom)
					.setParameter("end", dateTo)
					.setParameter("clientId", clientId)
					.getResultList();
		} else if (dateFrom == null && dateTo == null) {
			operations = (List<Operation>) session.createQuery("SELECT k FROM Operation k WHERE k.client.id = :clientId ORDER BY k.operationDate ASC")
					.setParameter("clientId", clientId)
					.getResultList();
		} else if (dateFrom == null) {
			operations = (List<Operation>) session.createQuery("SELECT k FROM Operation k WHERE k.client.id = :clientId AND k.operationDate <= :end ORDER BY k.operationDate ASC")
					.setParameter("end", dateTo)
					.setParameter("clientId", clientId)
					.getResultList();
		} else {
			operations = (List<Operation>) session.createQuery("SELECT k FROM Operation k WHERE k.client.id = :clientId AND k.operationDate >= :start ORDER BY k.operationDate ASC")
					.setParameter("start", dateFrom)
					.setParameter("clientId", clientId)
					.getResultList();
		}
		session.close();
		return operations;
	}

}
