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
    private ArrayList<Empleado> empleados = new ArrayList<>();

    //Getters
    public String getEstado(){
        return estado;
    }
    public ArrayList<Empleado> getEmpleados(){
        return empleados;
    }
    //Setters
    public void setEstado(String estado){
        this.estado = estado;
    }
    public void setEmpleados(ArrayList<Empleado> empleados){
        this.empleados = empleados;
    }

    //Constructor
    public Empleado(String nombre, String apellido, String cedula, String telefono, String email, String estado,  ArrayList<Empleado> empleados){
        super(nombre, apellido, cedula, telefono, email);
        this.estado = estado;
        this.empleados = empleados;
    }
    //Metodo agregarEmpleado: Recibe un empleado y lo agrega al arreglo
    public void agregarEmpleado(Empleado e){
        empleados.add(e);
    }
    //Metodo eliminarEmpleado: Recibe un empleado y cambia su estado
    public void eliminarEmpleado(Empleado e){
        e.setEstado("Inactivo");
    }
    //Metodo editarEmpleado: S
    public void editarEmpleado(Empleado e, String nombre, String apellido, String cedula, String telefono, String email, String estado){
        e.setNombre(nombre);
        e.setApellido(apellido);
        e.setCedula(cedula);
        e.setTelefono(telefono);
        e.setEmail(email);
        e.setEstado(estado);
    }
}
