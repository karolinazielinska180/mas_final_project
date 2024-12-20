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
@Table(name = "ZajeciaArtystyczne")


public class ZajeciaArtystyczne extends Warsztat {
    @ElementCollection
    @CollectionTable(name = "przybory", joinColumns =@JoinColumn(name = "warsztat_id"))
    private List<String> przybory;

    @Override
    public int compareTo(Warsztat o) {
        return 0;
    }

//    public ZajeciaArtystyczne(int iloscUczestnikow,List<String> przybory) {
//        super(iloscUczestnikow);
//        setPrzybory(przybory);
//    }
//
//    public List<String> getPrzybory() {
//        return przybory;
//    }
//    public void setPrzybory(List<String> przybory) {
//        if (przybory.size() > 0) {
//            this.przybory = przybory;
//        }
//    }

}
