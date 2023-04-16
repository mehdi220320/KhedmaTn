package com.gg.khedmatn.Entities;

import com.gg.khedmatn.Repositories.EmployeurRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Service {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String nom;
    private String categorie;
    private String Addresse;
    private int phone;
    private String description;
    private String description2;
    private String description3;
    private int prix;
    private int prix2;
    private int prix3;
    private int prix4;
    private String theme1;
    private String theme2;
    private String theme3;
    private String theme4;

    /*@OneToOne(mappedBy = "service")
    private Employeur employeur;*/

}
