package com.example.maspk.services;

import com.example.maspk.Klient;
import com.example.maspk.Pobyt;
import com.example.maspk.repository.KlientRepository;
import com.example.maspk.repository.PobytRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PobytServiceImpl {


    @Autowired
    PobytRepository pobytRepository;


    public Set<Pobyt> getPobytyByKlientId(Long klientId) {
        return pobytRepository.findByKlientId(klientId);
    }



    public Set<Pobyt> getAllPobyty() {
        Set<Pobyt> pobyty = new HashSet<>();
        pobytRepository.findAll().forEach(pobyty::add);

        return pobyty;
    }

    public Pobyt pokazPobyt(Long id){
            return pobytRepository.findById(id).orElse(null);
    }
    public void savePobyt(Pobyt pobyt) {
        pobytRepository.save(pobyt);
    }



}
