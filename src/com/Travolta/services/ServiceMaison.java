/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Travolta.services;

import com.Travolta.entities.MaisonHote;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.Travolta.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ghassen Chamakh
 */
public class ServiceMaison {
    public ArrayList<MaisonHote> maisons;

    public static ServiceMaison instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceMaison() {
        req = new ConnectionRequest();
    }

    public static ServiceMaison getInstance() {
        if (instance == null) {
            instance = new ServiceMaison();
        }
        return instance;
    }

    public boolean addMaison(MaisonHote  m) {

        
       String titre=m.getTitre();
       float prix=m.getPrix();
        String description=m.getDescription();
        String adresse=m.getAdresse();
         String status_hebergement=m.getStatus_hebergement();
         Integer nombreChambre=m.getNombreChambre();
        String image=m.getImage();
        System.out.println(m.toString());
        String url = Statics.BASE_URL + "/addMaisonJSON/new?titre=" + titre + "&prix="+  prix +"&description=" +description +"&adresse="+adresse +"&status_hebergement="+ status_hebergement +"&nombreChambre="+nombreChambre+"&image="+image;
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

    public ArrayList<MaisonHote> parseMaison(String jsonText) {
        try {
            maisons = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> MaisonListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) MaisonListJson.get("root");
            for (Map<String, Object> obj : list) {
                MaisonHote m = new MaisonHote();
                float id = Float.parseFloat(obj.get("idMaison").toString());
                m.setId_maison((int) id);
                //m.setTitre(((int) Float.parseFloat(obj.get("status").toString())));
                m.setTitre(obj.get("titre").toString());
                m.setDescription(obj.get("description").toString());
                m.setPrix(Float.parseFloat(obj.get("prix").toString()));
                m.setAdresse(obj.get("adresse").toString());
                m.setStatus_hebergement(obj.get("statusHebergement").toString());
                float id2 = Float.parseFloat(obj.get("nombreChambre").toString());
                m.setNombreChambre((int) id2);
                m.setImage(obj.get("image").toString());
                
                maisons.add(m);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return maisons;
    }

    public ArrayList<MaisonHote> getAllMaisons() {
        String url = Statics.BASE_URL + "/maisonJson";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                maisons = parseMaison(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return maisons;
    }
    public boolean updateMaison(MaisonHote t)
    {

        String url = Statics.BASE_URL+"/updateMaisonJSON/"+t.getId_maison()+"?titre=" + t.getTitre() + "&prix="+  t.getPrix() +"&description=" +t.getDescription() +"&adresse="+t.getAdresse() +"&status_hebergement="+ t.getStatus_hebergement() +"&nombreChambre="+t.getNombreChambre()+"&image="+t.getImage();
        req.setUrl(url);
    req.addResponseListener((e) -> {
                        resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
        String str = new String(req.getResponseData());
        //System.out.println("data"+str);
    });
        NetworkManager.getInstance().addToQueueAndWait(req);
return resultOK;
    }
    public boolean deleteMaison(int id) {
        String url = Statics.BASE_URL + "/deletemaisonJSON/" + id ;
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


