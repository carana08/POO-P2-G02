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
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author César
 */
public class TerceraController  {


    @FXML
    private Button servicios;
    @FXML
    private Button citas;
    @FXML
    private Button atenciones;
    @FXML
    private Button empleados;
    @FXML
    private Button clientes;
    @FXML
    private Button salir;
    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void servicio(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mycompany/parcial2/cuarto.fxml"));
            
            Parent root = loader.load();
            
           CuartoController controlador  = loader.getController();
           
           Scene scene = new Scene(root);
           Stage stage = new Stage();
           
           
            
           stage.setScene(scene);
         
           stage.show();
           
           stage.setOnCloseRequest(e->controlador.closeWindows());
           
           Stage myStage = (Stage) this.servicios.getScene().getWindow();
           
           myStage.close();
           
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    }

    @FXML
    private void cita(ActionEvent event) {
    }

    @FXML
    private void atencion(ActionEvent event) {
    }

    @FXML
    private void empleaado(ActionEvent event) {
    }

    @FXML
    private void cliente(ActionEvent event) {
    }

    @FXML
    private void salida(ActionEvent event) {
    }

}
