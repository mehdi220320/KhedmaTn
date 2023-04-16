package com.gg.khedmatn.Verification;

import com.gg.khedmatn.Entities.Client;
import com.gg.khedmatn.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class Verification {
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
    @Autowired
    ClientRepository clientRepository;
    public boolean EmailExistanceVerify(String email){
       if (clientRepository.findByEmail(email).size()>0)
       return true;
       else return false;
    }
    public boolean PasswordVerify(String Email,String Password)
    {
        Client client= (Client) clientRepository.findByEmail(Email);
        if(client.getPassword().equals(Password))
            return true;
        else return false;
    }

}
