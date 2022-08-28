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
        Cliente.crearArchivoClientes();
        Atencion.crearArchivoAtenciones();
        //Empleados, Servicios, Clientes y Atenciones
        Servicio s = new Servicio("terapia de lenguaje", "Activo", 1, 23.0f);
        Servicio s2 = new Servicio("terapia de psicopedagogica", "Activo", 2, 22.5f);
        Servicio s3 = new Servicio("terapia de emociones", "Activo", 3, 20.0f);
        Empleado e1 = new Empleado("Miguel", "Ochoa", "12032884843", "098687454", "jose@hotmail.es", "Inactivo");
        Empleado e2 = new Empleado("Hector", "Ortega", "1203296213", "098688754", "Lot@hotmail.es", "Activo");
        Cliente c1 = new Cliente("Ana", "Suarez", "0909202584", "0999999999", "anasuarez@gmail.com", "Clarisa");
        Cliente c2 = new Cliente("José", "López", "0987946564", "0954515487", "joselop@gmail.com", "Roberto");
        Cita c = new Cita("05/07/2022", "16:00", c1, s, e1, 2);
        Cita ci2 = new Cita("28/08/2022", "14:00", c2, s2, e2, 1);
        Atencion a = new Atencion(c);
        
        Servicio.registrarServicio(s);
        Servicio.registrarServicio(s2);
        Servicio.registrarServicio(s3);
        Empleado.registrarEmpleado(e1);
        Empleado.registrarEmpleado(e2);
        Cliente.registrarCliente(c1);
        Cliente.registrarCliente(c2);
        Cita.registrarCita(c);
        Cita.registrarCita(ci2);
        Atencion.registrarAtencion(a);//Comentar de la linea 28 a la linea 47 para que se evidencie
                                       // que se ha agregado informacion al archivo
        scene = new Scene(loadFXML("tercera"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    static void changeRoot(Parent rootNode) {
        scene.setRoot(rootNode);
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
        
        //hola
    }

}