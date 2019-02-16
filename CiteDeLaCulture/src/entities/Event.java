/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;
import Enum.Package;

/**
 *
 * @author nawre
 */
public class Event {
    private int evenement_id;
    private String nom;
    private Date date_debut;
    private Date date_fin;
    private String salle;
    private int disponibles;
    private float cout_reservation;
    private int age;
    private float prix;
    private float prix_etudiants;
    private String description;
    private String img;
    private int etat;
    private User user;
    private Package p;

    public Event() {
    }

    public Event(int evenement_id, String nom, Date date_debut, Date date_fin, String salle, int disponibles, float cout_reservation, int age, float prix, float prix_etudiants, String description, String img, int etat, User user, Package p) {
        this.evenement_id = evenement_id;
        this.nom = nom;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.salle = salle;
        this.disponibles = disponibles;
        this.cout_reservation = cout_reservation;
        this.age = age;
        this.prix = prix;
        this.prix_etudiants = prix_etudiants;
        this.description = description;
        this.img = img;
        this.etat = etat;
        this.user = user;
        this.p = p;
    }

    public int getEvenement_id() {
        return evenement_id;
    }

    public void setEvenement_id(int evenement_id) {
        this.evenement_id = evenement_id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    public int getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(int disponibles) {
        this.disponibles = disponibles;
    }

    public float getCout_reservation() {
        return cout_reservation;
    }

    public void setCout_reservation(float cout_reservation) {
        this.cout_reservation = cout_reservation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public float getPrix_etudiants() {
        return prix_etudiants;
    }

    public void setPrix_etudiants(float prix_etudiants) {
        this.prix_etudiants = prix_etudiants;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Package getP() {
        return p;
    }

    public void setP(Package p) {
        this.p = p;
    }

    @Override
    public String toString() {
        return "Event{" + "evenement_id=" + evenement_id + ", nom=" + nom + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", salle=" + salle + ", disponibles=" + disponibles + ", cout_reservation=" + cout_reservation + ", age=" + age + ", prix=" + prix + ", prix_etudiants=" + prix_etudiants + ", description=" + description + ", img=" + img + ", etat=" + etat + ", user=" + user + ", p=" + p + '}';
    }
    
    
    
    
}