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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Cliente;
import modelo.Constantes;
/**
 * FXML Controller class
 *
 * @author César
 */
public class OnceController implements Initializable {


    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtCedula;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtRepresentante;
    @FXML
    private TextField txtEmail;
    @FXML
    private Button guardar;
    @FXML
    private Button cancelar;
   // Cliente getCliente;
    @FXML
    ObservableList<Cliente> clientes;
    private Cliente cliente;
    public Cliente getCliente(){
    return cliente;}

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
        @FXML
    private void cancelando(ActionEvent event) throws IOException {
        this.cliente=null;
        Stage stage = (Stage)this.cancelar.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void guardado(ActionEvent event) {
        ArrayList<Cliente> clientes = Cliente.cargarCliente();
        
        if(cliente== null){
            //System.out.println("Hola");
            Cliente c = new Cliente(txtNombre.getText(),txtApellido.getText(),txtCedula.getText(),txtTelefono.getText(),txtEmail.getText(),txtRepresentante.getText());
            clientes.add(c);
        
        }else{
            cliente.setNombre(txtNombre.getText());
            cliente.setApellido(txtApellido.getText());
            cliente.setCedula(txtCedula.getText());
            cliente.setTelefono(txtTelefono.getText());
            cliente.setEmail(txtEmail.getText());
            cliente.setDatosRepresentante(txtRepresentante.getText());
            
            if (clientes.contains(cliente)){
                int ind = clientes.indexOf(cliente);
                
                clientes.set(ind, cliente);
            }
        
        }try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(Constantes.rutaClientes))){
            out.writeObject(clientes);
            out.flush();

            //mostrar informacion
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Resultado de la operación");
            alert.setContentText("Persona editada exitosamente");
            alert.showAndWait();
            Stage stage = (Stage)this.guardar.getScene().getWindow();
            stage.close();
            //App.setRoot("septimo");

        } catch (IOException ex) {
            System.out.println("IOException:" + ex.getMessage());
        } 
        
    }



    public void llenarCampos(ObservableList<Cliente> clientes,Cliente c) {
        //this.clientes=clientes;
       // this.cliente=c;
        this.txtCedula.setEditable(false);
        this.txtCedula.setText(c.getCedula());
        this.txtNombre.setText(c.getNombre());
        this.txtApellido.setText(c.getApellido());
        this.txtTelefono.setText(c.getTelefono());
        this.txtEmail.setText(c.getEmail());
        this.txtRepresentante.setText(c.getDatosRepresentante());
        cliente=c;
    }



}
