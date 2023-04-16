package com.gg.khedmatn.Web;

import com.gg.khedmatn.Entities.Administrateur;
import com.gg.khedmatn.Repositories.AdministrateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AdministrateurController {
    @Autowired
    AdministrateurRepository administrateurRepository;

    @PostMapping("/admins")
    public  void saveAdmin (@RequestBody Administrateur administrateur)
    {
        administrateur.setOldpassword(administrateur.getPassword());
        administrateurRepository.save(administrateur);
    }
    @DeleteMapping("/admins/{id}")
    public void supprimer(@PathVariable(name = "id") long id)
    {
        administrateurRepository.deleteById(id);
    }
    @GetMapping("/admins/byName")
    public List<Administrateur> findbyUsername(@RequestParam(name = "nom") String nom)
    {
        return administrateurRepository.findByNom(nom);
    }
    @GetMapping("/Admins")
    public ModelAndView viewHomePage(Model model)
    {
        model.addAttribute("listAdministrateur", administrateurRepository.findAll());
            return new ModelAndView("Admins");
    }
    @GetMapping("/showNewAdministrateurForm")
    public ModelAndView showNewClientForm(Model model)
    {
        Administrateur administrateur=new Administrateur();
        model.addAttribute("Administrateur",administrateur);
        return new ModelAndView("new_Administrateur");
    }
    @PostMapping("/saveAdministrateur")
    public ModelAndView saveEmployee(@ModelAttribute("Administrateur") Administrateur administrateur)
    {
        administrateurRepository.save(administrateur);
        return new ModelAndView("redirect:/api/Admins");
    }
    long id ;
    @GetMapping("/showFormForUpdate/{id}")
    public ModelAndView showFormForUpdate(@PathVariable(value = "id")long id,Model model)
    {
        Administrateur administrateur=administrateurRepository.getById(id);
        this.id=id;
        model.addAttribute("Administrateur",administrateur);
        return new ModelAndView("Administrateur_update");
    }
    public Administrateur getAdministrateurById(long id) {
        Optional<Administrateur> option= administrateurRepository.findById(id);
        Administrateur administrateur=null;
        if(option.isPresent())
        {
            administrateur=option.get();
        }
        else
        {
            throw  new RuntimeException("Administrateur not found for id :: "+id);
        }
        return administrateur;
    }
    @PostMapping("updateAdministrateur")
    public ModelAndView updateAdmins(@ModelAttribute("Administrateur") Administrateur administrateur)
    {
        if(getAdministrateurById(id)!=null)
        {
            administrateurRepository.delete(getAdministrateurById(id));
        }
        administrateurRepository.save(administrateur);
        return new ModelAndView("redirect:/api/Admins");
    }
    @GetMapping("DeleteAdministrateur/{id}")
    public ModelAndView DeleteClient(@PathVariable(value = "id")long id1)
    {
        this.administrateurRepository.deleteById(id1);
        return new ModelAndView("redirect:/api/Admins");
    }


}
