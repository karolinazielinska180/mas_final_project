package com.example.maspk.repository;

import com.example.maspk.Klient;
import com.example.maspk.Pobyt;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PobytRepository extends CrudRepository<Pobyt, Long> {
    @EntityGraph(attributePaths = {"typPobytu"})
    Set<Pobyt> findByKlientId(Long klientId);


}
