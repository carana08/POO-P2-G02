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
import modelo.Empleado;
import modelo.Servicio;
import modelo.Cliente;
import modelo.Cita;
import modelo.Atencion;
/**
 * FXML Controller class
 *
 * @author César
 */
public class TerceraController implements Initializable{


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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
        try {
            FXMLLoader loader3 = new FXMLLoader(getClass().getResource("/com/mycompany/parcial2/sexto.fxml"));
            Parent root3 = loader3.load();
            SextoController controlador3  = loader3.getController();
            Scene scene3 = new Scene(root3);
            Stage stage3 = new Stage();

            stage3.setScene(scene3);
            stage3.show();
           
            stage3.setOnCloseRequest(e->controlador3.closeWindows());
            Stage myStage3 = (Stage) this.citas.getScene().getWindow();
            myStage3.close();
           
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void atencion(ActionEvent event) {
        try {
            FXMLLoader loader5 = new FXMLLoader(getClass().getResource("/com/mycompany/parcial2/septimo.fxml"));
            
            Parent root5 = loader5.load();
            
           OctavoController controlador5  = loader5.getController();
           
           Scene scene5 = new Scene(root5);
           Stage stage5 = new Stage();
           
           
            
           stage5.setScene(scene5);
         
           stage5.show();
           
           stage5.setOnCloseRequest(e->controlador5.closeWindows());
           
           Stage myStage5 = (Stage) this.atenciones.getScene().getWindow();
           
           myStage5.close();
           
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    }

    @FXML
    private void empleaado(ActionEvent event) {
         try {
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/com/mycompany/parcial2/quinto.fxml"));
        Parent root2 = loader2.load();
        QuintoController controlador2 = loader2.getController();
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
        
    }

    @FXML
    private void cliente(ActionEvent event) {
        try {
            FXMLLoader loader4 = new FXMLLoader(getClass().getResource("/com/mycompany/parcial2/septimo.fxml"));
            
            Parent root4 = loader4.load();
            
           SeptimoController controlador4  = loader4.getController();
           
           Scene scene4 = new Scene(root4);
           Stage stage4 = new Stage();
           
           
            
           stage4.setScene(scene4);
         
           stage4.show();
           
           stage4.setOnCloseRequest(e->controlador4.closeWindows());
           
           Stage myStage4 = (Stage) this.clientes.getScene().getWindow();
           
           myStage4.close();
           
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    }

    @FXML
    private void salida(ActionEvent event) {
        System.exit(0);
    }

}
