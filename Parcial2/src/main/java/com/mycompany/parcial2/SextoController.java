/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.parcial2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
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
import modelo.Cita;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Servicio;
/**
 * FXML Controller class
 *
 * @author Karen
 */
public class SextoController implements Initializable {
        
    @FXML
    private TableView tvCitas;
    @FXML
    private TableColumn<Cliente, String> nombreCliente;
    @FXML
    private TableColumn<Empleado, String> nombreEmpleado;
    @FXML
    private TableColumn<Servicio, String> nombreServicio;
    @FXML
    private TableColumn<Cita, String> fecha;
    @FXML
    private TableColumn<Cita, String> duracion;
    @FXML
    private TableColumn<Cita, String> inicioH;
    @FXML
    private TableColumn<Cita, String> finH;
    @FXML
    private Button agregarC;
    @FXML
    private Button editarC;
    @FXML
    private Button eliminarC;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nombreCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        nombreEmpleado.setCellValueFactory(new PropertyValueFactory<>("empleado"));
        nombreServicio.setCellValueFactory(new PropertyValueFactory<>("servicio"));
        fecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        duracion.setCellValueFactory(new PropertyValueFactory<>("duracionR"));
        inicioH.setCellValueFactory(new PropertyValueFactory<>("horaInicio"));
        finH.setCellValueFactory(new PropertyValueFactory<>("horFin"));
        tvCitas.getItems().setAll(Cita.cargarCita());
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

           Stage myStage = (Stage) this.agregarC.getScene().getWindow();
           myStage.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    
    }
    @FXML
    private void agregarCita(ActionEvent event) {
    }

    @FXML
    private void editarCita(ActionEvent event) {
    }

    @FXML
    private void eliminarCita(ActionEvent event) {
    }
}
