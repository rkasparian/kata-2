package com.kata.raoul.repository;

import org.springframework.data.repository.CrudRepository;

import com.kata.raoul.domain.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {

}
