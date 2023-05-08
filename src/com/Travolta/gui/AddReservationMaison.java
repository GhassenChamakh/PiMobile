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
public class AddReservationMaison extends Form {
    
    public AddReservationMaison(Form previous) {
        setTitle("Ajouter Maison d'Hote");
        setLayout(BoxLayout.y());
        
        TextField tfAr = new TextField("", "Date arrivée");
        TextField tfDp = new TextField("", "Date départ");
        TextField tfNom = new TextField("", "Nom");
        TextField tfPrenom = new TextField("", "Prénom");
        TextField tfEmail = new TextField("", "Email");
        TextField tfTarif = new TextField("", "Tarif");
        TextField tfMaison = new TextField("", "Maison");
        TextField tfUser = new TextField("", "User");

        Button btnValider = new Button("Réserver maintenant");
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (tfNom.getText().length() == 0) {
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                } else {
                    try {
                        ReservationMaison m = new ReservationMaison(
                            tfAr.getText(),
                            tfDp.getText(),
                            tfNom.getText(),
                            tfPrenom.getText(),
                            tfEmail.getText(),
                            Float.parseFloat(tfTarif.getText()),
                            Integer.parseInt(tfMaison.getText()),
                            Integer.parseInt(tfUser.getText())
                        );
                        if (ServiceReservation.getInstance().addReservation(m)) {
                            Dialog.show("Success", "Reservation ajoutée avec succès", new Command("OK"));
                        } else {
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                        }
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Tarif, Maison et User doivent être des nombres", new Command("OK"));
                    }
                }
            }
        });
        
        addAll(tfAr, tfDp, tfNom, tfPrenom, tfEmail, tfTarif, tfMaison, tfUser, btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    }
}
