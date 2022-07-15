/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Karen
 */
public class Empleado extends Persona{
    private String estado;
    private static ArrayList<Empleado> empleados = new ArrayList<>();
    //Scanner
    Scanner sc = new Scanner(System.in);
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
    public void editarEmpleado(Empleado e){
        System.out.println("Ingrese el número de la opción que desea editar: \n 1.NOMBRE \n 2.APELLIDO \n 3.TELEFONO \n 4.EMAIL \n 5.ESTADO");
        int i = sc.nextInt();
        sc.nextLine();
        switch (i){
            case 1:
                System.out.println("Ingrese el nuevo nombre: ");
                String n = sc.nextLine();
                e.setNombre(n);
                break;
            case 2:
                System.out.println("Ingrese el nuevo apellido: ");
                String a = sc.nextLine();
                e.setApellido(a);
                break;
            case 3:
                System.out.println("Ingrese el nuevo telefono: ");
                String t = sc.nextLine();
                e.setTelefono(t);
                break;
            case 4:
                System.out.println("Ingrese el nuevo email: ");
                String em = sc.nextLine();
                e.setEmail(em);
                break;
            case 5:
                System.out.println("Ingrese el nuevo estado: ");
                String es = sc.nextLine();
                e.setEstado(es);
                break;
        }
    }
    //Sobreescritura metodo toString
    public String toString(){
        return "EMPLEADO \nNombre: " + this.getNombre() + " \nApellido: " + this.getApellido() + " \nCedula: " + this.getCedula() + " \nTelefono: " + this.getCedula() + " \nEmail: " + this.getEmail() + " \nEstado:" + this.getEstado();
    }
}
