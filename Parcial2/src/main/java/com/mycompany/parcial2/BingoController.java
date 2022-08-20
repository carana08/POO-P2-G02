/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.parcial2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
/**
 * FXML Controller class
 *
 * @author César
 */
public class BingoController {

    //ArrayList<String> imagenes = new ArrayList<>();
    @FXML
    private GridPane tabla;
    
    ArrayList<Integer> numeros = new ArrayList<>();
    @FXML
    private VBox vCont;
    @FXML
    private HBox hCont;
    TextField turno = new TextField();
    Button agregar = new Button("Establecer Turno");
    int turnos;
    Label tex = new Label();
    @FXML
    private HBox hCont2;

    /**
     * Initializes the controller class.
     */
public void initialize() {
        double valor1 = (int)Math.random()*10+1;
        int e = 0;
        //hcont2.setVisible(false);
        for(int i=0;i<=19;i++){
           
           int valor = (int)(Math.random()*100+2);
           if(!(numeros.contains(valor))){
               numeros.add(valor);
           }
           else{
               numeros.add(valor-1);
           }
        }
        for(Integer v:numeros){
            Button boton = new Button(String.valueOf(v));
            Button boton2 = new Button("   ");
            if(e<=4){
                if(e==2){
                    boton2.setDisable(true);
                    tabla.addRow(0, boton2);
                    tabla.addRow(0,boton);
                    e+=1;
                }else{
                tabla.addRow(0, boton);
                e+=1;}
            }
            else if(5<=e&&e<=9){
                if(e==6){
                    boton2.setDisable(true);
                    tabla.addRow(1, boton2);
                    tabla.addRow(1,boton);
                    e+=1;
                }else{
                tabla.addRow(1, boton);
                e+=1;}
            }
            else if(10<=e&&e<=14){
                if(e==10){
                    boton2.setDisable(true);
                    tabla.addRow(2, boton2);
                    tabla.addRow(2,boton);
                    e+=1;
                }else if(e==14){
                    boton2.setDisable(true);
                    tabla.addRow(2, boton2);
                    e+=1;
                }else{
                tabla.addRow(2, boton);
                e+=1;}
            }
            else if(15<=e&&e<=20){
                if(e==18){
                    boton2.setDisable(true);
                    
                    tabla.addRow(3, boton2);
                    tabla.addRow(3,boton);
                    e+=1;
                }else{
                tabla.addRow(3, boton);
                e+=1;}
            }
            /*
            else if(16<=e&&e<=19){
                if(e==18){
                    boton=new Button(" ");
                    tabla.addColumn(4, boton);
                    e+=1;
                }else{
                tabla.addColumn(4, boton);
                e+=1;}
            }*/
            
                    
        }

        turno.setPromptText("Número de turnos para la actividad");
        agregar.setOnAction(ev -> {
                    String texto = turno.getText();
        if(texto!= ""){
            turnos = Integer.valueOf(texto);
            hCont2.getChildren().add(tex);
            hCont2.setVisible(true);
            hCont.setVisible(false);
            ArrayList<Integer> listaBin= new ArrayList<>();
            for(int i=0;i<=turnos;i++){
                int seleccion = (int)(Math.random()*13);
                if(!(listaBin.contains(seleccion))){
                    Integer num=numeros.get(seleccion);
                    listaBin.add(num);
                }
                else{
                    if(seleccion==13){
                    Integer num=numeros.get(seleccion-1);
                    listaBin.add(num);
                }
                    else{
                        Integer num=numeros.get(seleccion+1);
                        listaBin.add(num);
                    }}
            
            }
            for(Integer num:listaBin){
              tex.setText(String.valueOf(num));
              
               
            
            }

    }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Information Dialog");
            alert.setContentText("No ha ingresdo cantidad de Turnos");
            alert.showAndWait();
            
        }

            });
        
        hCont.getChildren().addAll(turno,agregar);
        
        //vCont.getChildren().addAll(hCont,hCont2);
        System.out.println(numeros);
        // TODO
    }
   
    
    }

    

