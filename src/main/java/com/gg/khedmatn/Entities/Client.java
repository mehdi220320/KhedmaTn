package com.gg.khedmatn.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity @Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Client {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String nom;
    private String prenom;
    private String username;
    private String email;
    private String password;
    private String oldpassword   ;
}
