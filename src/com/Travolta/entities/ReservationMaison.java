/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Travolta.entities;

/**
 *
 * @author Ghassen Chamakh
 */
public class ReservationMaison {
     private int id_reservation;
    private String date_arrivee;
    private String date_depart;
    private String nom;
    private String prenom;
    private String email;
    private float tarif;
    private int id_maison;
    private int user_id;

    public ReservationMaison(int id_reservation, String date_arrivee, String date_depart, String nom, String prenom, String email, float tarif, int id_maison, int user_id) {
        this.id_reservation = id_reservation;
        this.date_arrivee = date_arrivee;
        this.date_depart = date_depart;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tarif = tarif;
        this.id_maison = id_maison;
        this.user_id = user_id;
    }

    public ReservationMaison() {
    }

    public ReservationMaison(String date_arrivee, String date_depart, String nom, String prenom, String email, float tarif, int id_maison, int user_id) {
        this.date_arrivee = date_arrivee;
        this.date_depart = date_depart;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tarif = tarif;
        this.id_maison = id_maison;
        this.user_id = user_id;
    }

    public ReservationMaison(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public int getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public String getDate_arrivee() {
        return date_arrivee;
    }

    public void setDate_arrivee(String date_arrivee) {
        this.date_arrivee = date_arrivee;
    }

    public String getDate_depart() {
        return date_depart;
    }

    public void setDate_depart(String date_depart) {
        this.date_depart = date_depart;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getTarif() {
        return tarif;
    }

    public void setTarif(float tarif) {
        this.tarif = tarif;
    }

    public int getId_maison() {
        return id_maison;
    }

    public void setId_maison(int id_maison) {
        this.id_maison = id_maison;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "ReservationMaison{" + "id_reservation=" + id_reservation + ", date_arrivee=" + date_arrivee + ", date_depart=" + date_depart + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", tarif=" + tarif + ", id_maison=" + id_maison + ", user_id=" + user_id + '}';
    }
    
}
