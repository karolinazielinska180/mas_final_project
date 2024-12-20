package com.example.maspk;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ZajeciaFitness")
public class ZajeciaFitness extends Warsztat{

    @ElementCollection
    @CollectionTable(name = "ekwipunekSportowy", joinColumns =@JoinColumn(name = "warsztat_id"))
    private List<String> ekwipunekSportowy;

    @Override
    public int compareTo(Warsztat o) {
        return 0;
    }

//    public ZajeciaFitness(int iloscUczestnikow, List<String> ekwipunekSportowy) {
//        super(iloscUczestnikow);
//        setEkwipunekSportowy(ekwipunekSportowy);
//    }
//
//    public List<String> getEkwipunekSportowy() {
//        return ekwipunekSportowy;
//    }
//
//    public void setEkwipunekSportowy(List<String> ekwipunekSportowy) {
//        this.ekwipunekSportowy = ekwipunekSportowy;
//    }


}
