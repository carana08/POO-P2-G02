/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.parcial2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import modelo.Cita;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Persona;
import modelo.Servicio;
/**
 * FXML Controller class
 *
 * @author César
 */
public class SextoController implements Initializable {


    @FXML
    private TableView tcCitas;
    @FXML
    private TableColumn<Cliente, String> nombre;
    @FXML
    private TableColumn<Servicio, String> servicio;
    @FXML
    private TableColumn<Cita, String> fecha;
    @FXML
    private TableColumn<Cita, String> hora;
    @FXML
    private TableColumn<Cita, String> opciones;
    @FXML
    private Button crCita;
    @FXML
    private Button rCita;
    @FXML
    private Button cCita;
    @FXML
    private TableColumn<Empleado, String> terapista;
    /**
     * Initializes the controller class.
     */
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        nombre.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        terapista.setCellValueFactory(new PropertyValueFactory<>("empleado"));
        servicio.setCellValueFactory(new PropertyValueFactory<>("servicio"));
        fecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        hora.setCellValueFactory(new PropertyValueFactory<>("horaInicio"));
        tcCitas.getItems().setAll(Cita.cargarCita());
        // TODO
    }    
    public void closeWindows(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mycompany/parcial2/tercera.fxml"));
            Parent root = loader.load();
            TerceraController controlador  = loader.getController();
           Scene scene = new Scene(root);
           Stage stage = new Stage();
            
           stage.setScene(scene);
           stage.show();

           Stage myStage = (Stage) this.crCita.getScene().getWindow();
           myStage.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    
    }   
    
}

