package com.example.maspk;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PobytDlaCiezkoChorych")
@SuperBuilder

public class PobytDlaCiezkoChorych extends Pobyt {

    @NotBlank
    private String nazwaChoroby;
    @NotBlank
    private String opisChoroby;

    @ElementCollection
    @CollectionTable(name = "potrzebneleki", joinColumns = @JoinColumn(name = "pobyt_id"))
    private Set<String> potrzebneLeki;





}
