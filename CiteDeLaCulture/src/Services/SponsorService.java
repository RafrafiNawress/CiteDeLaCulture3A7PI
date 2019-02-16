/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import entities.Sponsor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyDB;

/**
 *
 * @author nawre
 */
public class SponsorService {

    Connection cnx;

    public SponsorService() {
        cnx = MyDB.getInstance().getConnexion();
    }

    public void ajouterDemandeSponsor(Sponsor t) {

        String request1 = "INSERT INTO `sponsor`(`idDemande`, `description`, `type`, `brandName`, `etat`, `idSponsor`,`idEvent`) VALUES (NULL, '" + t.getDescription() + "','" + t.getType() + "','" + t.getBrandName() + "','" + t.getEtat() + "','" + t.getIdSponsor() + "','" + t.getIdEvent() + "')";
        try {
            Statement stm = cnx.createStatement();

            stm.executeUpdate(request1);
            System.out.println("Demande ajouté , Veuillez attendez la validation ");
        } catch (SQLException ex) {
            Logger.getLogger(SponsorService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Sponsor getDemandeByID(int id) {
        String request = "select sponsor.idDemande,description,type,brandName,etat, idSponsor,idEvent from sponsor where idDemande=" + id;
        Sponsor t = new Sponsor();
        try {
            Statement stm = cnx.createStatement();
            ResultSet res = stm.executeQuery(request);
            if (res.next()) {
                t.setIdDemande(res.getInt(1));
                t.setDescription(res.getString(2));
                t.setType(res.getString(3));
                t.setBrandName(res.getString(4));
                t.setEtat(res.getInt(5));
                t.setIdSponsor(res.getInt(6));
                t.setIdEvent(res.getInt(7));
                System.out.println("IdEvenement :" + t.getIdEvent() + " " + "Description :" + t.getDescription() + " type :" + t.getType() + " Brand Name :" + t.getBrandName() + "Etat du l'evenement :" + t.getEtat());

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }

    public Sponsor getDemandeByIDSponsor(int id) {
        String request = "select sponsor.idDemande,description,type,brandName,idSponsor,idEvent from sponsor where etat=1 and idSponsor=" + id;
        Sponsor t = new Sponsor();
        try {
            Statement stm = cnx.createStatement();
            ResultSet res = stm.executeQuery(request);
            if (res.next()) {
                t.setIdDemande(res.getInt(1));
                t.setDescription(res.getString(2));
                t.setType(res.getString(3));
                t.setBrandName(res.getString(4));
                t.setIdSponsor(res.getInt(5));

                System.out.println("IdSponsor :" + t.getIdSponsor() + " " + "Description :" + t.getDescription() + " type :" + t.getType() + " Brand Name :" + t.getBrandName());

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }

    public ArrayList<Sponsor> getAllDemande() {
        ArrayList<Sponsor> resultat = new ArrayList<>();

        try {
            Statement st = cnx.createStatement();
            ResultSet res = st.executeQuery("select * from sponsor");
            while (res.next()) {
                Sponsor p = new Sponsor();
                p.setIdDemande(res.getInt(1));
                p.setDescription(res.getString(2));
                p.setType(res.getString(3));
                p.setBrandName(res.getString(4));
                p.setEtat(res.getInt(5));
                p.setIdSponsor(res.getInt(6));
                p.setIdEvent(res.getInt(7));
                resultat.add(p);
            }
            for (Sponsor u : resultat) {
                System.out.println(u);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultat;
    }

    public void supprimerDemande(Sponsor u) {
        try {
            String query = "delete from `user` where etat=0 and idDemande =?";
            PreparedStatement st = cnx.prepareStatement(query);

            st.setInt(1, u.getIdDemande());
            st.execute();
            System.out.println("Demande Supprimée");

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modifierDemande(Sponsor u) {
        String request = "update sponsor set description=? ,type=?, brandName=? where etat=0 and idDemande=" + u.getIdDemande();
        try {

            PreparedStatement ps = cnx.prepareStatement(request);
            ps.setString(2, u.getDescription());
            ps.setString(3, u.getType());
            ps.setString(4, u.getBrandName());

            ps.executeUpdate();
            System.out.println("Demande modifée");
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int nombreEvenementByIdSponsor(int id) {
        int nb = 0;
        try {
            Statement stm = cnx.createStatement();
            ResultSet res = stm.executeQuery("Select count(*) as nombre from sponsor where idSponsor=" + id);
            while (res.next()) {
                nb = res.getInt("nombre");
                System.out.println(nb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nb;

    }

    public int nombreSponsorByEvent(int id) {
        int nb = 0;
        try {
            Statement stm = cnx.createStatement();
            ResultSet res = stm.executeQuery("Select count(*) as nombre from sponsor where idEvent=" + id);
            while (res.next()) {
                nb = res.getInt("nombre");
                System.out.println(nb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nb;

    }

    public void validerDemande(int i) {
        try {
            String query = "update sponsor set etat ='1' WHERE sponsor.idDemande=" + i;
            PreparedStatement st = cnx.prepareStatement(query);

            st.execute();
            System.out.println("Demande validée");
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Sponsor> getAllDemandePremium() {
        ArrayList<Sponsor> resultat = new ArrayList<>();

        try {
            Statement st = cnx.createStatement();
            ResultSet res = st.executeQuery("select * from sponsor inner join event on sponsor.idEvent = event.evenement_id where package='Premium'");
            while (res.next()) {
                Sponsor p = new Sponsor();
                p.setIdDemande(res.getInt(1));
                p.setDescription(res.getString(2));
                p.setType(res.getString(3));
                p.setBrandName(res.getString(4));
                p.setEtat(res.getInt(5));
                p.setIdSponsor(res.getInt(6));
                p.setIdEvent(res.getInt(7));
                resultat.add(p);
            }
            for (Sponsor u : resultat) {
                System.out.println(u);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultat;
    }

}
