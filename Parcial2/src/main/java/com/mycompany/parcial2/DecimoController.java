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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Cliente;
import modelo.Constantes;
import modelo.Empleado;
/**
 * FXML Controller class
 *
 * @author César
 */
public class DecimoController implements Initializable {


    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtCedula;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtRepresentante;
    @FXML
    private Button guardar;
    @FXML
    private Button cancelar;
    @FXML
    private Label lblTitulo;
    @FXML
    private ObservableList<Cliente> clientes;
    private Cliente cliente9;
   
    Cliente getCliente(){
    return cliente9;}
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void guardado(ActionEvent event) {
        ArrayList<Cliente> cliente = Cliente.cargarCliente();//cargar la lista del archivo
     
        System.out.println("Guardando cliente");
        Cliente c = new Cliente(txtNombre.getText(), txtApellido.getText(), txtCedula.getText(),txtTelefono.getText(),txtEmail.getText(),txtRepresentante.getText());
        cliente.add(c);//agregar empleado a la lista
        //serializar la lista
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(Constantes.rutaClientes))){
          
            out.writeObject(cliente);
            out.flush();

            //mostrar informacion
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Resultado de la operación");
            alert.setContentText("Nuevo cliente agregado exitosamente");

            alert.showAndWait();
            //carga la ventana principal
            
            App.setRoot("septimo");

        } catch (IOException ex) {
            System.out.println("IOException:" + ex.getMessage());
        }}//}}

    

    @FXML
    private void cancelacion(ActionEvent event) throws IOException {
        App.setRoot("septimo");
    }
    public void closeWindows(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mycompany/parcial2/septimo.fxml"));
            Parent root = loader.load();
            SeptimoController controlador  = loader.getController();
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
    public void llenarCampos(Cliente c){
        lblTitulo.setText("Editar Cliente");
        txtCedula.setEditable(false);
        txtCedula.setText(c.getCedula());
        txtNombre.setText(c.getNombre());
        txtApellido.setText(c.getApellido());
        txtTelefono.setText(c.getTelefono());
        txtEmail.setText(c.getEmail());
        txtRepresentante.setText(c.getDatosRepresentante());
        
        //cliente = c;//asigno la variable con el objeto recibido
       /* if (e.getGenero().equals(Genero.FEMENINO))
            rbF.setSelected(true);
        else
            rbM.setSelected(true);
        */
        
    }

    public void initAttributes(ObservableList<Cliente> clientes) {
        this.clientes=clientes;}
    public void initAttributes(ObservableList<Cliente> clientes,Cliente c) {
        this.clientes=clientes;
        this.cliente9=c;
        this.txtCedula.setEditable(false);
        this.txtCedula.setText(c.getCedula());
        this.txtNombre.setText(c.getNombre());
        this.txtApellido.setText(c.getApellido());
        this.txtTelefono.setText(c.getTelefono());
        this.txtEmail.setText(c.getEmail());
        this.txtRepresentante.setText(c.getDatosRepresentante());
    }

}
