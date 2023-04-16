package com.gg.khedmatn.Repositories;

import com.gg.khedmatn.Entities.Client;
import com.gg.khedmatn.Entities.Employeur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EmployeurRepository extends JpaRepository<Employeur,Long> {
    List<Employeur> findByUsername(String username);
}
