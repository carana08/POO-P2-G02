/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.parcial2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Cita;
import static modelo.Cita.cargarCita;
import modelo.Cliente;
import modelo.Constantes;
import modelo.Empleado;
import modelo.Servicio;
/**
 * FXML Controller class
 *
 * @author César
 */
public class SextoController implements Initializable {


    @FXML
    private TableView tcCitas;
    @FXML
    private TableColumn<Cliente, String> nombre;
    @FXML
    private TableColumn<Empleado, String> terapista;
    @FXML
    private TableColumn<Servicio, String> servicio;
    @FXML
    private TableColumn<Cita, String> fecha;
    @FXML
    private TableColumn<Cita, String> hora;
    @FXML
    private TableColumn<Cita, String> opciones;
    @FXML
    private Button crCita;
    @FXML
    private Button rCita;
    @FXML
    private Button cCita;
    private ObservableList<Cita> citas =FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nombre.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        terapista.setCellValueFactory(new PropertyValueFactory<>("empleado"));
        servicio.setCellValueFactory(new PropertyValueFactory<>("servicio"));
        fecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        hora.setCellValueFactory(new PropertyValueFactory<>("horaInicio"));
        tcCitas.getItems().setAll(Cita.cargarCita());
        // TODO
    }    
    
    @FXML
    private void crearCita(ActionEvent event) throws IOException {
        App.setRoot("doce");
        /*try {
            FXMLLoader loader3 = new FXMLLoader(getClass().getResource("/com/mycompany/parcial2/noveno.fxml"));
            Parent root3 = loader3.load();
            NovenoController controlador3  = loader3.getController();
            Scene scene3 = new Scene(root3);
            Stage stage3 = new Stage();

            stage3.setScene(scene3);
            stage3.show();
           
            stage3.setOnCloseRequest(e->controlador3.closeWindows());
            Stage myStage3 = (Stage) this.cCita.getScene().getWindow();
            myStage3.close();
           
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/
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

           Stage myStage = (Stage) this.cCita.getScene().getWindow();
           myStage.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    
    }

    @FXML
    private void registrarCita(ActionEvent event) throws IOException {
       
        Cita c = (Cita)tcCitas.getSelectionModel().getSelectedItem();
                if(c==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Debes seleccionar una cita");
            alert.showAndWait();
            
        }
        else{
        
        FXMLLoader loader = new FXMLLoader(App.class.getResource("/com/mycompany/parcial2/noveno.fxml"));
        Parent root = loader.load();
        NovenoController ct = loader.getController();
        ct.llenarCampos(citas,c);
        //App.setRoot("noveno");
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        //stage.setScene(scene);         
        //stage.show();
        //stage.setOnCloseRequest(e->ct.closeWindows());
        //Stage myStage = (Stage) this.editarCL.getScene().getWindow();
        //myStage.close();
        
        //stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
        Cita aux = ct.getCita();
        if(aux!=null){
            this.tcCitas.refresh();
        }
        }
              
        
            
          /*  try {
            FXMLLoader loader3 = new FXMLLoader(getClass().getResource("/com/mycompany/parcial2/noveno.fxml"));
            Parent root3 = loader3.load();
            NovenoController controlador3  = loader3.getController();
            Scene scene3 = new Scene(root3);
            Stage stage3 = new Stage();

            stage3.setScene(scene3);
            stage3.show();
           
            stage3.setOnCloseRequest(e->controlador3.closeWindows());
            Stage myStage3 = (Stage) this.cCita.getScene().getWindow();
            myStage3.close();
           
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/
            
    }

    @FXML
    private void consultarC(ActionEvent event) throws IOException {
         Cita c = (Cita)tcCitas.getSelectionModel().getSelectedItem();
                if(c==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Debes seleccionar una Cita");
            alert.showAndWait();
            
        }
        else{
        
        FXMLLoader loader = new FXMLLoader(App.class.getResource("/com/mycompany/parcial2/Quince.fxml"));
        Parent root = loader.load();
        QuinceController ct = loader.getController();
        ct.llenarCampos(c);
        //App.setRoot("noveno");
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.showAndWait();
        Cita aux = ct.getCita();
        if(aux!=null){
            this.tcCitas.refresh();
        }
        }
        
    }


}
