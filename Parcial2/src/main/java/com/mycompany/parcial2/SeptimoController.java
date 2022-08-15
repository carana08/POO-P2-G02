/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.parcial2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Cliente;
import modelo.Constantes;
import modelo.Empleado;
import modelo.Persona;

/**
 * FXML Controller class
 *
 * @author Karen
 */
public class SeptimoController implements Initializable {
    
    @FXML
    private TableView<Cliente> tvClientes;
    @FXML
    private TableColumn<Persona, String> nombre;
    @FXML
    private TableColumn<Persona, String> apellido;
    @FXML
    private TableColumn<Persona, String> cedula;
    @FXML
    private TableColumn<Persona, String> telefono;
    @FXML
    private TableColumn<Persona, String> email;
    @FXML
    private TableColumn<Cliente, String> representante;
    @FXML
    private Button agregarCl;
    @FXML
    private Button eliminarCl;
    @FXML
    private Button editarCL;
    @FXML
    private ObservableList<Cliente> clientes =FXCollections.observableArrayList();;
    
    private ArrayList<Cliente> client;
    private Cliente cliente;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        apellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        cedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        telefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        representante.setCellValueFactory(new PropertyValueFactory<>("datosRepresentante"));
        tvClientes.getItems().setAll(Cliente.cargarCliente());
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

           Stage myStage = (Stage) this.agregarCl.getScene().getWindow();
           myStage.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    
    }
        // TODO    
    
    @FXML
    private void agregar(ActionEvent event) throws IOException {
        App.setRoot("decimo");
        /*try {
            FXMLLoader loader3 = new FXMLLoader(getClass().getResource("/com/mycompany/parcial2/decimo.fxml"));
            Parent root3 = loader3.load();
            DecimoController controlador3  = loader3.getController();
            Scene scene3 = new Scene(root3);
            Stage stage3 = new Stage();

            stage3.setScene(scene3);
            stage3.show();
           
            stage3.setOnCloseRequest(e->controlador3.closeWindows());
            Stage myStage3 = (Stage) this.eliminarCl.getScene().getWindow();
            myStage3.close();
           
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/
    }

    @FXML
    private void editar(ActionEvent event) throws IOException {
        Cliente c =(Cliente)tvClientes.getSelectionModel().getSelectedItem();
        if(c==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Debes seleccionar una persona");
            alert.showAndWait();
            
        }
        else{
        FXMLLoader loader = new FXMLLoader(App.class.getResource("/com/mycompany/parcial2/once.fxml"));
        Parent root = loader.load();
        OnceController ct = loader.getController();
        ct.llenarCampos(clientes,c);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        //stage.setScene(scene);         
        //stage.show();
        //stage.setOnCloseRequest(e->ct.closeWindows());
        //Stage myStage = (Stage) this.editarCL.getScene().getWindow();
        //myStage.close();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
        Cliente aux = ct.getCliente();
        if(aux!=null){
            this.tvClientes.refresh();
        
        }
        }
        
        //loader.setController(ct);//se asigna el controlador
        
        
        /*
        //App.setRoot("decimo");
        Cliente  c = this.tvClientes.getSelectionModel().getSelectedItem();
        if(c==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Debes seleccionar una persona");
            alert.showAndWait();
            
        }
        else{
     
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mycompany/parcial2/once.fxml"));
        Parent root = loader.load();
        OnceController controlador = loader.getController();
        controlador.initAttributes(clientes,c);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
        Cliente aux = controlador.getCliente();
        if (aux!=null){
            this.tvClientes.refresh();
        }
        
        }catch(IOException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }}*/
                                
        }
       
    

    @FXML
    private void eliminar(ActionEvent event) throws FileNotFoundException, IOException {
        Cliente c = (Cliente)tvClientes.getSelectionModel().getSelectedItem();
         ArrayList<Cliente> clientesA = Cliente.cargarCliente();
        if(c==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Debes seleccionar una persona");
            alert.showAndWait();
        }
        else{
            clientes.remove(c);
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(Constantes.rutaClientes))){
            out.writeObject(clientesA);
            out.flush();}
            this.tvClientes.refresh();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText("Se ha borrado la persona");
            alert.showAndWait();
        }
    }

    @FXML
    private void mostrarDetalle(MouseEvent event) {
        //Cliente c = this.tvClientes.getSelectionModel().getSelectedItem();
        /*if(c!=null){
        this.nombre.setText(c.getNombre());
        this.apellido.setText(c.getApellido());
        this.cedula.setText(c.getCedula());
        this.telefono.setText(c.getTelefono());
        this.email.setText(c.getEmail());
        this.representante.setText(c.getDatosRepresentante());
        }
        //se puede recuperar el indice del elemento recuperado con getSelectedIndex
        System.out.println(tvClientes.getSelectionModel().getSelectedIndex());
        System.out.println(c);*/
    }
}
