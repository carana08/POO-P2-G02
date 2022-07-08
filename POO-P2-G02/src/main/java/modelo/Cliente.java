/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author César
 */
public class Cliente extends Persona{
    private String datosRepresentante;//se crea la instancia para los datos del representante

    public String getDatosRepresentante() {
        return datosRepresentante;
    }

    public void setDatosRepresentante(String datosRepresentante) {
        this.datosRepresentante = datosRepresentante;
    }// se crean los getters y setters de Datos Representante

    public Cliente(String datosRepresentante, String nombre, String apellido, String cedula, String telefono, String email) {
        super(nombre, apellido, cedula, telefono, email);
        this.datosRepresentante = datosRepresentante;
    }//se crea el contstructor de cliente
    public void editarCliente(String n,String a,String t,String email){
        this.setNombre(n);
        this.setApellido(a);
        this.setEmail(email);
        this.setTelefono(t);
    }// se crea el metodo editar cliente para editar su informacion 
    public void agregarCliente(String n,String a,  String t,String email, String cedula, String datos){
        
    }
    
}
