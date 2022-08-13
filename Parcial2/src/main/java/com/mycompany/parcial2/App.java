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
        Servicio.registrarServicio(new Servicio("terapia de lenguaje", "Activo", 1, 23.0f));
        Empleado.registrarEmpleado(new Empleado("Miguel", "Ochoa", "12032884843", "098687454", "jose@hotmail.es", "Inactivo"));
        Empleado.registrarEmpleado(new Empleado("Hector", "Ortega", "1203296213", "098688754", "Lot@hotmail.es", "Activo"));
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