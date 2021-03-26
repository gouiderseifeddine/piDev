/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controller;

import com.esprit.dao.ServiceEmp;
import com.esprit.entity.Employe;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author saif
 */
public class FXMLListEmpController implements Initializable {

    @FXML
    private TableView<Employe> table;
    
    @FXML
    private TableColumn<Employe, String> nom;
    @FXML
    private TableColumn<Employe, String> prenom;
    @FXML
    private TableColumn<Employe, String> tache;
    @FXML
    private TableColumn<Employe, String> mobile;
    @FXML
    private TableColumn<Employe, Integer> salle;
    
    
    ObservableList<PieChart.Data> list1=FXCollections.
            observableArrayList();
    /**
     * Initializes the controller class.
     */
    
    ObservableList<Employe> list = FXCollections.observableArrayList(
            new Employe("Gouider","Saif","Technicien","27621983",2),
            new Employe("Ben Gouta","Monam","Technicien","27055177",2),
            new Employe("M'sahal","Hbib","architecte","29473912",4),
            new Employe("Zaibi","ahmed","ingenieur","98525362",1),
            new Employe("eddine","baha","Technicien","40402121",1),
            new Employe("Ben gouta","Naim","architecte","26265555",5)
    );
    @FXML
    private Button btn_payer;
    @FXML
    private PieChart chrt_emp;
    @FXML
    private Label label11;
    @FXML
    private Label label111;
    @FXML
    private Button btn_annuler_afficher;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        nom.setCellValueFactory(new PropertyValueFactory<Employe,String>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<Employe,String>("prenom"));
        tache.setCellValueFactory(new PropertyValueFactory<Employe,String>("tache"));
        mobile.setCellValueFactory(new PropertyValueFactory<Employe,String>("mobile"));
        salle.setCellValueFactory(new PropertyValueFactory<Employe,Integer>("salle"));
        
        table.setItems(list);
        
        
        btn_annuler_afficher.setOnAction(event -> {

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
        
        btn_payer.setOnAction(event -> {

            try {
                Parent page2 = FXMLLoader.load(getClass().getResource("/com/esprit/view/FXMLPayerEmp.fxml"));
                Scene scene = new Scene(page2);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLMenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
        ServiceEmp pdao=ServiceEmp.getInstance();
        List<Employe> pers=pdao.displayAllList();
        for(Employe p:pers) {
            list1.addAll(
                new PieChart.Data(p.getTache(), 12.0)             
        );
        }
        chrt_emp.setAnimated(true);
        chrt_emp.setData(list1);
        
        
    }    

   

    @FXML
    private void changeScene(MouseEvent event) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/view/FXMLPayerEmp.fxml"));
            Stage window = (Stage) btn_payer.getScene().getWindow();
            window.setScene(new Scene(root));
        }catch (IOException ex){
            System.out.println(ex);
        }
        
    }

    @FXML
    private void changeScene(ActionEvent event) {
    }
    
}
