package com.example.maspk.configs;

import com.example.maspk.*;
import com.example.maspk.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.*;

@Configuration
public class PracownikConfig {

    @Bean
    CommandLineRunner commandLineRunner(OsobaRepository osobaRepository, PracownikRepository pracownikRepository, KlientRepository klientRepository, PobytRepository pobytRepository, PokojRepository pokojRepository, WarsztatRepository warsztatRepository, WarsztatKlientRepository warsztatKlientRepository) {
        return args -> {
            List<String> dyplomy = new ArrayList<>();
            Pracownik pracownik = Pracownik.builder().imie("Anna").nazwisko("Kwiat").dataUrodzenia(java.sql.Date.valueOf(LocalDate.of(1999, 12, 19))).
                    pesel("12345678916").pensja(2000.0).umiejetnosci(dyplomy).typPracownika(Set.of(RodzajPracownika.Opiekun)).build();
            Pracownik pracownik1 = Pracownik.builder().imie("Adam").nazwisko("Kalinski").dataUrodzenia(java.sql.Date.valueOf(LocalDate.of(2000, 1, 17))).
                    pesel("12345678919").pensja(1000.0).lataDoswiadczenia(2).dyplomy(dyplomy).typPracownika(Set.of(RodzajPracownika.Pielegniarka)).build();

            dyplomy.add("dyplomy");
            Klient klient = Klient.builder().imie("Alicja").nazwisko("Nowacka").dataUrodzenia(java.sql.Date.valueOf(LocalDate.of(1976, 6, 13)))
                    .pesel("12345678918").dodatkoweInformacje("dodatkowe informacje").build();
            Klient klient1 = Klient.builder().imie("Adam").nazwisko("Nowak").dataUrodzenia(java.sql.Date.valueOf(LocalDate.of(1966, 8, 19)))
                    .pesel("12345678928").build();

            Set<String> test = new HashSet<>();
            test.add("test");
            Set<String> leki = new HashSet<>();
            leki.add("ibuprom");
            Pokoj pokoj = Pokoj.builder().numerPokoju(1).iloscMiejsc(1).build();
            Pokoj pokoj1 = Pokoj.builder().numerPokoju(2).iloscMiejsc(2).build();

            Pobyt pobyt = Pobyt.builder().dataRozpoczecia(java.sql.Date.valueOf(LocalDate.of(2024, 7, 1))).dataZakonczenia(java.sql.Date.valueOf(LocalDate.of(2024, 7, 12))).pokoj(pokoj).klient(klient).typPobytu(RodzajPobytu.Dlugoterminowy).znizka(20.0).kaucja(400.0).build();

            PobytWypoczynkowy pobytWypoczynkowy = PobytWypoczynkowy.builder().dataRozpoczecia(java.sql.Date.valueOf(LocalDate.of(2024, 8, 1))).dataZakonczenia(java.sql.Date.valueOf(LocalDate.of(2024, 9, 1))).pokoj(pokoj1).klient(klient).typPobytu(RodzajPobytu.Dlugoterminowy).znizka(20.0).kaucja(400.0).build();

            PobytDlaCiezkoChorych pobytDlaCiezkoChorych=PobytDlaCiezkoChorych.builder().dataRozpoczecia(java.sql.Date.valueOf(LocalDate.of(2024, 7, 1))).dataZakonczenia(java.sql.Date.valueOf(LocalDate.of(2024, 7, 2))).nazwaChoroby("choroba").opisChoroby("opis choroby").pokoj(pokoj1).potrzebneLeki(leki).klient(klient1).cenaZaNoc(50.0).typPobytu(RodzajPobytu.Krotkoterminowy).build();

//            ZajeciaArtystyczne zajeciaArtystyczne = new ZajeciaArtystyczne(9, dyplomy);
//            WarsztatKlient warsztatKlient = new WarsztatKlient(java.sql.Date.valueOf(LocalDate.of(2002, 12, 2)), zajeciaArtystyczne, klient4);



            //PobytDlaCiezkoChorych pobytDlaCiezkoChorych = new PobytDlaCiezkoChorych(java.sql.Date.valueOf(LocalDate.of(2025,11,14)),
            //      java.sql.Date.valueOf(LocalDate.of(2024,1,1)),10,"Gruzlica","powazna", leki);

//            ZajeciaFitness zajeciaFitness = new ZajeciaFitness(5, dyplomy);

//            klient.setPobyty(Set.of(pobyt,pobytWypoczynkowy));
//            pobyt.setKlient(klient);
//            pobytWypoczynkowy.setKlient(klient);


//
//            klient4.setPracownicy(Set.of(pracownik2));
//            pracownik2.setKlienci(Set.of(klient4));


            if (pracownikRepository.count() == 0) {
                System.out.println(pracownik1);
                System.out.println(pracownik);
                pracownikRepository.saveAll(List.of(pracownik, pracownik1));
            }
            if (pokojRepository.count() == 0) {
                pokojRepository.saveAll(List.of(pokoj,pokoj1));
            }
            if (klientRepository.count() == 0) {
                klientRepository.saveAll(List.of(klient, klient1));
            }
            if (pobytRepository.count() == 0) {
                pobytRepository.saveAll(List.of(pobytWypoczynkowy,pobyt,pobytDlaCiezkoChorych));
            }



        };
    }
}
