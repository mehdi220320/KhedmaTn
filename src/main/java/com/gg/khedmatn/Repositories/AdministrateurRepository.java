package com.gg.khedmatn.Repositories;

import com.gg.khedmatn.Entities.Administrateur;
import com.gg.khedmatn.Entities.Employeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface AdministrateurRepository extends JpaRepository<Administrateur,Long> {
    List<Administrateur> findByNom(String nom);
    Optional<Administrateur> findById(Long id);
}
