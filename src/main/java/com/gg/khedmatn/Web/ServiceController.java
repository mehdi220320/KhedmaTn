package com.gg.khedmatn.Web;

import com.gg.khedmatn.Entities.Service;
import com.gg.khedmatn.Repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class ServiceController {
    @Autowired
    ServiceRepository serviceRepository;
    @PostMapping("/services")
    public  void ajouter (@RequestBody Service service) {serviceRepository.save(service);}
    @DeleteMapping("/services/{id}")
    public void supprimer(@PathVariable(name = "id") long id)
    {
        serviceRepository.deleteById(id);
    }
    /*@GetMapping("/services/byUsername")
    public List<SER> findbyNom(@RequestParam(name = "Username") String nom)
    {
        ArrayList<SER> ser=new ArrayList<SER>();
        ArrayList<Service>services=new ArrayList<Service>();
        services= (ArrayList<Service>) serviceRepository.findByNom(nom);
        for(int i=0;i<services.size();i++)
            ser.add(new SER(services.get(i).getId(),services.get(i).getNom(),services.get(i).getCategorie(),services.get(i).getEmployeur().getId(),services.get(i).getEmployeur().getUsername()));

        return ser ;
    }
    @GetMapping("/services")
    public List<SER> getALL(){
        ArrayList<SER> ser=new ArrayList<SER>();
        ArrayList<Service>services=new ArrayList<Service>();
        services= (ArrayList<Service>) serviceRepository.findAll();
        for(int i=0;i<services.size();i++)
            ser.add(new SER(services.get(i).getId(),services.get(i).getNom(),services.get(i).getCategorie(),services.get(i).getEmployeur().getId(),services.get(i).getEmployeur().getUsername()));

        return ser;
    }*/

}
