package com.gg.khedmatn.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity @Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employeur {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    private String nom;
    private String prenom;
    private String username;
    private String email;
    private String image;
    private int Cin;
    private int phone;
    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_service_id")
    private Service service;*/
    private long service_id;
}
