package com.example.maspk;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
@Data
@Table(name = "Pokoj")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pokoj {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true)
    private long numerPokoju;// unique
    @NotNull
    private int iloscMiejsc;

    @OneToMany(mappedBy = "pokoj",cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @Builder.Default
    @EqualsAndHashCode.Exclude
    private Set<Pobyt> pobyty = new HashSet<>();


//    private static Set<Long> numeryPokojow = new HashSet<>();


//    public Pokoj(long numerPokoju, int iloscMiejsc) throws Exception{
//        setNumerPokoju(numerPokoju);
//        this.iloscMiejsc = iloscMiejsc;
//    }
//
//    public void dodajPobyt(Pobyt pobyt) throws Exception {
//        if(pobyt != null && !pobyty.contains(pobyt)){
//            pobyty.add(pobyt);
//            pobyt.setPokoj(this);
//        }
//    }
//
//    public void setNumerPokoju(long numerPokoju) throws Exception{
//        if (!numeryPokojow.contains(numerPokoju)) {
//            this.numerPokoju = numerPokoju;
//            numeryPokojow.add(numerPokoju);
//        }else{
//            throw new Exception("Taki pokoj juz istnieje");
//        }
//    }







}
