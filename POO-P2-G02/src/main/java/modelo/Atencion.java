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
    //Atributos
    private Cita cita;
    private static ArrayList<Atencion> atenciones = new ArrayList<> ();
    //Getters
    public Cita getCita(){
        return cita;
    }
    public ArrayList<Atencion> getAtenciones(){
        return atenciones;
    }
    //Setters
    public void setCita(Cita cita){
        this.cita = cita;
    }
    public void setAtenciones(ArrayList<Atencion> atenciones){
        this.atenciones = atenciones;
    }
    //Constructor
    public Atencion(Cita cita){
        this.cita = cita;
    }
    //Metodo registrarAtencion
    public void registrarAtencion(String cedula, Cita c, Servicio s, int duracionRealH, Empleado e){
        //Recorrer las citas hasta encontrar la que coincide con la cedula del cliente
        for (Cita x: c.getCita()){
            //Si coincide la cedula del cliente con la cedula de una cita, se asigna el servicio
            if (x.getCliente().getCedula().equals(cedula)){
                //Se registra el servicio
                x.setServicio(s);
                //Se registra la duracion real
                x.setDuracion(duracionRealH);
                //Validacion de empleado
                if (x.getEmpleado().equals(e)){
                    //No suceden cambios porque es el mismo empleado
                } else {
                    //Cambiamos el empleado de la cita, por el nuevo
                    x.setEmpleado(e);
                }
                atenciones.add(new Atencion(x));
            //Si su número de cédula no coincide con ninguna cita
            } else {
                System.out.println("Usted no tiene cita asignada, por lo que no puede registrar su atencion");
            }
        }
    }
    //Sobrecarga del método consultarAtencion
    public static void consultarAtencion(String s){
        System.out.println("Seleccione su opción: \n 1.CEDULA CLIENTE \n 2.CEDULA EMPLEADO \n 3.FECHA");
        for (Atencion a: atenciones){
            if (a.getCita().getCliente().getCedula().equals(s)){
                a.toString();
            } else if (a.getCita().getEmpleado().getCedula().equals(s)){
                a.toString();
            } else if (a.getCita().getFecha().equals(s)){
                a.toString();
            }
        }
    }
    //Sobreescritua del metodo toString
    @Override
    public String toString(){
        return "Atención: " + cita.toString();
    }
}
