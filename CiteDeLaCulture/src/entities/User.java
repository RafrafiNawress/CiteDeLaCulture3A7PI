/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
import Enum.Role;
/**
 *
 * @author nawre
 */


public class User {
    private int id;
    private String login;
    private String password;
    private String email;
    private String cin;
    private Role role;
    private int active;
    private String photo;
    private int sponsor;

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
    
    
    public User() {
        
        this.login = "";
        this.password = "";
        this.email = "";
        this.cin="";
        this.role = Role.Admin;
        this.active=0;
        this.id = 0;
        this.sponsor=0;
    }

    public User(int id,String login, String password, String email, String cin, Role role,int active, String photo, int sponsor) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.cin=cin;
        this.role = role;
        this.active = active;
        this.photo=photo;
        this.sponsor=sponsor;
    }
    
    

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public int getSponsor() {
        return sponsor;
    }

    public void setSponsor(int sponsor) {
        this.sponsor = sponsor;
    }
    
    
    

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", login=" + login + ", password=" + password + ", email=" + email + ", cin=" + cin + ", role=" + role + ", active=" + active + ", photo=" + photo  + ", sponsor=" + sponsor + '}';
    }
    
    
    
}