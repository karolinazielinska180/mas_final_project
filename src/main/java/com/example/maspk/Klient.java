package com.example.maspk;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.*;


@Entity
@Table(name = "Klient")
@Data //zapewnia get,set i tostring
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder // do budowania w configu, rozwiazalo problem z dziediczeniem
public class Klient extends Osoba {

    @Nullable
    private String dodatkoweInformacje; //opcjonalny;


    @OneToMany(mappedBy = "klient")
    @ToString.Exclude
    @Builder.Default
    @EqualsAndHashCode.Exclude
    private Set<WarsztatKlient> warsztatKlientList = new HashSet<>();

    @ManyToMany
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Pracownik> pracownicy = new HashSet<>();

    @OneToMany(mappedBy = "klient",fetch = FetchType.LAZY) //ladujemy dane jesli faktycznie jes potrzebujemy
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Pobyt> pobyty = new HashSet<>();





}
