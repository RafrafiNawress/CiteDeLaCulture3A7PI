/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Enum.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyDB;
import entities.User;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author nawre
 */
public class UserService {

    Connection cnx;

    public UserService() {
        cnx = MyDB.getInstance().getConnexion();
    }

    public void ajouterUser(User t) {

        String request = "INSERT INTO `user`(`id`, `login`, `password`, `email`, `cin`, `role`, `active`, `photo`, `sponsor`) VALUES (NULL, '" + t.getLogin() + "', '" + t.getPassword() + "','" + t.getEmail() + "','" + t.getCin() + "','" + t.getRole() + "','" + t.getActive() + "','" + t.getPhoto() + "','" + t.getSponsor() + "')";
        try {
            Statement stm = cnx.createStatement();
            stm.executeUpdate(request);
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public User getUseryId(int id) {
        String request = "select user.id,login,password,email,cin,active,photo,sponsor from user where id=" + id;
        User t = new User();
        try {
            Statement stm = cnx.createStatement();
            ResultSet res = stm.executeQuery(request);
            if (res.next()) {
                t.setId(res.getInt(1));
                t.setLogin(res.getString(2));
                t.setPassword(res.getString(3));
                t.setEmail(res.getString(4));
                t.setCin(res.getString(5));
                t.setActive(res.getInt(6));
                t.setPhoto(res.getString(7));
                t.setSponsor(res.getInt(8));

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }

    public User getUseryCin(String email) {
        String request = "select user.cin,login,password,email,cin,active,photo,sponsor from user where id=" + email;
        User t = new User();
        try {
            Statement stm = cnx.createStatement();
            ResultSet res = stm.executeQuery(request);
            if (res.next()) {
                t.setId(res.getInt(1));
                t.setLogin(res.getString(2));
                t.setPassword(res.getString(3));
                t.setEmail(res.getString(4));
                t.setCin(res.getString(5));
                t.setActive(res.getInt(6));
                t.setPhoto(res.getString(7));
                t.setSponsor(res.getInt(8));

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }

    public ArrayList<User> getAllUSers() {
        ArrayList<User> resultat = new ArrayList<>();

        try {
            Statement st = cnx.createStatement();
            ResultSet res = st.executeQuery("select * from user");
            while (res.next()) {
                User p = new User();
                p.setId(res.getInt(1));
                p.setLogin(res.getString(2));
                p.setPassword(res.getString(3));
                p.setEmail(res.getString(4));
                p.setCin(res.getString(5));
                p.setActive(res.getInt(7));
                p.setPhoto(res.getString(8));
                p.setSponsor(res.getInt(9));
                resultat.add(p);
            }
            for (User u : resultat) {
                System.out.println(u);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultat;
    }

    public ArrayList<User> getAllUSersActive() {
        ArrayList<User> resultat = new ArrayList<>();

        try {
            Statement st = cnx.createStatement();
            ResultSet res = st.executeQuery("select * from user where active=1");
            while (res.next()) {
                User p = new User();
                p.setId(res.getInt(1));
                p.setLogin(res.getString(2));
                p.setPassword(res.getString(3));
                p.setEmail(res.getString(4));
                p.setCin(res.getString(5));
                p.setActive(res.getInt(7));
                p.setPhoto(res.getString(8));
                p.setSponsor(res.getInt(9));

                resultat.add(p);
            }
            for (User u : resultat) {
                System.out.println(u);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultat;
    }

    public void supprimerUser(User u) {
        try {
            String query = "delete from `user` where cin =?";
            PreparedStatement st = cnx.prepareStatement(query);

            st.setString(1, u.getCin());
            st.execute();

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modifierPwd(User u) {
        String request = "update user set password=? where id=" + u.getId();
        try {

            PreparedStatement ps = cnx.prepareStatement(request);
            ps.setString(1, u.getPassword());

            ps.executeUpdate();
            System.out.println("Mot de passe modifé");
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modifierLogin(User u) {
        String request = "update user set login=? where id=" + u.getId();
        try {

            PreparedStatement ps = cnx.prepareStatement(request);
            ps.setString(1, u.getLogin());

            ps.executeUpdate();
            System.out.println("Login modifé");
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User afficherUserRole(String cin) {
        User u = new User();
        try {
            String query = "select * from user where cin = ?;";
            PreparedStatement stm = cnx.prepareStatement(query);
            stm.setString(1, cin);
            ResultSet rest = stm.executeQuery();
            while (rest.next()) {
                u.setCin(rest.getString("cin"));
                u.setLogin(rest.getString("login"));

                if (rest.getString("role").equals("Membre")) {
                    u.setRole(Role.Membre);
                    System.out.println("Membre");
                }
                if (rest.getString("role").equals("Admin")) {
                    u.setRole(Role.Admin);
                    System.out.println("Admin");
                }

                if (rest.getString("role").equals("Organisateur")) {
                    u.setRole(Role.Organisateur);
                    System.out.println("Organisateur");
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }

    public User login(String cin, String pwd) {
        User u = new User();
        try {
            String query = "select * from user where password = ? and (cin = ? OR email = ?);";
            PreparedStatement stm = cnx.prepareStatement(query);
            stm.setString(1, pwd);
            stm.setString(2, cin);
            stm.setString(3, cin);
            ResultSet rest = stm.executeQuery();
            while (rest.next()) {
                u.setCin(rest.getString("cin"));
                u.setLogin(rest.getString("login"));

                if (rest.getString("role").equals("Membre")) {
                    u.setRole(Role.Membre);
                }

                if (rest.getString("role").equals("Admin")) {
                    u.setRole(Role.Admin);
                }
                if (rest.getString("role").equals("Organisateur")) {
                    u.setRole(Role.Organisateur);
                }

                u.setActive(1);

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);

        }
        return u;

    }

    public Boolean exist(String cin) {

        Boolean u = false;
        try {

            String query = "select count(*) as nombre from user where cin = ? ;";
            PreparedStatement stm = cnx.prepareStatement(query);
            stm.setString(1, cin);
            ResultSet rest = stm.executeQuery();
            while (rest.next()) {
                if (rest.getInt("nombre") == 1) {
                    u = true;
                } else {
                    u = false;

                }
                System.out.println(u);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }

    public void activation(int i) {
        try {
            String query = "update `user` set active ='1' WHERE `user`.`id` =" + i;
            PreparedStatement st = cnx.prepareStatement(query);

            st.execute();

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void desactivation(int i) {
        try {
            String query = "UPDATE `user` SET `active` = '0' WHERE `user`.`id` =" + i;
            PreparedStatement st = cnx.prepareStatement(query);

            st.execute();

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
