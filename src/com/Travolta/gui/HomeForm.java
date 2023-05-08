/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Travolta.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;


/**
 *
 * @author bhk
 */
public class HomeForm extends Form{

    public HomeForm() {
        
        setTitle("Travolta");
        setLayout(BoxLayout.y());
        
        add(new Label("Travolta"));
        Button btnAddMaison = new Button("Add Maison");
        Button btnAddReservation = new Button("Add Reservation");
        Button btnListReservation = new Button("List Reservation");
         Button btnListMaison = new Button("List Maison");

       
        
      
        btnAddMaison.addActionListener(e-> new AddMaisonForm(this).show());
        btnListMaison.addActionListener(e-> new ListMaisonForm(this).show());
       btnAddReservation.addActionListener(e-> new AddReservationMaison(this).show());
       btnListReservation.addActionListener(e-> new ListReservationForm(this).show());





      
        addAll(btnAddMaison,btnListMaison,btnAddReservation,btnListReservation);
        
        
    }
    
    
}
