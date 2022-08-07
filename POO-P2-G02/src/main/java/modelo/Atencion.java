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
public class Atencion {
    //Atributos
    private Cita cita;
    private static ArrayList<Atencion> atenciones = new ArrayList<> ();
    //Getters
    public Cita getCita(){
        return cita;
    }
    public static ArrayList<Atencion> getAtenciones(){
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
    public Atencion (){};
    public Atencion(Cita cita){
        this.cita = cita;
    }
    //Metodo registrarAtencion
    public void registrarAtencion(Atencion a){
        atenciones.add(a);
    }
    //Sobrecarga del método consultarAtencion
    public static void consultarAtencion(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingrese como la opcion por la que va a realizar la consulta: \n1.CEDULA CLIENTE \n2.CEDULA EMPLEADO \n3.FECHA");
        int ing = sc.nextInt();
        sc.nextLine();
        Atencion at= new Atencion();
        switch(ing){
            case 1:{
                System.out.print("Ingrese cedula del cliente: ");
                String s=sc.nextLine();
                for (Atencion a: atenciones){
            if (a.getCita().getCliente().getCedula().equals(s)){
                at=a;
            }
            }break; 
            }
            case 2:{
                System.out.print("Ingrese cedula del Empleado: ");
                String s=sc.nextLine();
                for (Atencion a: atenciones){
                    if (a.getCita().getEmpleado().getCedula().equals(s)){
                at=a;     
            } 
            }break;
        }
            case 3:{
                 System.out.print("Ingrese la fecha con el formato dd/mm/aaaa: ");
                String s=sc.nextLine();
            for (Atencion a: atenciones){
                if (a.getCita().getFecha().equals(s)){
                at=a;
            } 
            }break;
            } 
    
        
        
        }System.out.println(at);
    }
    //Sobreescritua del metodo toString
    @Override
    public String toString(){
        return "Atención: " + cita.toString();
    }
}
