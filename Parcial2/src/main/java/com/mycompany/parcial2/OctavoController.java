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
import modelo.Atencion;
import modelo.Empleado;

/**
 * FXML Controller class
 *
 * @author Karen
 */
public class OctavoController implements Initializable {
    
    @FXML
    private TableView tvAtenciones;
    @FXML
    private TableColumn<Atencion, String> cita;
    @FXML
    private Button agregarA;
    @FXML
    private Button editarA;
    @FXML
    private Button eliminarA;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cita.setCellValueFactory(new PropertyValueFactory<>("cita"));
        tvAtenciones.getItems().setAll(Atencion.cargarAtencion());
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

           Stage myStage = (Stage) this.agregarA.getScene().getWindow();
           myStage.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    
    }
        // TODO    
    
    @FXML
    private void agregarA(ActionEvent event) {
    }

    @FXML
    private void editarA(ActionEvent event) {
    }

    @FXML
    private void eliminarA(ActionEvent event) {
    }
}
