package com.gg.khedmatn.Repositories;

import com.gg.khedmatn.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface  ClientRepository extends JpaRepository<Client,Long> {
    List<Client> findByUsername(String username);
    List<Client> findByEmail(String Email);
    Optional<Client> findByEmailAndPassword(String Email,String password);

}
