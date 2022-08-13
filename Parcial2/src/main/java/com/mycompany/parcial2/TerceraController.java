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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author César
 */
public class TerceraController implements Initializable {


    @FXML
    private Pane contenido;
    @FXML
    private Button servicios;
    @FXML
    private Button empleados;
    @FXML
    private Button citas;
    @FXML
    private Button clientes;
    @FXML
    private Button atenciones;
    @FXML
    private Button salir;
    /**
     * Initializes the controller class.
     */
    @Override
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
        
 /*       
    }
    @FXML
    private void empleado(ActionEvent event){
        try {
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/com/mycompany/p2prueba/prueba.fxml"));
        Parent root2 = loader2.load();
        PruebaController controlador2 = loader2.getController();
        Scene scene2 = new Scene(root2);
        Stage stage2 = new Stage();
        stage2.setScene(scene2);
        stage2.show();
        stage2.setOnCloseRequest(e->controlador2.closeWindows());
        Stage myStage2 = (Stage) this.empleados.getScene().getWindow();
        myStage2.close();
        }catch (IOException ex) {
            ex.printStackTrace();
        } 
     */   
    }
}
