package com.gg.khedmatn.Web;

import com.gg.khedmatn.Entities.Client;
import com.gg.khedmatn.Entities.Employeur;
import com.gg.khedmatn.Model.EmpAndService;
import com.gg.khedmatn.Repositories.ClientRepository;
import com.gg.khedmatn.Repositories.EmployeurRepository;
import com.gg.khedmatn.Verification.Verification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HomePageController {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    EmployeurRepository employeurRepository;
    Verification verification;
    @Value("${passwordmessage}")
    private String passwordmessage;
    @Value("${emailNotEXmessage}")
    private String emailNotEXmessage;
    @GetMapping(value = { "/", "/index" })
    public String index() {
        return "index";
    }
    @GetMapping(value = {"/signin"})
    public ModelAndView SignIn(Model model)
    {
        Client client=new Client();
        model.addAttribute("client",client);
        return new ModelAndView("signin");
    }
    @GetMapping("/create")
    public ModelAndView CreateClient(Model model) {
        Client client=new Client();
        model.addAttribute("client",client);
        return new ModelAndView( "create");}

    public boolean EmailExistanceVerify(String email){
        if (clientRepository.findByEmail(email).size()>0)
            return true;
        else return false;
    }
    public boolean PasswordVerify(String Email,String Password)
    {
        List<Client> client=new ArrayList<Client>();
        client= clientRepository.findByEmail(Email);
        if(client.get(0).getPassword().equals(Password))
            return true;
        else return false;
    }
    public Client getClientByEmailAndPassword(String email,String password) {
        Optional<Client> option=clientRepository.findByEmailAndPassword(email,password);
        Client client=null;
        if(option.isPresent())
        {
            client=option.get();
        }
        else
        {
            throw  new RuntimeException("Client not found for id :: "+email);
        }
        return client;
    }
    @PostMapping("/signin")
    public ModelAndView Signin(Model model ,@ModelAttribute("client") Client client)
    {
        Client client1=new Client();
        if(EmailExistanceVerify(client.getEmail()))
    {
        if(PasswordVerify(client.getEmail(),client.getPassword()))
        { client1=getClientByEmailAndPassword(client.getEmail(),client.getPassword());
            client.setId(client1.getId());
            model.addAttribute("client",client1);
            return new ModelAndView("redirect:/api/Home");}
        else
        {
            model.addAttribute("passwordmessage", passwordmessage);
        }
    }else
        model.addAttribute("emailNotEXmessage", emailNotEXmessage);
    return new ModelAndView("signin");
    }
    public Client getClientById(long id) {
        Optional<Client> option=clientRepository.findById(id);
        Client client=null;
        if(option.isPresent())
        {
            client=option.get();
        }
        else
        {
            throw  new RuntimeException("Client not found for id :: "+id);
        }
        return client;
    }
    @GetMapping("/Home")
    public ModelAndView Getin( Model model) {
        return  new ModelAndView("Home");
    }
    @GetMapping("/createEmployeur")
    public ModelAndView CreateEmployeur(Model model) {
        EmpAndService empAndService=new EmpAndService();
        model.addAttribute("empAndService",empAndService);
        return new ModelAndView("createEmployeur");}
     @GetMapping("/Search")
    public  ModelAndView Search(){
        return new ModelAndView("Search");
     }
    @GetMapping("/potfolio")
    public  ModelAndView Search2(){
        return new ModelAndView("potfolio");
    }


}
