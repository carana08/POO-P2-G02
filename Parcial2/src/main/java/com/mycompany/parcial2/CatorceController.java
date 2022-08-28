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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Atencion;
import modelo.Cita;
import modelo.Cliente;
import modelo.Constantes;
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
        cmbC.getItems().setAll(Atencion.cargarAtencion());
        // TODO
    }    
    @FXML
    private void cancelando(ActionEvent event) throws IOException {
        this.atencion=null;
        Stage stage = (Stage)this.cancelar.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void guardado(ActionEvent event) {
        ArrayList<Atencion> atenciones = Atencion.cargarAtencion();
        
        if(atencion== null){
            //System.out.println("Hola");
            Atencion a = new Atencion((Cita)cmbC.getValue());
            atenciones.add(a);
        
        }else{
           //debería setear la cita
            
            if (atenciones.contains(atencion)){
                int ind = atenciones.indexOf(atencion);
                
                atenciones.set(ind, atencion);
            }
        
        }try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(Constantes.rutaAtenciones))){
            out.writeObject(atenciones);
            out.flush();

            //mostrar informacion
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Resultado de la operación");
            alert.setContentText("Atencion editada exitosamente");
            alert.showAndWait();
            Stage stage = (Stage)this.editar.getScene().getWindow();
            stage.close();
            //App.setRoot("septimo");

        } catch (IOException ex) {
            System.out.println("IOException:" + ex.getMessage());
        } 
        
    }
    public void llenarCampos(ObservableList<Atencion> atenciones,Atencion a) {
        //LLENAR
    }
}
