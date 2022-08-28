/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.parcial2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Cita;
/**
 * FXML Controller class
 *
 * @author César
 */
public class QuinceController implements Initializable {


    @FXML
    private Label cliente;
    @FXML
    private TableView tvActividades;
    @FXML
    private TableColumn colActividad;
    @FXML
    private TableColumn<Cita, String> colFecha;
    @FXML
    private TableColumn<BingoController, String> colAciertos;
    @FXML
    private TableColumn<BingoController, String> colFallos;
    @FXML
    private TableColumn<BingoController, String> colTiempo;
        private Cita cita;
    public Cita getCita(){
    return cita;}
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
        // TODO
    }
    public void llenarCampos(Cita c) {
    this.colActividad.setCellValueFactory(new PropertyValueFactory<>("bingo"));
    //this.colFecha.setCellFactory(new PropertyValueFactory<>(c.getFecha()));
    this.cliente.setText(c.getCliente().getNombre()+" "+c.getCliente().getApellido());
        //this.cmbT.set;
     cita=c;
    }

}
