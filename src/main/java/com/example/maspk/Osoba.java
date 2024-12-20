package com.example.maspk;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
@Table(name = "Osoba")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuperBuilder

@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Osoba {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank
    private String imie;
    @NotBlank
    private String nazwisko;
    @Past
    private Date dataUrodzenia;
    @NotBlank
    @Column(unique = true)
    private String pesel; //unikalny


    //atrybut wyliczalny
    public int getWiek() {
        int wiek = (int) (ChronoUnit.YEARS.between(LocalDate.parse(dataUrodzenia.toString()), LocalDate.now()));
        return wiek;
    }

}