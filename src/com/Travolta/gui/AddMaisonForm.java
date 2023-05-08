/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Travolta.gui;

import com.Travolta.entities.MaisonHote;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
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
public class AddMaisonForm extends Form{

    public AddMaisonForm (Form previous) {
        setTitle("Ajouter Maison d Hote");
        setLayout(BoxLayout.y());
        
        TextField tfTitre = new TextField("","Titre maison");
        TextField tfDescription= new TextField("","Description");
        TextField tfAdresse = new TextField("","Adress");
        TextField tfStatus = new TextField("","Status hebergement");
        TextField tfChambre = new TextField("","Nombre de chambre");
        TextField tfPrix = new TextField("","prix");
         TextField tfImage = new TextField("","image");
        Button btnValider = new Button("Ajouter Maison");
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfTitre.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        
                        MaisonHote m = new MaisonHote( tfTitre.getText(),Integer.parseInt(tfPrix.getText()),tfDescription.getText(),tfAdresse.getText(),tfStatus.getText(),Integer.parseInt(tfChambre.getText()),tfImage.getText());
                        if( ServiceMaison.getInstance().addMaison(m))
                        {
                           Dialog.show("Success","Maison ajouter aveec succéss",new Command("OK"));
                        }else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
    
            }
        });
        
        addAll(tfTitre,tfPrix,tfDescription,tfAdresse,tfStatus,tfChambre,tfImage,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
                
    }

   
    
}
