/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Travolta.gui;

import com.Travolta.entities.MaisonHote;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.Travolta.services.ServiceMaison;

/**
 *
 * @author Ghassen Chamakh
 */
public class UpdateMaisonForm extends Form{
    public UpdateMaisonForm(Form previous, MaisonHote q,Form ListMaisonForm) {
        setTitle("modifier Maison");
        setLayout(BoxLayout.y());
        TextField tfTitre = new TextField(q.getTitre(),"Titre maison");
        TextField tfDescription= new TextField(q.getDescription(),"Description");
        TextField tfAdresse = new TextField(q.getAdresse(),"Adress");
        TextField tfStatus = new TextField(q.getStatus_hebergement(),"Status hebergement");
        TextField tfChambre = new TextField("","Nombre de chambre");
        TextField tfPrix = new TextField("","prix");
         TextField tfImage = new TextField("","image");
        Button btnValider = new Button("Modifier Maison");
       btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfTitre.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try{
                        q.setId_maison(q.getId_maison());
                        q.setTitre(tfTitre.getText());
                        q.setDescription(tfDescription.getText());
                        q.setAdresse(tfAdresse.getText());
                        q.setStatus_hebergement(tfStatus.getText());
                       float id2 = Float.parseFloat(tfPrix.getText().toString());
                        int nombreChambre = Integer.parseInt(tfChambre.getText().toString());

                        q.setNombreChambre(nombreChambre);
                        q.setPrix(id2);
                        q.setImage(tfImage.getText());;
                        if ( new ServiceMaison().getInstance().updateMaison(q))
                            Dialog.show("Success", "Maison Modifier avec success", new Command("Ok"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    }catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(tfTitre,tfDescription,tfAdresse,tfStatus,tfPrix,tfChambre,tfImage,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
                
    }
    
}
