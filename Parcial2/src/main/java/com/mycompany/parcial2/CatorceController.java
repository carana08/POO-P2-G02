/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.parcial2;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.Atencion;
import modelo.Cita;
import modelo.Empleado;

/**
 * FXML Controller class
 *
 * @author Karen
 */
public class CatorceController implements Initializable {

    @FXML
    private Label cita;
    @FXML
    private ComboBox cmbC;
    @FXML
    private Label agAten;
    @FXML
    private Button editar;
    @FXML
    private Button cancelar;
    @FXML
    ObservableList<Atencion> atenciones;
    private Atencion atencion;
    public Atencion getAtencion(){
    return atencion;}
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Llenando el combo box 
        ArrayList<Cita> citas;
        cmbC.getItems().setAll(Cita.cargarCita());
        cmbC.setValue(cmbC.getValue());
        agAten.setText("Agregar Atencion");
        cita.setText("Cita:");
        //cliente.setText(new PropertyValueFactory<>("fecha"));
        
        // TODO
    }    
    
}
