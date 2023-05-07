/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Travolta.gui;

import com.Travolta.entities.MaisonHote;
import com.codename1.components.MultiButton;
import static com.codename1.push.PushContent.setTitle;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.Travolta.services.ServiceMaison;
import java.util.ArrayList;

/**
 *
 * @author Ghassen Chamakh
 */
public class ListMaisonForm  extends Form {

       private ArrayList<MaisonHote> maisons;
        private Form current;
    public ListMaisonForm (Form previous) {
         setTitle("Liste des Maisons"); 
        setLayout(BoxLayout.y());

        maisons = ServiceMaison.getInstance().getAllMaisons();

        for (MaisonHote m : maisons) {
            Container questionContainer = new Container(BoxLayout.y());
            questionContainer.setUIID("ListMaisonForm_Container");

             Label choice1Label =new Label("Titre : "+m.getTitre());
              Label choice1Label1 =new Label("Prix : "+m.getPrix());
              Label choice1Label2 =new Label("Description : "+m.getDescription());
              Label choice1Label3 =new Label("Adresse : "+m.getAdresse());
              Label choice1Label4 =new Label("Status hebergement : "+m.getStatus_hebergement());
              Label choice1Label5 =new Label("Nombre de Chambre : "+m.getNombreChambre());
              Label choice1Label6 =new Label("Image : "+m.getImage());
              
              Button deleteButton = new Button("Supprimer");
            deleteButton.addActionListener((evt) -> {
                if (Dialog.show("Confirmation", "Voulez-vous vraiment supprimer cette question ?", "Oui", "Non")) {
                    if (ServiceMaison.getInstance().deleteMaison(m.getId_maison())) {
                        Dialog.show("Succès", "Question supprimée avec succès", new Command("OK"));
                        questionContainer.remove();
                    }
                }
            });
            Button editButton = new Button("Modifier");
            editButton.addActionListener((evt) -> {
                new UpdateMaisonForm(previous, m, this).show();
            });
            Container buttonsContainer = new Container(new GridLayout(1, 2));
            buttonsContainer.setUIID("ListMaisonForm_ButtonsContainer");
            buttonsContainer.add(deleteButton);
            buttonsContainer.add(editButton);
            
            questionContainer.add(choice1Label);
            questionContainer.add(choice1Label1);
            questionContainer.add(choice1Label2);
            questionContainer.add(choice1Label3);
            questionContainer.add(choice1Label4);
            questionContainer.add(choice1Label5);
            questionContainer.add(choice1Label6);
            questionContainer.add(buttonsContainer);

            add(questionContainer);
        }
           getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());

}
}