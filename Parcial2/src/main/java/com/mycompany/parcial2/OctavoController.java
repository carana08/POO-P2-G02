/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.parcial2;

import java.io.File;
import java.io.IOException;
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Atencion;
import modelo.Cliente;
import modelo.Constantes;
import modelo.Empleado;

/**
 * FXML Controller class
 *
 * @author Karen
 */
public class OctavoController implements Initializable {
    
    @FXML
    private TableView tvAtenciones;
    @FXML
    private TableColumn<Atencion, String> cita;
    @FXML
    private Button agregarA;
    @FXML
    private Button editarA;
    @FXML
    private Button eliminarA;
    @FXML
    private ObservableList<Atencion> atenciones =FXCollections.observableArrayList();
    
    private ArrayList<Atencion> aten;
    private Atencion atencion;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cita.setCellValueFactory(new PropertyValueFactory<>("cita"));
        tvAtenciones.getItems().setAll(Atencion.cargarAtencion());
        // TODO
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

           Stage myStage = (Stage) this.agregarA.getScene().getWindow();
           myStage.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    
    }
        // TODO    
    
    @FXML
    private void agregarA(ActionEvent event) throws IOException {
        App.setRoot("trece");
    }

    @FXML
    private void editarA(ActionEvent event) throws IOException {
        Atencion a =(Atencion)tvAtenciones.getSelectionModel().getSelectedItem();
        if(a==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Debes seleccionar una cita");
            alert.showAndWait();
            
        }
        else{
        FXMLLoader loader = new FXMLLoader(App.class.getResource("/com/mycompany/parcial2/catorce.fxml"));
        Parent root = loader.load();
        CatorceController cc = loader.getController();
        //cc.llenarCampos(atenciones,a);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
        Atencion aux = cc.getAtencion();
        if(aux!=null){
            this.tvAtenciones.refresh();
        
        }
        }
    }

    @FXML
    private void eliminarA(ActionEvent event) {
        Atencion c = (Atencion)tvAtenciones.getSelectionModel().getSelectedItem();
         ArrayList<Atencion> atencionesA = new ArrayList<>();
         ArrayList<Atencion> listaComparar = Atencion.cargarAtencion();
         File file = new File(Constantes.rutaAtenciones);
         System.out.println(listaComparar);
         //File ficheroEntrada = null;
         //File ficheroSalida = null;
        if(c==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Debes seleccionar una cita");
            alert.showAndWait();
        }
        else{
            eliminado(listaComparar, c);
    }
    }
    public void eliminado(ArrayList<Atencion> lAtencion,Atencion aten){
        ArrayList<Atencion> atencion = Atencion.cargarAtencion();
        File file = new File(Constantes.rutaAtenciones);
        File file2 = new File(Constantes.rutaAtenciones);
        file.delete();
        
            for(Atencion ate:atencion){
                int i=0;
                if(ate.equals(aten)){
                    //System.out.println(cli);
                    lAtencion.remove(ate);
                    i+=1;
                    System.out.println(ate);
                }
                else{
                    i+=1;
                    Atencion.registrarAtencion(ate);
                    
                    /*try(ObjectOutputStream escritura = new ObjectOutputStream(new FileOutputStream(Constantes.rutaClientes))){
                       
                        escritura.writeObject(cliente);
                        escritura.flush();
                    }catch(IOException ex){
                        System.out.println("ERROR");
                    
                    }*/
        
                    cita.setCellValueFactory(new PropertyValueFactory<>("cita"));
        tvAtenciones.getItems().setAll(Atencion.cargarAtencion());
                   // Atencion.remove(tvClientes.getSelectionModel().getSelectedItem());
           //this.tvClientes.refresh();
           //tvClientes.refresh();
          
                }
            }
        
    }
        
        
}
