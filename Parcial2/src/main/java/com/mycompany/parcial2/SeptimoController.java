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
import modelo.Cliente;
import modelo.Persona;

/**
 * FXML Controller class
 *
 * @author Karen
 */
public class SeptimoController implements Initializable {
    
    @FXML
    private TableView tvClientes;
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
    private TableColumn<Cliente, String> representante;
    @FXML
    private Button agregarCl;
    @FXML
    private Button editarCl;
    @FXML
    private Button eliminarCl;
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
        representante.setCellValueFactory(new PropertyValueFactory<>("datosRepresentante"));
        tvClientes.getItems().setAll(Cliente.cargarCliente());
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

           Stage myStage = (Stage) this.agregarCl.getScene().getWindow();
           myStage.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    
    }
        // TODO    
    
    @FXML
    private void agregarCliente(ActionEvent event) {
    }

    @FXML
    private void editarCliente(ActionEvent event) {
    }

    @FXML
    private void eliminarCliente(ActionEvent event) {
    }
}
