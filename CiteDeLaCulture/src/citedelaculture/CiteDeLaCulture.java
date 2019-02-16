/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citedelaculture;

import Enum.Role;
import Services.SponsorService;
import Services.UserService;
import entities.Sponsor;
import entities.User;

/**
 *
 * @author nawre
 */
public class CiteDeLaCulture {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        User u1 = new User(0, "Nawress", " Nawress1", "Nawress@email", "06984428", Role.Admin, 0, "", 0);
        User u2 = new User(1, "Lina", " Lina1", "lina@email", "00321842", Role.Membre, 1, "", 0);
        User u3 = new User(1, "Lina", " Lina1", "lina@email", "00321842", Role.Membre, 1, "", 0);
        User u4 = new User(2, "login3", " password3", "email3", "cin3", Role.Membre, 1, "", 1);
        Sponsor s1 = new Sponsor(2, "login3", " password3", "email3", 0, 0, 0);

        
        UserService ps = new UserService();
        SponsorService ps1 = new SponsorService();

        
        
        ps1.getAllDemandePremium();
                

    }

}
