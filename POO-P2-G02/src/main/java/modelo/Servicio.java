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
public class Servicio {
    private String nombreServicio, estado;
    private int duracionServicio;
    private double precio;
    private static ArrayList<Servicio> servicios = new ArrayList<>();
    //Scanner
    Scanner sc = new Scanner(System.in);
    //Getters
    public String getNombreServicio(){
        return nombreServicio;
    }
    public String getEstado(){
        return estado;
    }
    
    public int getDuracionServicio(){
       return duracionServicio;
    }
    public double getPrecio(){
       return precio;
    }
    public static ArrayList<Servicio> getServicios(){
        return servicios;
    }
    //Setters
    public void setNombreServicio(String nombreServicio){
        this.nombreServicio = nombreServicio;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }
    
    public void setDuracionServicio(int duracionServicio){
        this.duracionServicio = duracionServicio;
    }
    public void setPrecio(double precio){
        this.precio = precio;
    }
    public void setServicios(ArrayList<Servicio> servicios){
        this.servicios = servicios;
    }
    //Constructor
    public Servicio(){
    }
    public Servicio(String nombreServicio, String estado,int duracionServicio, double precio){
        this.nombreServicio = nombreServicio;
        this.estado = estado;
        
        this.duracionServicio = duracionServicio;
        this.precio = precio;
    }
    //Método agregarServicio: Agrega el nuevo servicio al arreglo
    public static void agregarServicio(Servicio s){
        servicios.add(s);
    }
    //Método editarServicio: Recibe un servicio y los parametros para cambiarlo
    public void editarServicio(Servicio s){
        System.out.println("Ingrese el número de la opción que desea editar: \n 1.NOMBRE \n 2.ESTADO \n 3.DURACION \n 4.PRECIO");
        int i = sc.nextInt();
        sc.nextLine();
        switch (i){
            case 1:{
                System.out.println("Ingrese el nuevo nombre: ");
                String n = sc.nextLine();
                s.setNombreServicio(n);
                break;}
            case 2:{
                System.out.println("Ingrese nuevo estado: ");
                String es = sc.nextLine();
                s.setEstado(es);
                break;}
            
            case 3:{
                System.out.println("Ingrese nueva duración: ");
                int d = sc.nextInt();
                sc.nextLine();
                s.setDuracionServicio(d);
                break;}
            case 4:{
                System.out.println("Ingrese nuevo precio");
                double p = sc.nextDouble();
                sc.nextLine();
                s.setPrecio(p);
                break;}
        } 
    }
    //Método eliminarServicio: Recibe un servicio y cambia su estado
    public void eliminarServicio(Servicio s){
        s.setEstado("Inactivo");
    }
    @Override
    public String toString(){
        return "Servicio: "+nombreServicio+", Estado: "+estado+", Duracion: "+duracionServicio+", Precio: "+precio;
    }//agregar toString
}
