/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Travolta.gui;

import com.Travolta.entities.ReservationMaison;
import com.Travolta.services.ServiceReservation;
import static com.codename1.push.PushContent.setTitle;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import java.util.ArrayList;

/**
 *
 * @author Ghassen Chamakh
 */
public class ListReservationForm extends Form {
    
  private ArrayList<ReservationMaison> res;
        private Form current;
    public ListReservationForm (Form previous) {
         setTitle("Liste des Reservation"); 
        setLayout(BoxLayout.y());

        res = ServiceReservation.getInstance().getAllReservations();

        for (ReservationMaison m : res) {
            Container questionContainer = new Container(BoxLayout.y());
            questionContainer.setUIID("ListReservationForm_Container");

             Label choice1Label =new Label("Date Arriver : "+m.getDate_arrivee());
              Label choice1Label1 =new Label("Date Depart : "+m.getDate_depart());
              Label choice1Label2 =new Label("Nom : "+m.getNom());
              Label choice1Label3 =new Label("Prenm : "+m.getPrenom());
              Label choice1Label4 =new Label("email : "+m.getEmail());
              Label choice1Label5 =new Label("Tarif : "+m.getTarif());
              
              Button deleteButton = new Button("Supprimer");
            deleteButton.addActionListener((evt) -> {
                if (Dialog.show("Confirmation", "Voulez-vous vraiment supprimer cette reservation?", "Oui", "Non")) {
                    if (ServiceReservation.getInstance().deleteReservation(m.getId_reservation())) {
                        Dialog.show("Succès", "reservation supprimée avec succès", new Command("OK"));
                        questionContainer.remove();
                    }
                }
            });
            Button editButton = new Button("Modifier");
            editButton.addActionListener((evt) -> {
               new UpdateReservationForm(previous, m, this).show();
            });
            Container buttonsContainer = new Container(new GridLayout(1, 2));
            buttonsContainer.setUIID("ListReservationForm_ButtonsContainer");
            buttonsContainer.add(deleteButton);
            buttonsContainer.add(editButton);
            
            questionContainer.add(choice1Label);
            questionContainer.add(choice1Label1);
            questionContainer.add(choice1Label2);
            questionContainer.add(choice1Label3);
            questionContainer.add(choice1Label4);
            questionContainer.add(choice1Label5);
            questionContainer.add(buttonsContainer);

            add(questionContainer);
        }
           getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());

}
}
