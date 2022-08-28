/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author César
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Objects;

public class Cliente extends Persona implements Serializable{

    private static ArrayList<Cliente> arregloC = new ArrayList<Cliente>();
    private String datosRepresentante;//se crea la variable para los datos del representante

    public String getDatosRepresentante() {
        return datosRepresentante;
    }

    public void setDatosRepresentante(String datosRepresentante) {
        this.datosRepresentante = datosRepresentante;
    }

    public static ArrayList<Cliente> getArregloC() {
        return arregloC;
    }

    public void setArregloC(ArrayList<Cliente> cliente) {
        arregloC = cliente;
    }// se crean los getters y setters de Datos Representante
    public Cliente(){
    }

    public Cliente(String nombre, String apellido, String cedula, String telefono, String email, String datosRepresentante) {
        super(nombre, apellido, cedula, telefono, email);
        this.datosRepresentante = datosRepresentante;
    }//se crea el contstructor de cliente

    public void editarCliente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el numero de lo que va a editar");
        System.out.println("1. nombre \n" + "2. apellido \n" + "3. telefono\n" + "4. email\n");
        int i = sc.nextInt();
        sc.nextLine();
        switch (i) {
            case 1:
                System.out.println("Ingrese el nombre a editar");
                String n = sc.nextLine();
                this.setNombre(n);
                break;
            case 2:
                System.out.println("Ingrese el apellido a editar");
                String a = sc.nextLine();
                this.setApellido(a);
                break;
            case 3:
                System.out.println("Ingrese el teléfono a editar");
                String t = sc.nextLine();
                this.setTelefono(t);
                break;
                
            case 4:
                
                System.out.println("Ingrese el email a editar");
                String email = sc.nextLine();
                this.setEmail(email);
                break;
                
        }
    }// se crea el metodo editar cliente para editar su informacion 

    public static void agregarCliente(Cliente c) {
        arregloC.add(c);
    }//se crea el metodo agregar Cliente

    @Override
    public String toString() {
        return this.getNombre()+" "+this.getApellido();
        //return "CLIENTE"+super.toString() + "\nDatos representante: " + datosRepresentante;
    }
    //Nuevos métodos
    public static void crearArchivoClientes(){
        try(ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(Constantes.rutaClientes))){
            ArrayList<Cita> listaRegistros = new ArrayList<>();
            escritor.writeObject(listaRegistros);
            escritor.flush();
            
            
        }catch(IOException e){
            e.printStackTrace();}
        catch(Exception e){
            System.out.println("-------Excepcion general--------");
        }
    
    }
    
    public static ArrayList<Cliente> cargarCliente(){
        ArrayList<Cliente> listaRetorno  = new ArrayList<>();
        
        try(ObjectInputStream lector = new ObjectInputStream(new FileInputStream(Constantes.rutaClientes))) {
            listaRetorno = (ArrayList<Cliente>)lector.readObject();   
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
    public static void registrarCliente(Cliente c){
        ArrayList<Cliente>listaActualizada = cargarCliente();
        listaActualizada.add(c);
        try(ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(Constantes.rutaClientes))) {
            escritor.writeObject(listaActualizada);
        }
        
        catch (IOException ex){
            ex.printStackTrace();
        }
    
    }
        @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.getCedula());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.getCedula(), other.getCedula())) {
            return false;
        }
        return true;
    }
    public void eliminar(int indice){
        
    }
}
