package com.example.maspk.repository;

import com.example.maspk.Klient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface KlientRepository extends CrudRepository<Klient, Long> {

//    public Set<Klient> getKlients();
//
//    public Klient getKlientById(Long id);


}
