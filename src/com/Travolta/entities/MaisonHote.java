/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Travolta.entities;

/**
 *
 * @author Ghassen Chamakh
 */
public class MaisonHote {
    
   
private int id_maison;
    private String titre;
    private float prix;
    private String description;
    private String adresse;
    private String status_hebergement;
    private int nombreChambre ;
    private String image;

    public MaisonHote(int id_maison, String titre, float prix, String description, String adresse, String status_hebergement, int nombreChambre, String image) {
        this.id_maison = id_maison;
        this.titre = titre;
        this.prix = prix;
        this.description = description;
        this.adresse = adresse;
        this.status_hebergement = status_hebergement;
        this.nombreChambre = nombreChambre;
        this.image = image;
    }

    public MaisonHote(String titre, float prix, String description, String adresse, String status_hebergement, int nombreChambre, String image) {
        this.titre = titre;
        this.prix = prix;
        this.description = description;
        this.adresse = adresse;
        this.status_hebergement = status_hebergement;
        this.nombreChambre = nombreChambre;
        this.image = image;
    }

    public MaisonHote(int id_maison) {
        this.id_maison = id_maison;
    }

    public MaisonHote() {
    }

    public int getId_maison() {
        return id_maison;
    }

    public void setId_maison(int id_maison) {
        this.id_maison = id_maison;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getStatus_hebergement() {
        return status_hebergement;
    }

    public void setStatus_hebergement(String status_hebergement) {
        this.status_hebergement = status_hebergement;
    }

    public int getNombreChambre() {
        return nombreChambre;
    }

    public void setNombreChambre(int chambre) {
        this.nombreChambre = chambre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "MaisonHote{" + "id_maison=" + id_maison + ", titre=" + titre + ", prix=" + prix + ", description=" + description + ", adresse=" + adresse + ", status_hebergement=" + status_hebergement + ", chambre=" + nombreChambre + ", image=" + image + '}';
    }
    
    
}


