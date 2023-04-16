package com.gg.khedmatn.Web;

import com.gg.khedmatn.Entities.Client;
import com.gg.khedmatn.Repositories.ClientRepository;
import com.gg.khedmatn.Verification.Verification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ClientController {
    @Autowired
    ClientRepository clientRepository;
    Verification verification=new Verification();
    @Value("Weakpassword")
    private String Weakpassword;
    @Value("${emailSYmessafe}")
    private String emailSYmessafe;
    @Value("${emailEXmessage}")
    private String emailEXmessage;
    @Value("${Repassword}")
    private String Repassword;
    @Value("${error}")
    private String error;
    public boolean EmailSynthaxeVerify(String email){
        if(email.length()>8)
        {
            if(email.contains("@"))
            {
                if((email.contains(".com"))&& (email.indexOf(".com")==(email.length()-4)))
                    return true;
                else
                    return false;
            }else return false;
        }
        else
            return false;
    }
    public boolean EmailExistanceVerify(String email){
        if (clientRepository.findByEmail(email).size()>0)
            return true;
        else return false;
    }
    @PostMapping("/create")
    public ModelAndView ajouter (Model model , @ModelAttribute("client") Client client)
    {
       if(EmailExistanceVerify(client.getEmail())==false)
        {
            if(EmailSynthaxeVerify(client.getEmail()))
            {
                if (client.getPassword().length()>7)
                {
                    if (client.getPassword().equals(client.getOldpassword()))
                    {
                         clientRepository.save(client);
                         return new ModelAndView("redirect:/api/signin");
                     }
                     else
                          model.addAttribute("Repassword", Repassword);
                }
                else
                    model.addAttribute("Weakpassword", Weakpassword);
            }
                else
                model.addAttribute("emailSYmessafe", emailSYmessafe);

        }
        else
            model.addAttribute("emailEXmessage", emailEXmessage);
        model.addAttribute("error", error);
        return new ModelAndView("create");

    }
    @DeleteMapping("/clients/{id}")
    public void supprimer(@PathVariable(name = "id") long id)
    {
        clientRepository.deleteById(id);
    }
    @PutMapping("/clients/{id}")
    public void update(@PathVariable(name = "id") long id,@RequestBody Client client,@RequestParam(name = "oldpass") String oldpassword)
    {
        Client client1=clientRepository.getById(id);
        System.out.println("write the old password ");
        if (client1.getPassword().equals(oldpassword))
        {
            System.out.println("U R GODDAMN RIGHT");
            if (client.getUsername()!=null)
            {
                client1.setUsername(client.getUsername());
            }
            if (client.getNom()!=null)
            {
                client1.setNom(client.getNom());
            }
            if (client.getPrenom()!=null)
            {
                client1.setPrenom(client.getPrenom());
            }
            if (client.getEmail()!=null)
            {
                client1.setEmail(client.getEmail());
            }
            if (client.getPassword()!=null)
            {
                client1.setPassword(client.getPassword());
            }
            clientRepository.save(client1);
        }
        else
        {
            System.out.println("wrong one");
        }
    }
    @GetMapping("/clients/byUsername")
    public List<Client> findbyUsername(@RequestParam(name = "Username") String username)
    {
        return clientRepository.findByUsername(username);
    }
    @GetMapping("/clients")
    public List<Client> getAll()
    {
        return clientRepository.findAll();
    }

}
