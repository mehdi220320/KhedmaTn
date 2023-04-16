package com.gg.khedmatn.Model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmpAndService {
    private String nom;
    private String prenom;
    private String username;
    private String email;
    private String image;
    private int Cin;
    private int phone;
    private String Sernom;
    private String categorie;
    private String Addresse;
    private int Serphone;
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

}
