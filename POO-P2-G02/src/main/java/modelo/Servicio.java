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
    public void editarServicio(Servicio s,String nombre, String estado, String tipo, int duracion, float precio){
        s.setNombreServicio(nombre);
        s.setEstado(estado);
        s.setTipoServicio(tipo);
        s.setDuracionServicio(duracion);
        s.setPrecio(precio);
    }
    //Método eliminarServicio: Recibe un servicio y cambia su estado
    public void eliminarServicio(Servicio s){
        s.setEstado("Inactivo");
    }
}
