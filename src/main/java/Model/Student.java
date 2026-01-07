package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "studenti")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ime", nullable = false)
    @NotBlank(message = "Ime je obavezno")
    @Size(min = 2, max = 50, message = "Ime mora imati između 2 i 50 znakova")
    private String ime;

    @Column(name = "prezime")
    @NotBlank(message = "Prezime je obavezno")
    @Size(min = 2, max = 50, message = "Prezime mora imati između 2 i 50 znakova")
    private String prezime;

    @Column(name = "email", unique = true)
    @NotBlank(message = "Email je obavezan")
    @Email(message = "Email mora biti validan (npr. ime@domena.com)")
    private String email;

    @Column(name = "godina_studija")
    @NotNull(message = "Godina studija je obavezna")
    @Min(value = 1, message = "Godina studija mora biti barem 1")
    @Max(value = 5, message = "Godina studija ne može biti veća od 5")
    private Integer godinaStudija;
}