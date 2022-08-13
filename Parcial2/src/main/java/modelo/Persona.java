/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author César
 */
public class Persona implements Serializable{

    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private String email;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }
    public Persona(){}

    public Persona(String nombre, String apellido, String cedula, String telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.email = email;
    }

    @Override
    public String toString() {
       return  "\nNombre: " + this.getNombre() + " \nApellido: " + this.getApellido() + " \nCedula: " + this.getCedula() + " \nTelefono: " + this.getTelefono()+ " \nEmail: " + this.getEmail();
    }
    public static void crearArchivoPersona(){
        try(ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(Constantes.rutaPersona))){
            ArrayList<Persona> listaRegistros = new ArrayList<>();
            escritor.writeObject(listaRegistros);
            escritor.flush();
            
            
        }catch(IOException e){
            e.printStackTrace();}
        catch(Exception e){
            System.out.println("-------Excepcion general--------");
        }
    
    }
    
    public static ArrayList<Persona> cargarPersona(){
        ArrayList<Persona> listaRetorno  = new ArrayList<>();
        
        try(ObjectInputStream lector = new ObjectInputStream(new FileInputStream(Constantes.rutaPersona))) {
            listaRetorno = (ArrayList<Persona>)lector.readObject();   
        }
        catch(FileNotFoundException e){
            System.out.println("El archivo no fue encontrado");}
        catch (IOException ex) {
            ex.printStackTrace();
        }  catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        } 
        return listaRetorno;
    }
    public static void registrarPersona(Persona p){
        ArrayList<Persona>listaActualizada = cargarPersona();
        listaActualizada.add(p);
        try(ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(Constantes.rutaPersona))) {
            escritor.writeObject(listaActualizada);
        }
        
        catch (IOException e){
            e.printStackTrace();
        }
    
    }
}
