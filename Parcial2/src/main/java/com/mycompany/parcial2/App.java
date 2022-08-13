package com.mycompany.parcial2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import modelo.Empleado;
import modelo.Persona;
import modelo.Servicio;
import modelo.Cita;
import modelo.Cliente;
import modelo.Atencion;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Persona.crearArchivoPersona();
        Empleado.crearArchivoEmpleado();
        Servicio.crearArchivoServicios();
        Cita.crearArchivoCitas();
        //Empleados, Servicios, Clientes y Atenciones
        Servicio s = new Servicio("terapia de lenguaje", "Activo", 1, 23.0f);
        Empleado e1 = new Empleado("Miguel", "Ochoa", "12032884843", "098687454", "jose@hotmail.es", "Inactivo");
        Empleado e2 = new Empleado("Hector", "Ortega", "1203296213", "098688754", "Lot@hotmail.es", "Activo");
        Cliente c1 = new Cliente("Ana", "Suarez", "0909202584", "0999999999", "anasuarez@gmail.com", "Clarisa");
        Cita c = new Cita(c1, e1 ,s, "05/07/2022", 5, "16:00","18:00");
        Atencion a = new Atencion(c);
        
        Servicio.registrarServicio(s);
        Empleado.registrarEmpleado(e1);
        Empleado.registrarEmpleado(e2);
        Cliente.registrarCliente(c1);
        Cita.registrarCita(c);
        Atencion.registrarAtencion(a);
        scene = new Scene(loadFXML("tercera"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}