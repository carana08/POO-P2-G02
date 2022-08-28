/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.parcial2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import modelo.Atencion;
import modelo.Cita;
import modelo.Cliente;
import modelo.Constantes;

/**
 * FXML Controller class
 *
 * @author Karen
 */
public class TreceController implements Initializable {
    @FXML
    private Label cita;
    @FXML
    private ComboBox cmbC;
    @FXML
    private Label agAten;
    @FXML
    private Button agregar;
    @FXML
    private Button cancelar;
    @FXML
    private ObservableList<Atencion> atenciones;
    private Atencion atencionn;
   
    Atencion getAtencion(){
    return atencionn;}
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cmbC.getItems().setAll(Cita.cargarCita());
        
    }
    @FXML
    private void guardado(ActionEvent event) throws IOException {
       ArrayList<Atencion> atencion = Atencion.cargarAtencion();//cargar la lista del archivo
     
        System.out.println("Guardando atencion");
        Atencion a = new Atencion((Cita)cmbC.getValue()); //Debe ponerse la cita elegida en el comboBox
        atencion.add(a);//agregar empleado a la lista
        //serializar la lista
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(Constantes.rutaAtenciones))){
          
            out.writeObject(atencion);
            out.flush();

            //mostrar informacion
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Resultado de la operación");
            alert.setContentText("Nueva atencion agregada exitosamente");

            alert.showAndWait();
            //carga la ventana principal
            
            App.setRoot("octavo");

        } catch (IOException ex) {
            System.out.println("IOException:" + ex.getMessage());
        }}

    @FXML
    private void cancelacion(ActionEvent event) throws IOException {
        App.setRoot("octavo");
    }
    public void closeWindows(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mycompany/parcial2/octavo.fxml"));
            Parent root = loader.load();
            OctavoController controlador  = loader.getController();
           Scene scene = new Scene(root);
           Stage stage = new Stage();
            
           stage.setScene(scene);
           stage.show();

           Stage myStage = (Stage) this.cancelar.getScene().getWindow();
           myStage.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    
    }
    public void llenarCampos(Atencion a){
        agAten.setText("Editar Atencion");
        }
    public void initAttributes(ObservableList<Atencion> atenciones) {
        this.atenciones=atenciones;}
    public void initAttributes(ObservableList<Atencion> atenciones,Atencion a) {
        this.atenciones=atenciones;
        this.atencionn=a;
        
    }
    
    /*public void llenarCampos(ObservableList<Atencion> atenciones,Atencion a) {

    }*/
}
