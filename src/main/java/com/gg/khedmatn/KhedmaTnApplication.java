package com.gg.khedmatn;

import com.gg.khedmatn.Entities.Administrateur;
import com.gg.khedmatn.Entities.Client;
import com.gg.khedmatn.Entities.Employeur;
import com.gg.khedmatn.Entities.Service;
import com.gg.khedmatn.Repositories.AdministrateurRepository;
import com.gg.khedmatn.Repositories.ClientRepository;
import com.gg.khedmatn.Repositories.EmployeurRepository;
import com.gg.khedmatn.Repositories.ServiceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class KhedmaTnApplication {

    public static void main(String[] args) {
        SpringApplication.run(KhedmaTnApplication.class, args);}
   @Bean
    CommandLineRunner commandLineRunner(AdministrateurRepository administrateurRepository, ClientRepository clientRepository/*, EmployeurRepository employeurRepository, ServiceRepository serviceRepository*/){
        Client client=new Client(1,"Med Mehdi","Ben Gamra","mehdiGG","mehdi@gmail.com","GG","GG");
        Administrateur admin=new Administrateur(1L,"Med Mehdi","Ben Gamra","Master","mehdi@gmail.com","GG","GG",01111111,null);
        //Service service=new Service(1L,"7akkem","7ajem");
        //Employeur employeur=new Employeur(1L,null,"Ben Gamra","Mohamed Mehdi","mehdiGG","mehdi@gmail.com","gg","gg",01111111,service);
        return args -> {
            clientRepository.save(client);
          //  serviceRepository.save(service);
           // employeurRepository.save(employeur);
            administrateurRepository.save(admin);
        };
    }

}
