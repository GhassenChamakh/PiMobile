/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Travolta.gui;

import com.Travolta.entities.ReservationMaison;
import com.Travolta.services.ServiceReservation;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author Ghassen Chamakh
 */
public class UpdateReservationForm  extends Form{
    public UpdateReservationForm(Form previous, ReservationMaison q,Form ListMaisonForm) {
        setTitle("modifier Reservation");
        setLayout(BoxLayout.y());
         TextField tfAr = new TextField(q.getDate_arrivee(), "Date arrivée");
        TextField tfDp = new TextField(q.getDate_depart(), "Date départ");
        TextField tfNom = new TextField(q.getNom(), "Nom");
        TextField tfPrenom = new TextField(q.getPrenom(), "Prénom");
        TextField tfEmail = new TextField(q.getEmail(), "Email");
        TextField tfTarif = new TextField("", "Tarif");
        TextField tfMaison = new TextField("", "Maison");
        TextField tfUser = new TextField("", "User");
        Button btnValider = new Button("Modifier Reservation");
       btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfNom.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try{
                        q.setId_reservation(q.getId_reservation());
                        q.setDate_arrivee(tfAr.getText());
                        q.setDate_depart(tfDp.getText());
                        q.setNom(tfNom.getText());
                        q.setPrenom(tfPrenom.getText());
                         q.setEmail(tfEmail.getText());
                        
                       float id2 = Float.parseFloat(tfTarif.getText().toString());
                        int maison = Integer.parseInt(tfMaison.getText().toString());
                     int user = Integer.parseInt(tfUser.getText().toString());


                        q.setTarif(id2);
                        q.setId_maison(maison);
                        q.setUser_id(user);;
                        if ( new ServiceReservation().getInstance().updateReservation(q))
                            Dialog.show("Success", "Maison Modifier avec success", new Command("Ok"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    }catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(tfAr,tfDp,tfNom,tfPrenom,tfEmail,tfTarif,tfMaison,tfUser,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
                
    }
    
}
