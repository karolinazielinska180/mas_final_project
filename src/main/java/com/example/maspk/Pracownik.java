package com.example.maspk;

import com.example.maspk.validators.Opiekun;
import com.example.maspk.validators.OpiekunKlient;
import com.example.maspk.validators.Pielegniarka;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.*;
import java.util.stream.Collectors;



@Entity
@Table(name = "Pracownik")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Opiekun
@OpiekunKlient
@Pielegniarka
@SuperBuilder
public class Pracownik extends Osoba {

    @NotNull
    private Double pensja; //dla wszystkich

    @ElementCollection
    @CollectionTable(name = "umiejetnosci", joinColumns = @JoinColumn(name = "pracownik_id"))
    @Fetch(FetchMode.SUBSELECT)
    @Nullable
    private List<String> umiejetnosci; //opiekuna - opcjonalne

    @Nullable
    @Min(1)
    private Integer lataDoswiadczenia; //pielegniarka - wymagane

    @ElementCollection
    @CollectionTable(name = "dyplomy", joinColumns = @JoinColumn(name = "pracownik_id"))
    @Fetch(FetchMode.SUBSELECT)
    @Nullable
    private List<String> dyplomy;//pielegniarka - wymagane

    @ElementCollection(targetClass = RodzajPracownika.class)
    @Fetch(FetchMode.SUBSELECT)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "typPracownika", joinColumns = @JoinColumn(name = "pracownik_id"))
    @NotEmpty
    private Set<RodzajPracownika> typPracownika;


    @OneToMany(mappedBy = "pracownik")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Warsztat> warsztaty = new HashSet<>();


    @ManyToMany
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Klient> klienci = new HashSet<>();

    public Set<Warsztat> getWarsztaty() {
        return warsztaty.stream().sorted(Comparator.comparing(Warsztat::getIloscUczestnikow)).collect(Collectors.toCollection(LinkedHashSet::new));
    }
//
//    //konstruktor dla pracownika
//    public Pracownik(String imie, String nazwisko, Date dataUrodzenia, String pesel, double pensja) {
//        super(imie, nazwisko, dataUrodzenia, pesel);
//        this.pensja = pensja;
//        typPracownika.add(RodzajPracownika.Pracownik);
//    }

//    //konstruktor dla opiekuna
//    public Pracownik(String imie, String nazwisko, Date dataUrodzenia, String pesel, double pensja, List<String> umiejetnosci) {
//        super(imie, nazwisko, dataUrodzenia, pesel);
//        this.pensja = pensja;
//        this.umiejetnosci = umiejetnosci;
//        typPracownika.add(RodzajPracownika.Opiekun);
//    }
//
//    //konstruktor dla pielegniarki
//    public Pracownik(String imie, String nazwisko, Date dataUrodzenia, String pesel, double pensja, int lataDoswiadczenia, List<String> dyplomy) {
//        super(imie, nazwisko, dataUrodzenia, pesel);
//        this.pensja = pensja;
//        this.lataDoswiadczenia = lataDoswiadczenia;
//        this.dyplomy = dyplomy;
//        typPracownika.add(RodzajPracownika.Pielegniarka);
//    }
//
//    //konstruktor dla pracownika - opiekuna - pielegniarka
//    public Pracownik(String imie, String nazwisko, Date dataUrodzenia, String pesel, double pensja, List<String> umiejetnosci, int lataDoswiadczenia, List<String> dyplomy) {
//        super(imie, nazwisko, dataUrodzenia, pesel);
//        this.pensja = pensja;
//        this.umiejetnosci = umiejetnosci;
//        this.lataDoswiadczenia = lataDoswiadczenia;
//        this.dyplomy = dyplomy;
//        typPracownika.add(RodzajPracownika.Pielegniarka);
//        typPracownika.add(RodzajPracownika.Opiekun);
//    }
//
//    public void dodajWarsztat(Warsztat warsztat) {
//        if (warsztat != null && !warsztaty.contains(warsztat)) {
//            warsztaty.add(warsztat);
//            warsztat.dodajPracownik(this);
//        }
//    }
//
//    public void dodajKlient(Klient klient) {
//        if (this.typPracownika.contains(RodzajPracownika.Opiekun) && klient != null && !klienci.contains(klient)) {
//            klienci.add(klient);
//            klient.dodajOpiekuna(this);
//        }
//    }


//    @Override
//    public String toString() {
//        return "Pracownik{" +
//                "pensja=" + pensja +
//                ", umiejetnosci=" + umiejetnosci +
//                ", lataDoswiadczenia=" + lataDoswiadczenia +
//                ", dyplomy=" + dyplomy +
//                ", typPracownika=" + typPracownika +
//                '}';
//    }
}
