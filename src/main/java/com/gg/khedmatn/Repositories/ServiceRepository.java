package com.gg.khedmatn.Repositories;

import com.gg.khedmatn.Entities.Client;
import com.gg.khedmatn.Entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.ArrayList;
import java.util.List;

@RepositoryRestResource
public interface ServiceRepository extends JpaRepository<Service,Long> {
    List<Service> findByNom(String nom);


}
