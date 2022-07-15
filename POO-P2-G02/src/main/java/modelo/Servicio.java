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
    private String nombreServicio, estado, tipoServicio;
    private int duracionServicio;
    private float precio;
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
    public String getTipoServicio(){
        return tipoServicio;
    }
    public int getDuracionServicio(){
       return duracionServicio;
    }
    public float getPrecio(){
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
    public void setTipoServicio(String tipoServicio){
        this.tipoServicio = tipoServicio;
    }
    public void setDuracionServicio(int duracionServicio){
        this.duracionServicio = duracionServicio;
    }
    public void setPrecio(float precio){
        this.precio = precio;
    }
    public void setServicios(ArrayList<Servicio> servicios){
        this.servicios = servicios;
    }
    //Constructor
    public Servicio(){
    }
    public Servicio(String nombreServicio, String estado, String tipoServicio,int duracionServicio, float precio, ArrayList<Servicio> servicios){
        this.nombreServicio = nombreServicio;
        this.estado = estado;
        this.tipoServicio = tipoServicio;
        this.duracionServicio = duracionServicio;
        this.precio = precio;
        this.servicios = servicios;
    }
    //Método agregarServicio: Agrega el nuevo servicio al arreglo
    public void agregarServicio(Servicio s){
        servicios.add(s);
    }
    //Método editarServicio: Recibe un servicio y los parametros para cambiarlo
    public void editarServicio(Servicio s){
        System.out.println("Ingrese el número de la opción que desea editar: \n 1.ESTADO \n 2.TIPO \n 3.DURACION \n 4.PRECIO");
        int i = sc.nextInt();
        sc.nextLine();
        switch (i){
            case 1:
                System.out.println("Ingrese el nuevo nombre: ");
                String n = sc.nextLine();
                s.setNombreServicio(n);
                break;
            case 2:
                System.out.println("Ingrese nuevo estado: ");
                String es = sc.nextLine();
                s.setEstado(es);
                break;
            case 3:
                System.out.println("Ingrese nuevo tipo de servicio: ");
                String t = sc.nextLine();
                s.setTipoServicio(t);
                break;
            case 4:
                System.out.println("Ingrese nueva duración: ");
                int d = sc.nextInt();
                sc.nextLine();
                s.setDuracionServicio(d);
                break;
        }
    }
    //Método eliminarServicio: Recibe un servicio y cambia su estado
    public void eliminarServicio(Servicio s){
        s.setEstado("Inactivo");
    }
}
