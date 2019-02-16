/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author nawre
 */
public class Sponsor {

    private int idDemande;
    private String description;
    private String type;
    private String brandName;
    private int etat;
    private int idSponsor;
    private int idEvent;

    public Sponsor() {
    }

    public Sponsor(int idDemande, String description, String type, String brandName, int etat) {
        this.idDemande = idDemande;
        this.description = description;
        this.type = type;
        this.brandName = brandName;
        this.etat = etat;
    }

    public Sponsor(int idDemande, String description, String type, String brandName, int etat, int idSponsor, int idEvent) {
        this.idDemande = idDemande;
        this.description = description;
        this.type = type;
        this.brandName = brandName;
        this.etat = etat;
        this.idSponsor = idSponsor;
        this.idEvent = idEvent;
    }

    public int getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(int idDemande) {
        this.idDemande = idDemande;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIdSponsor() {
        return idSponsor;
    }

    public void setIdSponsor(int idSponsor) {
        this.idSponsor = idSponsor;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    @Override
    public String toString() {
        return "Sponsor{" + "idDemande=" + idDemande + ", description=" + description + ", type=" + type + ", idSponsor=" + idSponsor + '}';
    }

}
