package com.example.maspk;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PobytWypoczynkowy")
@SuperBuilder
public class PobytWypoczynkowy extends Pobyt {

    @ElementCollection
    @CollectionTable(name = "wykupioneUslugiRekreacyjne", joinColumns =@JoinColumn(name = "pobyt_id"))
    @Fetch(FetchMode.SUBSELECT)
    private Set<String> wykupioneUslugiRekreacyjne;

//    public PobytWypoczynkowy(Date dataRozpoczecia, Date dataZakonczenia, double cenaZaNoc, double kaucja, double znizka, Set<String> wykupioneUslugiRekreacyjne) {
//        super(dataRozpoczecia, dataZakonczenia, cenaZaNoc, kaucja, znizka);
//        this.wykupioneUslugiRekreacyjne = wykupioneUslugiRekreacyjne;
//    }



}
