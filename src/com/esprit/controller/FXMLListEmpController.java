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
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private TableColumn<Employe, String> salle;
    
    private ListData listdata = new ListData();
    
    
    ObservableList<PieChart.Data> list1=FXCollections.
            observableArrayList();
    /**
     * Initializes the controller class.
     */
    
    
    
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
        
        table.setItems(listdata.getEmploye());
        
        nom.setCellValueFactory(cell -> {
            ObservableValue<String> obsInt = new SimpleStringProperty(cell.getValue().getNom());
            return obsInt;
                });
        prenom.setCellValueFactory(cell -> {
            ObservableValue<String> obsInt = new SimpleStringProperty(cell.getValue().getPrenom());
            return obsInt;
                });
        tache.setCellValueFactory(cell -> {
            ObservableValue<String> obsInt = new SimpleStringProperty(cell.getValue().getTache());
            return obsInt;
                });
        
        mobile.setCellValueFactory(cell -> {
            String s= String.valueOf(cell.getValue().getMobile());
            ObservableValue<String> obsInt = new SimpleStringProperty(s);
            return obsInt;
                });
        salle.setCellValueFactory(cell -> {
            String s= String.valueOf(cell.getValue().getNum_salle());
            ObservableValue<String> obsInt = new SimpleStringProperty(s);
            return obsInt;
                });
        
        
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

   

    
    
}
