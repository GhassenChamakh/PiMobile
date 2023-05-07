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
        
        setTitle("Home");
        setLayout(BoxLayout.y());
        
        add(new Label("Choose an option"));
        Button btnAddTest = new Button("Add Test");
        Button btnAddMaison = new Button("Add Maison");
        Button btnAddQuestion = new Button("Add Question");
        Button btnAddTask = new Button("Add Task");
        Button btnListTasks = new Button("List Tasks");
         Button btnListMaison = new Button("List Maison");

        Button btnListTests = new Button("List Tests");
         Button btnListQuestions = new Button("List Questions");
          Button btnTheTests = new Button("Passer un Test");
        
      
        btnAddMaison.addActionListener(e-> new AddMaisonForm(this).show());
        btnListMaison.addActionListener(e-> new ListMaisonForm(this).show());
      
        addAll(btnAddMaison,btnListMaison);
        
        
    }
    
    
}
