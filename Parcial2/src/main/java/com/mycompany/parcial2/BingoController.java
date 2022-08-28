/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.parcial2;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;



import javafx.scene.layout.Background;
import javafx.stage.Stage;
import modelo.Cita;
import modelo.Constantes;

/**
 * FXML Controller class
 *
 * @author César
 */
public class BingoController {
    String bingo = "Bingo";
    int j=0;
    Label tiempoEmpleado = new Label();
    ArrayList<Integer> listaBin= new ArrayList<>();
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
    ArrayList<Integer>valores = new ArrayList<>();
    int minutosP= 0;
    int segundosP=0;
    public int getMinutosP(){
        return minutosP;
    }
    public int getSegundosP(){
        return segundosP;
    }
    public int getAciertos(){
        return correctas;
    }
    public int getFallos(){
        return incorrectas;
    }
    public String getBingo(){
        return bingo;
    }
    private Cita cita;
    public Cita getCita(){
    return cita;}
    /**
     * Initializes the controller class.
     */
    public void initialize() {
        

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
           valores.add(0);

        }
        
        for(int a=0;a<=19;a++){
            int aletorio = (int)(Math.random()*20);
            if(valores.get(aletorio)==0){
                valores.set(aletorio, numeros.get(a)); 
            }
            else if(valores.get(aletorio)!=0){
                int indiceA= 0;
                for(int i=0;i<=19;i++){
                int aletorio2=(int)(Math.random()*19);
                if(valores.get(aletorio2)==0){
                    indiceA=aletorio2; 
                }}
                valores.set(indiceA, numeros.get(a));
                //valores.set(aletorio, numeros.get(a)); 
            }
          }


        for(Integer v:numeros){
            Button boton = new Button(String.valueOf(v));
            boton.setMaxSize(50, 50);

            Button boton2 = new Button("   ");
            boton2.setMaxSize(50, 50);
            boton.setOnAction(ev->{
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
                  j+=1;
                  tex.setText(String.valueOf(valores.get(j)));
                  
                  turnoFin+=1;
           // for(Integer num:listaBin){
        
                
                System.out.println(j);
                
              
                  //turnos-=1;
                  
              
             // }

            }
            else if((turnos!=0)&&(Integer.parseInt(boton.getText())!=Integer.parseInt(tex.getText()))){
                System.out.println("Incorrecta");
                //boton.setStyle("-fx-background-color: Red");
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
 
                  
                  incorrectas+=1;
                  turnos-=1;
                  turnoFin+=1;

                
            
            }        if(turnoFin==Integer.valueOf(turno.getText())){
           tabla.setVisible(false);
           tex.setVisible(false);
           finAct.setVisible(true);
           //tiempoEmpleado.setVisible(true);
           //tiempo.setVisible(true);
           if(Integer.valueOf(tiempo.getText())>=60){
                minutosP += Integer.valueOf(tiempo.getText())/60;
                segundosP += Integer.valueOf(tiempo.getText())-(minutosP*60);}
           else{
               segundosP+=Integer.valueOf(tiempo.getText());
           }
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setHeaderText(null);
           alert.setTitle("Information De Actividad");
           alert.setContentText("Selcecciones correctas: "+correctas+"\n"+"Selecciones incorrectas: "+incorrectas+"\n"+"Tiempo de actividad: "+minutosP+" minutos"+" : "+segundosP+" segundos");
           alert.showAndWait();
           

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
            
           for(int i=0;i<turnos;i++){

            
            }
            System.out.println(listaBin);
            
              tex.setText(String.valueOf(valores.get(0)));
             
           /* */

    }else{
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
            try(FileWriter b = new FileWriter(Constantes.rutaActividad,true)) {
                int minutos=0;
                int segundos=0;
                b.write(String.valueOf(correctas));
                b.write(",");
                b.write(String.valueOf(incorrectas));
                b.write(",");
                
                if(Integer.valueOf(tiempo.getText())>=60){
                minutos += Integer.valueOf(tiempo.getText())/60;
                segundos += Integer.valueOf(tiempo.getText())-(minutos*60);
                    System.out.println(segundos);
                b.write(String.valueOf(minutos));
                b.write(" minutos ");
                b.write(": ");
                b.write(String.valueOf(segundos));
                b.write(" segundos");
                b.write("\r\n");}
                else if (Integer.valueOf(tiempo.getText())<60){
                    minutos=0;
                b.write(String.valueOf(minutos));
                b.write(" minutos ");
                b.write(": ");   
                b.write(tiempo.getText());
                b.write(" segundos");
                b.write("\r\n");}
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Information Dialog");
            alert.setContentText("Actividad Registrada");
            alert.showAndWait();  
            Stage stage = (Stage) this.finAct.getScene().getWindow();
            stage.close();
        
            
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
 
 public void closeWindows(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mycompany/parcial2/noveno.fxml"));
            Parent root = loader.load();
            NovenoController controlador  = loader.getController();
           Scene scene = new Scene(root);
           Stage stage = new Stage();
            
           stage.setScene(scene);
           stage.show();
           stage.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
 }
 @Override
 public String toString(){
     return bingo+cita.getFecha()+correctas+incorrectas+minutosP+segundosP;
 }
 
 

     
}