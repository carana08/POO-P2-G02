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
import javafx.application.Platform;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import javafx.scene.layout.Background;
import modelo.Constantes;

/**
 * FXML Controller class
 *
 * @author César
 */
public class BingoController {
    Label tiempoEmpleado = new Label();
    String turnoP ="";
    ArrayList<Integer> aparecidos = new ArrayList<>();
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
    int turnos=0;
    int turnoFin=0;
    int tTranscurrido;
    Label tex = new Label();
    @FXML
    private HBox hCont2;
    ImageView imagenSet= new ImageView();
    ArrayList<String> imag = new ArrayList<>();
    Button finAct = new Button("Fin Actividad");
    Label tiempo = new Label();
    VBox insImagen = new VBox();
    /**
     * Initializes the controller class.
     */
    public void initialize() {
        //System.out.println(aparecidos);
        tabla.setVisible(false);
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
        System.out.println(numeros);
        for(Integer v:numeros){
            Button boton = new Button(String.valueOf(v));

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
            if((turnos!=0)&&(Integer.parseInt(boton.getText())== Integer.parseInt(tex.getText()))){
                  System.out.println("Correcta");
                  boton.setStyle("-fx-background-color: MediumSeaGreen");
                  FileInputStream f;
                  try{
                      f= new FileInputStream(Constantes.rutaImg1);
                      Image imagen = new Image(f,100,100,false,false);
                      ImageView imageView = new ImageView(imagen);
                      hCont.getChildren().addAll(imageView);
                      
                  }catch(FileNotFoundException ex){
                      System.out.println(ex);
                  }
                  correctas+=1;
                  turnos-=1;
                  turnoFin+=1;
            for(Integer num:listaBin){
                tex.setText(String.valueOf(num));
              
                  //turnos-=1;
                  
              
              }

            }
            else if((turnos!=0)&&(Integer.parseInt(boton.getText())!=Integer.parseInt(tex.getText()))){
                System.out.println("Incorrecta");
                boton.setStyle("-fx-background-color: Red");
                aparecidos.add(Integer.parseInt(boton.getText()));
                FileInputStream f;
                  try{
                      f= new FileInputStream(Constantes.rutaImg2);
                      Image imagen = new Image(f,100,100,false,false);
                      ImageView imageView = new ImageView(imagen);
                      hCont.getChildren().addAll(imageView);
                  }catch(FileNotFoundException ex){
                      System.out.println(ex);
                  }
                  /*
                  if(aparecidos.contains(boton.getText())){
                          boton.setStyle("-fx-background-color: Gray");
                  }*/
                  
                  
                  incorrectas+=1;
                  turnos-=1;
                  turnoFin+=1;
            /*
                 for(Integer num:listaBin){
                tex.setText(String.valueOf(num));
              
                  //turnos-=1;
                  
              
              }*/
                
                
            
            }        if(turnoFin==Integer.valueOf(turno.getText())){
           tabla.setVisible(false);
           tex.setVisible(false);
           finAct.setVisible(true);
           tiempoEmpleado.setVisible(true);
           tiempo.setVisible(true);
           

            //Label terminado = new Label("Actividad Finalizada");
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
        if(texto!= ""){
            turnos=Integer.valueOf(texto);
            //String correcto = "";
            tiempo.setText("0");
            tiempoEmpleado.setText("Tiempo Empleado en la Actividad:");
            hCont2.getChildren().addAll(tex,finAct,tiempoEmpleado,tiempo);
            hCont2.setVisible(true);
            //hCont.setVisible(false);
            turno.setVisible(false);
            agregar.setVisible(false);
            tabla.setVisible(true);
            finAct.setVisible(false);
            tiempo.setVisible(false);
            tiempoEmpleado.setVisible(false);
            Thread hilo = new Thread(new Temporizador());
            hilo.setDaemon(true);
            hilo.start();         
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
            for(Integer num:numeros){
              tex.setText(String.valueOf(num));
              aparecidos.add(num);
             
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
        //System.out.println(numeros);
        finAct.setOnAction(ev->{
            try {
                App.setRoot("noveno");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
           
           });


        // TODO
    }

 private class Temporizador implements Runnable{
     boolean progresion = true;
     @Override 
     public void run(){
         while(progresion){
             try{
                 Thread.sleep(1000);

             }catch(InterruptedException ex){
                 ex.printStackTrace();
             }
             incrementador();
         
         }
         

     
     }
     public void incrementador(){
         tTranscurrido++;
         Platform.runLater(()->{
             tiempo.setText(String.valueOf(tTranscurrido));
             
         });
         if(turnoFin==Integer.valueOf(turno.getText())){
             progresion=false;
         
         }

    }
 }
     
}