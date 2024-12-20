package com.example.maspk;

import com.example.maspk.validators.IloscUczestnikow;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "warsztat")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@IloscUczestnikow
public abstract class Warsztat implements Comparable<Warsztat> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private static int dlugoscTrwaniaZajec = 2;
    private static int maxLiczbaUczestnikow = 10;
    @NotNull
    @Max(10)
    private int iloscUczestnikow;





    @OneToMany(mappedBy = "warsztat")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<WarsztatKlient> warsztatKlientList = new HashSet<>();

//    private static List<Warsztat> warsztaty = new ArrayList<>();


    @ManyToOne(targetEntity = Pracownik.class)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Pracownik pracownik;

    public static int getMaxLiczbaUczestnikow() {
        return maxLiczbaUczestnikow;
    }

//    public Warsztat(int iloscUczestnikow) {
//        setIloscUczestnikow(iloscUczestnikow);
//    }
//
//    public void dodajWarsztatKlient(WarsztatKlient warsztatKlient) {
//        if (!warsztatKlientList.contains(warsztatKlient)) {
//            warsztatKlientList.add(warsztatKlient);
//            warsztatKlient.setWarsztat(this);
//        }
//    }
//
//    public void dodajPracownik(Pracownik pracownik) {
//        if (pracownik != null && !pracownicy.contains(pracownik)) {
//            pracownicy.add(pracownik);
//            pracownik.dodajWarsztat(this);
//        }
//    }


    /*public List<Klient> getKlienci() {
        return klienci;
    }

     */



//
//    public static List<Warsztat> getWarsztaty() {
//        Collections.sort(warsztaty);
//        return Collections.unmodifiableList(warsztaty);
//    }
//
//    //do ograniczenia ordered
//    @Override
//    public int compareTo(Warsztat warsztat) {
//        if (this.iloscUczestnikow > warsztat.iloscUczestnikow) {
//            return 1;
//        } else if (this.iloscUczestnikow < warsztat.iloscUczestnikow) {
//            return -1;
//        } else {
//            return 0;
//        }
//    }
}
