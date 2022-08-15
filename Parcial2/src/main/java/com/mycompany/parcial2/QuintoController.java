/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.parcial2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelo.Empleado;
import modelo.Persona;
/**
 * FXML Controller class
 *
 * @author César
 */
public class QuintoController implements Initializable {


    @FXML
    private TableView tvEmpleado;
    @FXML
    private TableColumn<Persona, String> nombre;
    @FXML
    private TableColumn<Persona, String> apellido;
    @FXML
    private TableColumn<Persona, String> cedula;
    @FXML
    private TableColumn<Persona, String> telefono;
    @FXML
    private TableColumn<Persona, String> email;
    @FXML
    private TableColumn<Empleado, String> estado;
    @FXML
    private Button agregarE;
    @FXML
    private Button editarE;
    @FXML
    private Button eliminarE;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        apellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        cedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        telefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        estado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        tvEmpleado.getItems().setAll(Empleado.cargarEmpleado());
        // TODO
    }
    /*
public void closeWindows(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mycompany/parcial2/tercera.fxml"));
            Parent root = loader.load();
            TerceraController controlador  = loader.getController();
           Scene scene = new Scene(root);
           Stage stage = new Stage();
            
           stage.setScene(scene);
           stage.show();

           Stage myStage = (Stage) this.agregarE.getScene().getWindow();
           myStage.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    
    }*/
        // TODO    
    
    @FXML
    private void agregarEmp(ActionEvent event) {
    }

    @FXML
    private void editarEmpl(ActionEvent event) {
    }

    @FXML
    private void eliminarEmpl(ActionEvent event) {
    }

}
