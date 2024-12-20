package com.example.maspk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class MasPkApplication {

    public static void main(String[] args) throws Exception{
//        List<String> przyborytest = new ArrayList<>();
//        String cos = "ssss";
//        przyborytest.add(cos);
//        ZajeciaArtystyczne zajeciaArtystyczne = new ZajeciaArtystyczne(1, przyborytest);
//
//        System.out.println("asocjacja warszat - klient" + "\n");
//        Klient klient = new Klient("test", "test", java.sql.Date.valueOf(LocalDate.now()), "12345678910", "brak");
//        WarsztatKlient warsztatKlient = new WarsztatKlient(Date.from(Instant.now()), zajeciaArtystyczne, klient);
//        WarsztatKlient warsztatKlient1 = new WarsztatKlient(Date.from(Instant.now()), zajeciaArtystyczne, klient);
//        System.out.println(warsztatKlient);
//        System.out.println(warsztatKlient1);
//
//        System.out.println("dziedziczenie wieloaspektowe");
//        Pobyt pobyttest = new Pobyt(java.sql.Date.valueOf(LocalDate.now()), java.sql.Date.valueOf(LocalDate.now()), 2, 10, 20);
//        System.out.println(pobyttest.getCenaZaNoc());
//        System.out.println(pobyttest.getKaucja());
//        System.out.println(pobyttest.getZnizka());
//
//        PobytWypoczynkowy pobytWypoczynkowy = new PobytWypoczynkowy(java.sql.Date.valueOf(LocalDate.now()), java.sql.Date.valueOf(LocalDate.now()), 2,2,2,przyborytest);
//        System.out.println("=====================");
//        System.out.println(pobytWypoczynkowy.getTypPobytu());
//        System.out.println(pobytWypoczynkowy.getIloscDniPobytu());
//        System.out.println(pobytWypoczynkowy.getWykupioneUslugiRekreacyjne());
//
//
////        Pokoj pokoj=new Pokoj(1,1);
////        Pobyt pobyt = Pobyt.stworzPobyt(pokoj,java.sql.Date.valueOf(LocalDate.now()), java.sql.Date.valueOf(LocalDate.now()),20,1000,10);
////        System.out.println(pobyt);
////        Pobyt pobyt1 = new Pobyt(java.sql.Date.valueOf(LocalDate.now()), java.sql.Date.valueOf(LocalDate.now()),20,1000,10);
////        PobytWypoczynkowy.stworzPobyt()
////        SpringApplication.run(MasPkApplication.class, args);
//
//        Pracownik pracownik = new Pracownik("imie", "nazwisko", java.sql.Date.valueOf(LocalDate.now()), "12345678910", 2000);
//        Pracownik pracownikOpiekun = new Pracownik("imie", "nazwisko", java.sql.Date.valueOf(LocalDate.now()), "12345678910", 2000, null);
//        Pracownik pracownikPielegniarka = new Pracownik("imie", "nazwisko", java.sql.Date.valueOf(LocalDate.now()), "12345678910", 2000, 12, przyborytest);
//        Pracownik pracownikPielegniarkaOpiekun = new Pracownik("imie", "nazwisko", java.sql.Date.valueOf(LocalDate.now()), "12345678910", 2000, null,12, przyborytest);
//
//        System.out.println("pracownik dziedziczenie" + "\n");
//        System.out.println(pracownik.getTypPracownika());
//        System.out.println(pracownikOpiekun.getTypPracownika());
//        System.out.println(pracownikPielegniarka.getTypPracownika());
//        System.out.println(pracownikPielegniarkaOpiekun.getTypPracownika());
//
//        System.out.println("asocjacja warsztat - pracownik"+ "\n");
//        ZajeciaFitness zajeciaFitness = new ZajeciaFitness(1, przyborytest);
//        pracownik.dodajWarsztat(zajeciaFitness);
//        System.out.println(pracownik.getWarsztaty());
//        System.out.println(zajeciaFitness.getPracownicy());
//
//        System.out.println("asocjacja klient - opiekun"+ "\n");
//        pracownik.dodajKlient(klient);
//        System.out.println(pracownik.getKlienci());
//        System.out.println(klient.getPracownicy());
//
//        pracownikOpiekun.dodajKlient(klient);
//        System.out.println(pracownikOpiekun.getKlienci());
//        System.out.println(klient.getPracownicy());
//
//        System.out.println("asocjacja pobyt - pokoj"+ "\n");
//        Pobyt pobyt = new Pobyt(java.sql.Date.valueOf(LocalDate.now()),java.sql.Date.valueOf(LocalDate.now()), 1,1,1);
//        Pokoj pokoj = new Pokoj(1,1);
//        Pokoj pokoj1 = new Pokoj(2,1);
//        pokoj.dodajPobyt(pobyt);
//        pokoj1.dodajPobyt(pobyt);
//        System.out.println(pokoj);
//        System.out.println(pokoj1);
//        System.out.println(pobyt.getPokoj());
//        System.out.println(pokoj.getPobyty());
//
//        System.out.println("asocjacja pobyt - klient"+ "\n");
//        pobyt.dodajKlienta(klient);
//        System.out.println(pobyt.getKlienci());
//        System.out.println(klient.getPobyty());
        SpringApplication.run(MasPkApplication.class, args);

    }



}
