package com.gg.khedmatn.Web;
import com.gg.khedmatn.Entities.Employeur;

import com.gg.khedmatn.Entities.Service;
import com.gg.khedmatn.Model.EmpAndService;
import com.gg.khedmatn.Repositories.EmployeurRepository;
import com.gg.khedmatn.Repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/api")

public class EmployeurController {
    long ID=1;
    EmpAndService empAndService;
    @Autowired
    EmployeurRepository employeurRepository;
    @Autowired
    ServiceRepository serviceRepository;
    @PostMapping("/createEmployeur")
    public ModelAndView saveEmployeur(Model model, @ModelAttribute("empAndService") EmpAndService empAndService)
    {
        this.empAndService= empAndService;
        Service service=new Service(ID,empAndService.getSernom(),empAndService.getCategorie(),empAndService.getAddresse(),empAndService.getSerphone(),empAndService.getDescription(),empAndService.getDescription2(),empAndService.getDescription3(),empAndService.getPrix(),empAndService.getPrix2(),empAndService.getPrix3(),empAndService.getPrix4(),empAndService.getTheme1(),empAndService.getTheme2(),empAndService.getTheme3(),empAndService.getTheme4());
        Employeur employeur=new Employeur(ID,empAndService.getNom(),empAndService.getPrenom(),empAndService.getUsername(),empAndService.getEmail(),empAndService.getImage(),empAndService.getCin(),empAndService.getPhone(),ID);
        serviceRepository.save(service);
        this.ID=ID+1;
        employeurRepository.save(employeur);
        return new ModelAndView("redirect:/api/MyPortfolio");
    }
    @GetMapping("/MyPortfolio")
    public ModelAndView Getportfolio( Model model) {
        model.addAttribute("empAndService",empAndService);
        return  new ModelAndView("MyPortfolio");
    }
    @DeleteMapping("/employeurs/{id}")
    public void supprimer(@PathVariable(name = "id") long id)
    {
        employeurRepository.deleteById(id);
    }
  /*  @PutMapping("/employeurs/{id}")
    public void update(@PathVariable(name = "id") long id,@RequestBody Employeur employeur,@RequestParam(name = "oldpass") String oldpassword) {
        Employeur employeur1 = employeurRepository.getById(id);
        System.out.println("write the old password ");
        if (employeur1.getPassword().equals(oldpassword)) {
            if (employeur.getUsername() != null) {
                employeur1.setUsername(employeur.getUsername());
            }
            if (employeur.getNom() != null) {
                employeur1.setNom(employeur.getNom());
            }
            if (employeur.getPrenom() != null) {
                employeur1.setPrenom(employeur.getPrenom());
            }
            if (employeur.getEmail() != null) {
                employeur1.setEmail(employeur.getEmail());
            }
            employeurRepository.save(employeur1);
        }
        else
        {
            System.out.println("wrong one");
        }
    }*/
   /* @GetMapping("/employeurs/byUsername")
    public List<EMP> findbyUsernameWservice(@RequestParam(name = "Username") String username)
    {
        ArrayList<EMP> emp=new ArrayList<EMP>();
        ArrayList<Employeur>empdata=new ArrayList<Employeur>();
        empdata= (ArrayList<Employeur>) employeurRepository.findByUsername(username);
        for(int i=0;i<empdata.size();i++)
            emp.add(new EMP(empdata.get(i).getId(),empdata.get(i).getImage(),empdata.get(i).getNom(),empdata.get(i).getPrenom(),empdata.get(i).getUsername(),empdata.get(i).getEmail(),empdata.get(i).getPassword(),empdata.get(i).getOldpassword(),empdata.get(i).getCin(),empdata.get(i).getService().getId(),empdata.get(i).getService().getNom(),empdata.get(i).getService().getCategorie()));

        return emp ;
    }
   /* @GetMapping("/employeurs/byUsername")
    public List<EMP> findbyUsername(@RequestParam(name = "Username") String username)
    {
        ArrayList<EMP> emp=new ArrayList<EMP>();
        ArrayList<Employeur>empdata=new ArrayList<Employeur>();
        empdata= (ArrayList<Employeur>) employeurRepository.findByUsername(username);
        for(int i=0;i<empdata.size();i++)
            emp.add(new EMP(empdata.get(i).getId(),empdata.get(i).getImage(),empdata.get(i).getNom(),empdata.get(i).getPrenom(),empdata.get(i).getUsername(),empdata.get(i).getEmail(),empdata.get(i).getPassword(),empdata.get(i).getOldpassword(),empdata.get(i).getCin(),empdata.get(i).getService().getId()));

        return emp ;
    }
    @GetMapping("/employeurs")
    public List<EMP> getALL()
    {
        ArrayList<EMP> emp=new ArrayList<EMP>();
        ArrayList<Employeur>empdata=new ArrayList<Employeur>();
        empdata= (ArrayList<Employeur>) employeurRepository.findAll();
       for(int i=0;i<empdata.size();i++)
            emp.add(new EMP(empdata.get(i).getId(),empdata.get(i).getImage(),empdata.get(i).getNom(),empdata.get(i).getPrenom(),empdata.get(i).getUsername(),empdata.get(i).getEmail(),empdata.get(i).getPassword(),empdata.get(i).getOldpassword(),empdata.get(i).getCin(),empdata.get(i).getService().getId()));
        return emp;}
     @GetMapping("/employeurs")
    public List<EMP> getALLWservice()
    {
        ArrayList<EMP> emp=new ArrayList<EMP>();
        ArrayList<Employeur>empdata=new ArrayList<Employeur>();
        empdata= (ArrayList<Employeur>) employeurRepository.findAll();
        for(int i=0;i<empdata.size();i++)
            emp.add(new EMP(empdata.get(i).getId(), empdata.get(i).getImage(), empdata.get(i).getNom(), empdata.get(i).getPrenom(), empdata.get(i).getUsername(), empdata.get(i).getEmail(), empdata.get(i).getPassword(), empdata.get(i).getOldpassword(), empdata.get(i).getCin(), empdata.get(i).getService().getId(), empdata.get(i).getService().getNom(), empdata.get(i).getService().getCategorie()));
        return emp;
    }*/
}
