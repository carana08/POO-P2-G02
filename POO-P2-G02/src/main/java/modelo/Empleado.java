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
    private ArrayList<Empleado> empleados = new ArrayList<Empleado>();
    private ArrayList<Servicio> servicios = new ArrayList<Servicio>();
    //Getters
    public String getEstado(){
        return estado;
    }
    public ArrayList<Empleado> getEmpleados(){
        return empleados;
    }
    public ArrayList<Servicio> getServicios(){
        return servicios;
    }
    //Setters
    public void setEstado(String estado){
        this.estado = estado;
    }
    public void setEmpleados(ArrayList<Empleado> empleados){
        this.empleados = empleados;
    }
    public void setServicios(ArrayList<Servicio> servicios){
        this.servicios = servicios;
    }
    //Constructor
    public Empleado(String nombre, String apellido, String cedula, String telefono, String email, String estado, ArrayList<Servicio> servicios, ArrayList<Empleado> empleados){
        super(nombre, apellido, cedula, telefono, email);
        this.estado = estado;
        this.empleados = empleados;
        this.servicios = servicios;
        
    }
    //Metodo agregarEmpleado
    public void agregarEmpleado(Empleado e){
        empleados.add(e);
    }
    //Metodo eliminarEmpleado
    public void eliminarEmpleado(Empleado e){
        e.setEstado("Inactivo");
    }
    //Metodo editarEmpleado
    public void editarEmpleado(Empleado e, String nombre, String apellido, String cedula, String telefono, String email, String estado, ArrayList<Servicio> servicios){
        e.setNombre(nombre);
        e.setApellido(apellido);
        e.setCedula(cedula);
        e.setTelefono(telefono);
        e.setEmail(email);
        e.setEstado(estado);
        e.setServicios(servicios);
    }
}
