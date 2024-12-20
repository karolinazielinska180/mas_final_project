package com.example.maspk;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.util.Date;
@Entity
@Table(name = "warsztat_klient")
@AllArgsConstructor
@NoArgsConstructor
public class WarsztatKlient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @PastOrPresent
    private Date dataUdzialu;

    @ManyToOne(targetEntity = Warsztat.class)
    @JoinColumn(name = "warsztat_id",nullable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @NotNull
    private Warsztat warsztat;

    @ManyToOne(targetEntity = Klient.class)
    @JoinColumn(name = "klient_id",nullable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @NotNull
    private Klient klient;




}
