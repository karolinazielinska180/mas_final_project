package com.example.maspk.services;

import com.example.maspk.Klient;
import com.example.maspk.repository.KlientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class KlientServiceImpl{

    @Autowired
    KlientRepository klientRepository;
    /**
     * Pobiera wszystkich klientów
     *
     * @return wszystkich klientów
     */
    public Set<Klient> getAllKlients() {
        Set<Klient> klients = new HashSet<>();
        klientRepository.findAll().forEach(klients::add);
        return klients;
    }
    /**
     * Pobiera klienta po jego id
     *
     * @param id id klienta
     * @return znaleziony klient lub null, jeśli nie znaleziono
     */
    public Klient getKlientById(Long id) {
        return klientRepository.findById(id).orElse(null);
    }

}
