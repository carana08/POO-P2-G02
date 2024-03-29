/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.parcial2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelo.Servicio;
/**
 * FXML Controller class
 *
 * @author César
 */
public class CuartoController  {


    @FXML
    private Label servicio;
    @FXML
    private TableView tvServicios;
    @FXML
    private TableColumn<Servicio,String> nombre;
    @FXML
    private TableColumn<Servicio,String> duracion;
    @FXML
    private TableColumn<Servicio,String> precio;
    @FXML
    private Button agregarS;
    @FXML
    private Button editarS;
    @FXML
    private Button eliminarS;
    @FXML
    private TableColumn<Servicio,String> estado;
    /**
     * Initializes the controller class.
     */
    public void initialize() {
       nombre.setCellValueFactory(new PropertyValueFactory<>("nombreServicio"));
        duracion.setCellValueFactory(new PropertyValueFactory<>("duracionServicio"));
        precio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        estado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        tvServicios.getItems().setAll(Servicio.cargarServicio());
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

           Stage myStage = (Stage) this.agregarS.getScene().getWindow();
           myStage.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    
    }
    
}
