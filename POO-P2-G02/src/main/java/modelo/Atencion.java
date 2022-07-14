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
public class Atencion {
    private Cita cita;
    private ArrayList<Atencion> atenciones = new ArrayList<> ();
    
    public Atencion(Cita cita, ArrayList<Atencion> atenciones){
        this.cita = cita;
        this.atenciones = atenciones;
    }
    
    public void registrarAtencion(){
        Empleado e = cita.getEmpleado();
    }
    public void consultarAtencion(){
        
    }
}
