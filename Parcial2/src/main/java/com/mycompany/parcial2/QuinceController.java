/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.parcial2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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

     //ObservableList<NovenoController> datos;
    @FXML
    private Label cliente;
    @FXML
    private TableView tvActividades;
    @FXML
    private TableColumn colActividad;
    @FXML
    private TableColumn<Cita,String> colFecha;
    @FXML
    private TableColumn<NovenoController, String> colAciertos;
    @FXML
    private TableColumn<NovenoController, String> colFallos;
    @FXML
    private TableColumn<NovenoController, String> colTiempo;
        private Cita cita;
    public Cita getCita(){
    return cita;}
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(NovenoController.cargarInformacion());
        //datos = FXCollections.observableArrayList();
        //this.colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        //this.tvActividades.getItems().setAll(Cita.cargarCita());
       
        
        // TODO
    }
    //datos.add(new Quince("texto de interes"));
    public void llenarCampos(Cita c) {
    //this.colActividad.setCellValueFactory(new PropertyValueFactory<>("bingo"));
    //this.colFecha.setCellFactory(new PropertyValueFactory<>(c.getFecha()));
    this.cliente.setText(c.getCliente().getNombre()+" "+c.getCliente().getApellido());
        //this.cmbT.set;
     cita=c;
     
     //BingoController bc = new BingoController();
     this.colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
     /*this.colAciertos.setCellValueFactory(new PropertyValueFactory<>(bc.getAciertosS()));
     this.colFallos.setCellValueFactory(new PropertyValueFactory<>(bc.getFallosS()));
     this.colTiempo.setCellValueFactory(new PropertyValueFactory<>("bc.getMinutosP()"));*/
     //this.tvActividades.getItems().setAll(NovenoController.cargarInformacion());
     this.tvActividades.getItems().setAll(Cita.cargarCita());
        
    }

}
