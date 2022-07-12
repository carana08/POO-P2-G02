/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;
/**
 *
 * @author Karen
 */
public class Empleado extends Persona{
    private String estado;
    private ArrayList<Servicio> servicios;
    
    //Constructor
    public Empleado(String nombre, String apellido, String cedula, String telefono, String email, String estado, ArrayList<Servicio> servicios){
        super(nombre, apellido, cedula, telefono, email);
        this.estado = estado;
        this.servicios = servicios;
    }
    //Metodo agregarEmpleado
    public void agregarEmpleado(String nombre, String apellido, String cedula, String telefono, String email, String estado){
        //Creación de objeto Persona
        Empleado e = new Empleado(nombre, apellido, cedula, telefono, email, estado, servicios);
        
    }
}
