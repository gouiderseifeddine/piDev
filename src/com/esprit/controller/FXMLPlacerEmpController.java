/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controller;

import com.esprit.entity.Employe;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author saif
 */
public class FXMLPlacerEmpController implements Initializable {

    @FXML
    private ComboBox combo2;
    @FXML
    private Label event_label;
    @FXML
    private Button btn_annuler_placer;
    @FXML
    private Button btn_valider_placement;
    @FXML
    private TableView<Employe> table2;
    @FXML
    private TableColumn<Employe,Employe> emp_dispo;
    @FXML
    private TableColumn<Employe, Integer> id_dispo;
    @FXML
    private TableColumn<Employe, String> tache_dispo;
    @FXML
    private TableColumn<Employe, Employe> emp_ndispo;
    @FXML
    private TableColumn<Employe, Integer> id_ndispo;
    @FXML
    private TableColumn<Employe, String> tache_ndispo;

    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> list = FXCollections.observableArrayList(
                "100% tounsi",
                "كليلة ودمنة",
                "fantastic 4",
                "Avengers",
                "Made in Tunisia");
        combo2.setItems(list);   
  
        btn_annuler_placer.setOnAction(event -> {

            try {
                Parent page2 = FXMLLoader.load(getClass().getResource("/com/esprit/view/FXMLMenu.fxml"));
                Scene scene = new Scene(page2);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLMenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btn_valider_placement.setOnAction(event -> {

            try {
                Parent page2 = FXMLLoader.load(getClass().getResource("/com/esprit/view/FXMLListEmp.fxml"));
                Scene scene = new Scene(page2);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLMenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }    

    @FXML
    private void Select2(ActionEvent event) {
        String s = combo2.getSelectionModel().getSelectedItem().toString();
        event_label.setText(s);
        
    }
    
}