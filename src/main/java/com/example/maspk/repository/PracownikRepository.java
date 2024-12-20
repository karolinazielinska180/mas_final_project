package com.example.maspk.repository;

import com.example.maspk.Pracownik;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface PracownikRepository extends CrudRepository<Pracownik,Long> {


}
