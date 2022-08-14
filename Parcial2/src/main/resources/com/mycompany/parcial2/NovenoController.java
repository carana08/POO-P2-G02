/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.parcial2;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import modelo.Cita;
import modelo.Empleado;

/**
 * FXML Controller class
 *
 * @author César
 */
public class NovenoController implements Initializable {

    @FXML
    private Button guardar;
    @FXML
    private Button realizarA;
    @FXML
    private GridPane gPaneAtencion;
    @FXML
    private TextField txtD;
    @FXML
    private ComboBox cmbT;
    @FXML
    private Label cliente;
    @FXML
    private Label fecha;
    @FXML
    private Label hora;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Llenando el combo box 
        ArrayList<Empleado> empleado;
        cmbT.getItems().setAll(Empleado.cargarEmpleado());
        cmbT.setValue(cmbT.getValue());
        fecha.setText("Hola");
        //cliente.setText(new PropertyValueFactory<>("fecha"));
        
        // TODO
    }    
    
    @FXML
    private void guardado(ActionEvent event) throws IOException {
        App.setRoot("sexto");
        //String duracion= txtD.getText();
        //Empleado empleado = (Empleado) cmbT.getValue();
        //System.out.println(empleado);
        
        Cita cita = new Cita();
        Cita.registrarCita(cita);
        
        
        System.out.println("Guardando");
    }
/*
    @FXML
    private void listado(ActionEvent event) {
    }
    */
     public void closeWindows(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mycompany/parcial2/sexto.fxml"));
            Parent root = loader.load();
            SextoController controlador  = loader.getController();
           Scene scene = new Scene(root);
           Stage stage = new Stage();
            
           stage.setScene(scene);
           stage.show();

           Stage myStage = (Stage) this.realizarA.getScene().getWindow();
           myStage.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    
    } 

    @FXML
    private void listado(ActionEvent event) {
    }


}
