package com.example.maspk.controllers;


import com.example.maspk.Klient;
import com.example.maspk.Pobyt;
import com.example.maspk.repository.KlientRepository;
import com.example.maspk.repository.PobytRepository;
import com.example.maspk.services.KlientServiceImpl;
import com.example.maspk.services.PobytServiceImpl;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Set;

@Controller
@RequiredArgsConstructor

public class KlientController {

    private final KlientServiceImpl klientService;
    private final PobytServiceImpl pobytService;
    private final PobytRepository pobytRepository;
    private final KlientRepository klientRepository;

    /**
     * Wyświetlanie wszystkich klientów.
     *
     * @param model model do którego dodawane są atrybuty
     * @return nazwa widoku do wyświetlania klientów
     */
    //wszyscy klienci
    @GetMapping(value = "/")
    public String wyswietlListKlientow(Model model) {
        model.addAttribute("klienci", klientService.getAllKlients());
        return "/klienci";
    }

    /**
     * Wyświetlanie pobytów dla klienta o podanym id.
     *
     * @param id    id klienta
     * @param model model do którego dodawane są atrybuty
     * @return nazwa widoku do wyświetlania pobytów klienta
     */
    //pobyty dla klienta z danym id
    @GetMapping("/klienci/{id}/pobyty")
    public String pokazPobytyKlienta(@PathVariable Long id, Model model) {
//        Klient klient=klientRepository.findById(id).orElseThrow();
        Set<Pobyt> pobyty = pobytRepository.findByKlientId(id);
//        Set<Pobyt> pobyty =klient.getPobyty();
//        System.out.println(klient);
//        System.out.println(pobyty);
        model.addAttribute("pobyty", pobyty);
//        model.addAttribute("klient",pobyty.);
        return "/pobytyKlienta" ;
    }

    /**
     * Wyświetlanie formularza edycji pobytu klienta
     *
     * @param id       id klienta
     * @param model    model do którego dodawane są atrybuty
     * @param idPobytu id pobytu
     * @return nazwa widoku do edycji pobytu
     */

    @GetMapping("/klienci/{id}/pobyty/edytuj/{idPobytu}/")
    public String edytujPobytForm(@PathVariable Long id, Model model,@PathVariable Long  idPobytu) {
        Pobyt pobyt = pobytRepository.findById(idPobytu).orElseThrow();
        Klient klient=klientRepository.findById(id).orElseThrow();
        model.addAttribute("pobyt", pobyt);
        model.addAttribute("klient", klient);
        return "/edycjaPobytu";
    }
    /**
     * Przetwarzanie formularza edycji pobytu
     *
     * @param id              id klienta
     * @param dataRozpoczecia data rozpoczęcia pobytu
     * @param dataZakonczenia data zakończenia pobytu
     * @param idPobytu        id pobytu
     * @return przekierowanie do głównego URL
     */
    @PostMapping("/klienci/{id}/pobyty/edytuj/{idPobytu}/")
    public String edytujPobyt(@RequestParam Long id, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataRozpoczecia, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataZakonczenia, @RequestParam Long idPobytu) {
        Pobyt pobyt1 = pobytRepository.findById(idPobytu).orElseThrow();
        pobyt1.setId(idPobytu);
        Klient klient = klientRepository.findById(id).orElseThrow();
        klient.setId(id);
        pobyt1.setDataRozpoczecia(dataRozpoczecia);
        pobyt1.setDataZakonczenia(dataZakonczenia);
        pobytRepository.save(pobyt1);
        klientRepository.save(klient);
        return "redirect:/";


    }


}






