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
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import javafx.scene.layout.Background;

/**
 * FXML Controller class
 *
 * @author César
 */
public class BingoController {
    String turnoC ="";
    ArrayList<String> imagenes = new ArrayList<>();
    int correctas = 0;
    int incorrectas = 0;
    @FXML
    private GridPane tabla;
    
    ArrayList<Integer> numeros = new ArrayList<>();
    @FXML
    private VBox vCont;
    @FXML
    private HBox hCont;
    TextField turno = new TextField();
    Button agregar = new Button("Establecer Turno");
    int turnos=1;
    Label tex = new Label();
    @FXML
    private HBox hCont2;
    ImageView imagenSet= new ImageView();
    ArrayList<String> imag = new ArrayList<>();
    /**
     * Initializes the controller class.
     */
    public void initialize() {
        tabla.setVisible(false);
        /*imag.add("bear2.png");
        for(String c: imag){
        try{
            String ruta = App.class.getResource("imagenes/"+c).getPath();
            FileInputStream is = new FileInputStream(ruta);
            Image image = new Image(is, 150, 150, false, false);
            imagenSet.setImage(image);
        }catch(IOException e){
            System.out.println("Hola");
        }}*/
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

            //hCont2.add(tex);
            Button boton2 = new Button("   ");
            boton.setOnAction(ev->{
                //tabla.setVisible(false);
            ArrayList<Integer> listaBin= new ArrayList<>();
            for(int i=0;i<turnos;i++){
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
            if((turnos!=0)&&(Integer.valueOf(boton.getText())==Integer.valueOf(tex.getText()))){
                  System.out.println("Correcta");
                  correctas+=1;
                  turnos-=1;
            for(Integer num:listaBin){
              tex.setText(String.valueOf(num));
              
                  //turnos-=1;
                  
              
              }
            }
            else if((turnos!=0)&&(Integer.valueOf(boton.getText())!=Integer.valueOf(tex.getText()))){
                System.out.println("Incorrecta");
                  incorrectas+=1;
                  turnos-=1;
            for(Integer num:listaBin){
              tex.setText(String.valueOf(num));
              
                  //turnos-=1;
              }
                
                
            
            }
                });
            if(e<=4){
                if(e==2){
                    boton2.setDisable(true);
                    tabla.addRow(0, boton2);
                    tabla.addRow(0,boton);
                    e+=1;
                }else{
                tabla.addRow(0, boton);
                //tabla.addRow(0,imagen);
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
            
                    
        }

        turno.setPromptText("Número de turnos para la actividad");
        agregar.setOnAction(ev -> {
                    String texto = turno.getText();
                    turnos=Integer.valueOf(texto);
        if(texto!= ""){
            String correcto = "";
            
            hCont2.getChildren().add(tex);
            hCont2.setVisible(true);
            hCont.setVisible(false);
            tabla.setVisible(true);
            ArrayList<Integer> listaBin= new ArrayList<>();
            for(int i=0;i<turnos;i++){
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
             
           /* */

    }}else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Information Dialog");
            alert.setContentText("No ha ingresdo cantidad de Turnos");
            alert.showAndWait();
            
        }

            });
        
        hCont.getChildren().addAll(turno,agregar,imagenSet);
        
        //vCont.getChildren().addAll(hCont,hCont2);
        System.out.println(numeros);
        if(turnos==0){
            vCont.getChildren().clear();
            Label terminado = new Label("Actividad Finalizada");
        }
        // TODO
    }

    
}