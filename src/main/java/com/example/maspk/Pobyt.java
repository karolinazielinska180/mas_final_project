package com.example.maspk;

import com.example.maspk.validators.DlugoTerminowy;
import com.example.maspk.validators.KrotkoTerminowy;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Entity
@Data
@Table(name = "Pobyt")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
@KrotkoTerminowy
@DlugoTerminowy

public class Pobyt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private Date dataRozpoczecia;
    @NotNull
    private Date dataZakonczenia;
//    private long iloscDniPobytu;

    @ManyToOne(targetEntity = Pokoj.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "pokoj_id", nullable = false, updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Pokoj pokoj;


    @Enumerated(EnumType.STRING)
    @NotNull
    private RodzajPobytu typPobytu;


    @ManyToOne(targetEntity = Klient.class, fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Klient klient;


    //od krotkoterminowy,dlugoterminowy:
    private  static int maxIloscDni = 3;
    @Nullable
    private Double cenaZaNoc;
    @Nullable//--opcjonalne
    private Double kaucja;
    @Nullable//--opcjonalne
    private Double znizka; //--opcjonalne


//    public Pobyt(Date dataRozpoczecia, Date dataZakonczenia, double cenaZaNoc, double kaucja, double znizka) {
//        this.dataRozpoczecia = dataRozpoczecia;
//        this.dataZakonczenia = dataZakonczenia;
//        this.iloscDniPobytu = getIloscDniPobytu();
//
//        if (iloscDniPobytu <= maxIloscDni) {
//            typPobytu.add(RodzajPobytu.Krotkoterminowy);
//            this.cenaZaNoc = cenaZaNoc;
//            if(kaucja != 0 && znizka != 0){
//                System.err.println("Pobyt jest pobytem krotkoterminowym!");
//            }
//        }else{
//            typPobytu.add(RodzajPobytu.Dlugoterminowy);
//            this.kaucja = kaucja;
//            this.znizka = znizka;
//            if(cenaZaNoc != 0){
//                System.err.println("Pobyt jest pobytem dlugoterminowym!");
//            }
//        }
//    }

//    public void dodajKlienta(Klient klient){
//        if(klient != null && !klienci.contains(klient)){
//            klienci.add(klient);
//            klient.dodajPobyt(this);
//        }
//    }
//
//    public void setPokoj(Pokoj pokoj) throws Exception {
//        if(pokoj != null){
//            this.pokoj = pokoj;
//            pokoj.dodajPobyt(this);
//        }
//
//    }


    public long getIloscDniPobytu() {
        LocalDate start = new java.sql.Date(dataRozpoczecia.getTime()).toLocalDate();
        LocalDate end = new java.sql.Date(dataZakonczenia.getTime()).toLocalDate();
        return ChronoUnit.DAYS.between(start, end);
    }


}
