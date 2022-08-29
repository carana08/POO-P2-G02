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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Cita;
import static modelo.Cita.cargarCita;
import modelo.Cliente;
import modelo.Constantes;
import modelo.Empleado;
/**
 * FXML Controller class
 *
 * @author César
 */
public class NovenoController implements Initializable {


    @FXML
    private Label fecha;
    @FXML
    private Label hora;
    @FXML
    private ComboBox cmbT;
    @FXML
    private TextField txtD;
    @FXML
    private Label cliente;
    @FXML
    private Button guardar;
    @FXML
    private Button realizarA;
    @FXML
    ObservableList<Cita> citas;
    private Cita cita;
    public Cita getCita(){
    return cita;}
    public String fechaF;
    public String getFechaF(){
        return fechaF;
                
    }
    
    /**
     * Initializes the controller class.
     */
 @Override
    public void initialize(URL url, ResourceBundle rb) {
        NovenoController.crearArchivoInformacion();
        //Llenando el combo box 
        ArrayList<Empleado> empleado;
        cmbT.getItems().setAll(Empleado.cargarEmpleado());
        cmbT.setValue(cmbT.getValue());
        fecha.setText("Hola");
        //cliente.setText(new PropertyValueFactory<>("fecha"));
        
        // TODO
    }    
    
    @FXML
    private void guardado(ActionEvent event) throws IOException {
       App.setRoot("sexto");
        String duracion= txtD.getText();
        Empleado empleado = (Empleado) cmbT.getValue();
        System.out.println(empleado);
        
        Cita cita = new Cita();
        Cita.registrarCita(cita);
        
        NovenoController.registrarInfo(fecha.getText(), hora.getText(), cliente.getText(), cmbT.getValue().toString(), txtD.getText(), BingoController.cargarActividad());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Resultado de la operación");
            alert.setContentText("Cita registrada exitosamente");

            alert.showAndWait();
        
        
        System.out.println("Guardando");
    }
/*
    @FXML
    private void listado(ActionEvent event) {
    }
    */
 

    @FXML
    private void listado(ActionEvent event) {
    }
   /* public void llenarCampos(Cita c){
        fecha.setText(c.getFecha());
        hora.setText(c.getHoraInicio());
        cliente.setText((c.getCliente()).getNombre());
        txtD.setText(String.valueOf(c.getDuracionR()));
        cmbT.setValue(c.getEmpleado().getNombre());

}*/


    @FXML
    private void realizarAct(ActionEvent event) throws IOException {
        //App.setRoot("bingo");
        try {
            FXMLLoader loader3 = new FXMLLoader(getClass().getResource("/com/mycompany/parcial2/bingo.fxml"));
            Parent root3 = loader3.load();
            BingoController controlador3  = loader3.getController();
            Scene scene3 = new Scene(root3);
            Stage stage3 = new Stage();

            stage3.setScene(scene3);
            stage3.show();
            //stage3.close();
           /*
            stage3.setOnCloseRequest(e->controlador3.closeWindows());
            Stage myStage3 = (Stage) this.realizarA.getScene().getWindow();
            myStage3.close();*/
           
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
        public void llenarCombo(ArrayList<Cita> citas) {
        cmbT.getItems().setAll(citas);
    }
    public void llenarCampos(ObservableList<Cita> citas,Cita c) {
        this.fecha.setText(c.getFecha());
        this.hora.setText(c.getHoraInicio());
        this.cliente.setText(c.getCliente().getNombre()+" "+c.getCliente().getApellido());
        //this.cmbT.set;
        cita=c;
    }
        public static void crearArchivoInformacion(){
        try(ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(Constantes.rutaInfo))){
            ArrayList<String> listaRegistros = new ArrayList<>();
            escritor.writeObject(listaRegistros);
            escritor.flush();
            
            
        }catch(IOException e){
            e.printStackTrace();}
        catch(Exception e){
            System.out.println("-------Excepcion general--------");
        }
    
    }
    public static ArrayList<String> cargarInformacion(){
        ArrayList<String> listaRetorno = new ArrayList<>();
        try(ObjectInputStream lector = new ObjectInputStream(new FileInputStream(Constantes.rutaInfo))) {
            listaRetorno = (ArrayList<String>)lector.readObject();   
        }
        catch(FileNotFoundException e){
            System.out.println("El archivo no fue encontrado");}
        catch (IOException ex) {
            ex.printStackTrace();
        }  catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        } 
        return listaRetorno;
    }
    public static void registrarInfo(String fe,String ho,String cli,String ter,String dur,ArrayList<String> in){
        ArrayList<String>listaActualizada = cargarInformacion();
        listaActualizada.add(fe);
        listaActualizada.add(ho);
        listaActualizada.add(cli);
        listaActualizada.add(ter);
        listaActualizada.add(dur);
        for(String datos: in){
            listaActualizada.add(datos);
        }
        try(ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(Constantes.rutaInfo))) {
            escritor.writeObject(listaActualizada);
        }
        
        catch (IOException ex){
            ex.printStackTrace();
        }
    
    }
       
}
