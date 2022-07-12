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
public class Servicio {
    private String nombreServicio, estado, tipoServicio;
    private int duracionServicio;
    private float precio;
    private ArrayList<Servicio> servicios = new ArrayList<>();
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
    public ArrayList<Servicio> getServicios(){
        return servicios;
    }
    //Setters
    public void setNombreServicio(String Servicio)
    //Constructor
    public Servicio(String nombreServicio, String estado, String tipoServicio,int duracionServicio, float precio){
        this.nombreServicio = nombreServicio;
        this.estado = estado;
        this.tipoServicio = tipoServicio;
        this.duracionServicio = duracionServicio;
        this.precio = precio;
    }
    //Método agregarServicio
    public void agregarServicio(String nombre, String estado, String tipo, int duracion, float precio){
        nombreServicio = nombre;
        this.estado = estado;
        tipoServicio = tipo;
        duracionServicio = duracion;
        this.precio = precio;
    }
    //Método editarServicio
    public void editarServicio(String nombre, String estado, String tipo, int duracion, float precio){
        System.out.println("¿Desea cambiar el servicio? (SI/NO)");
        String yes_no = sc.nextLine();
        if (yes_no.equals("NO")){
            //Se guarda el mismo nombre del servicio
            this.nombreServicio = nombre;
        } else if (yes_no.equals("SI")){
            System.out.println("Ingrese el nombre del servicio nuevo: ");
            String sActual = sc.nextLine();
            //Se guarda el nuevo nombre del servicio
            nombre = sActual;
        } else {
            System.out.println("Vuelva a ingresar");
        }
    }
    //Método eliminarServicio
    public void eliminarServicio(){
        estado = "Inactivo";
    }
}
