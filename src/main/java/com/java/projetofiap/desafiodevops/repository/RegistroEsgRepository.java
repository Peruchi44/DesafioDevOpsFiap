package com.java.projetofiap.desafiodevops.repository;

import com.java.projetofiap.desafiodevops.model.RegistroEsg;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroEsgRepository extends MongoRepository<RegistroEsg, String> {
}