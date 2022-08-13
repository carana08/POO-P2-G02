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
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author César
 */
public class CuartoController  {


    @FXML
    private Label servicio;
    @FXML
    private TableView<?> tvServicios;
    @FXML
    private TableColumn<?, ?> nombre;
    @FXML
    private TableColumn<?, ?> duracion;
    @FXML
    private TableColumn<?, ?> precio;
    @FXML
    private Button agregarS;
    @FXML
    private Button editarS;
    @FXML
    private Button eliminarS;
    /**
     * Initializes the controller class.
     */
    public void initialize() {
       /* cmbEstado.getItems().setAll(EstadoCivil.values());
        nombre.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        duracion.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        precio.setCellValueFactory(new PropertyValueFactory<>("estado"));
        tvServicios.getItems().setAll(Persona.cargarPersonas(App.pathPersonas));*/
        /*for(Servicio s : Servicio.getServicios()){
        tvServicios.getItems().setAll(s);}*/
        // TODO
    }  
    /*
    @FXML
    private void filtrarPersonas() {
/*
        ArrayList<Persona> personasPorEstado = new ArrayList<>();
        for (Persona p : Persona.cargarPersonas(App.pathPersonas)) {
            if (p.getEstado().equals(cmbEstado.getValue())) {
                personasPorEstado.add(p);
            }
        }
*/
        //filtrado usando stream y lambda
        /*
        List<Persona> personasPorEstado = Persona.cargarPersonas(App.pathPersonas)
                .stream()
                .filter(p -> p.getEstado().equals(cmbEstado.getValue()))
                .collect(Collectors.toList());
        
        //mas sobre streams
        //https://windoctor7.github.io/API-Stream-Java8.html
        //https://www.oscarblancarteblog.com/2017/03/16/java-8-streams-2/
         
        tvServicios.getItems().setAll(personasPorEstado);
    }*/
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
