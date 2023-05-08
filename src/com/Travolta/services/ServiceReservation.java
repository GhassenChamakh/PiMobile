/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Travolta.services;

import com.Travolta.entities.ReservationMaison;
import com.Travolta.utils.Statics;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ghassen Chamakh
 */
public class ServiceReservation {
    
    
 public ArrayList<ReservationMaison> res;

    public static ServiceReservation instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceReservation() {
        req = new ConnectionRequest();
    }

    public static ServiceReservation getInstance() {
        if (instance == null) {
            instance = new ServiceReservation();
        }
        return instance;
    }

    public boolean addReservation(ReservationMaison  m) {

        
       String ar=m.getDate_arrivee();
       String dp=m.getDate_depart();
        String nom=m.getNom();
        String prenom=m.getPrenom();
         String email=m.getEmail();
         float tarif=m.getTarif();
        int user=m.getUser_id();
        int maison=m.getId_maison();
        System.out.println(m.toString());
        String url = Statics.BASE_URL + "/addResJSON/new?dateArrivee=" + ar + "&dateDepart="+  dp+"&nom=" +nom+"&prenom="+prenom +"&email="+ email +"&tarif="+tarif+"&idMaison="+maison+"&User_id="+user;
       // String url = Statics.BASE_URL + "/create/" + titre + "/" + prix+ "/" + description+ "/" + adresse+ "/" + status_hebergement+ "/" + chambre+ "/" + image;

        req.setUrl(url);
        req.setPost(true);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

// public boolean addMaison(MaisonHote  m) {
//
//        //1
//        String addURL = Statics.BASE_URL + "/addMaisonJSON/new";
//
//        //2
//        req.setUrl(addURL);
//
//        //3
//        req.setPost(false);
//
//        //4
//      
//        
//        req.addArgument("titre", m.getTitre());
//        req.addArgument("prix", m.getPrix() + "");
//        req.addArgument("description", m.getDescription() + "");
//        req.addArgument("adresse", m.getAdresse() + "");
//        req.addArgument("status_hebergement", m.getStatus_hebergement() + "");
//        req.addArgument("NombreChambre", m.getChambre() + "");
//        req.addArgument("image", m.getImage() + "");
//
//
//        //5
//        req.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//                resultOK = req.getResponseCode() == 200;
//                req.removeResponseListener(this);
//            }
//        });
//
//        NetworkManager.getInstance().addToQueueAndWait(req);
//
//        return resultOK;
//    }

    public ArrayList<ReservationMaison> parseReservation(String jsonText) {
        try {
            res = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> ResListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) ResListJson.get("root");
            for (Map<String, Object> obj : list) {
                ReservationMaison m = new ReservationMaison();
                float id = Float.parseFloat(obj.get("id_reservation").toString());
                m.setId_maison((int) id);
                //m.setTitre(((int) Float.parseFloat(obj.get("status").toString())));
                m.setDate_arrivee(obj.get("dateArrivee").toString());
                m.setDate_depart(obj.get("dateDepart").toString());
                m.setTarif(Float.parseFloat(obj.get("tarif").toString()));
                m.setNom(obj.get("nom").toString());
                m.setPrenom(obj.get("prenom").toString());
                 m.setEmail(obj.get("email").toString());
                float id2 = Float.parseFloat(obj.get("userId").toString());
                m.setUser_id((int) id2);
                float id1 = Float.parseFloat(obj.get("idMaison").toString());
                m.setId_maison((int) id1);
                
                res.add(m);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return res;
    }

    public ArrayList<ReservationMaison> getAllReservations() {
        String url = Statics.BASE_URL + "/AllResJSON";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                res = parseReservation(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return res;
    }
    public boolean updateReservation(ReservationMaison m)
    {

        String url = Statics.BASE_URL+"/updateReservationJSON/"+m.getId_reservation()+"?dateArrivee=" + m.getDate_arrivee() + "&dateDepart="+  m.getDate_depart()+"&nom=" +m.getNom()+"&prenom="+m.getPrenom() +"&email="+ m.getEmail() +"&tarif="+m.getTarif()+"&idMaison="+m.getId_maison()+"&User_id="+m.getUser_id();
        req.setUrl(url);
    req.addResponseListener((e) -> {
                        resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
        String str = new String(req.getResponseData());
        //System.out.println("data"+str);
    });
        NetworkManager.getInstance().addToQueueAndWait(req);
return resultOK;
    }
    public boolean deleteReservation(int id) {
        String url = Statics.BASE_URL + "/deleteReservationJSON/" + id ;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200;
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
}


