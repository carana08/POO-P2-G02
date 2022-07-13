/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author César
 */
import java.util.Scanner;
import java.util.ArrayList;
public class Cita{
  private static ArrayList<Cita> cita;
  private Cliente cliente;
  private Empleado empleado;
  private Servicio servicio;
  private String fecha;
  private String horaInicio;
  private String horaFin;//se crean las variables de la clase cita
  public void setFecha(String f){
    fecha=f;
  }
  public void setHoraInicio(String horaI){
    horaInicio=horaI;
  }
  public void setHoraFin(String horaF){
    horaFin=horaF;
  }
  public void setCita(ArrayList<Cita> cita){
    this.cita=cita;
  }
  public String getFecha(){
    return fecha;
  }
  public String getHoraInicio(){
    return horaInicio;
  }
  public String getHoraFin(){
    return horaFin;
  }
  public ArrayList<Cita> getCita(){
    return cita;
  }
  public Servicio getServicio(){
    return servicio;
  }
  public Empleado getEmpleado(){
    return empleado;
  }
  public Cliente getCliente(){
    return cliente;
  }
  //getters y setters de las variables definidas
  
  public Cita(String f,String h, Cliente c, Servicio s,Empleado e){
  fecha= f;
  horaInicio=h; 
  cliente = c;
  servicio=s;
  empleado=e;
  }
  public void crearCita(String f,String h, Cliente c, Servicio s,Empleado e)
  {
    if(cita.size()==0){
      cita.add(new Cita(f,h,c,s,e));
    }// si el arreglo no tiene citas agregara sin problemas la cita
    else{
    for(Cita citaR: cita){//la varibale de la instancia for citaR que hace referencia a que va a recorrer el arreglo cita
    boolean comprobacion = citaR.getEmpleado().equals(e)&& citaR.getFecha().equals(f)&&citaR.getHoraInicio().equals(h); 
      if(comprobacion){
      System.out.println("Creacion invalida el empleador ya tiene cita designada a esta fecha y hora");  
      }
    else {
      cita.add(new Cita(f,h,c,s,e));
    }
    }}/*Comprueba si el empleado tiene cita en la fecha designada si la tiene muestra que en esa fecha y hora ya hay una cita designada y en caso de no tener crea la cita*/
  }
  public void eliminarCita(String cedula){
    for(Cita citaR: cita){
      if(citaR.getCliente().getCedula().equals(cedula)){
        System.out.println(citaR);
      }
    }//recorre cita para ver las citas de la cedula ingresada
    String salida = "SI";
    do{
      Scanner sc = new Scanner(System.in);
      System.out.println("Ingrese cita a eliminar");
      String ingreso = sc.nextLine();
      cita.remove(cita.indexOf(ingreso));
      System.out.println("Desea seguir eliminando citas");
      String ingresoS = sc.nextLine();
      if(ingreso.toUpperCase().equals("SI")){
      salida="NO";
      }
    }while(salida.equals("SI"));
  }
  public void consultarCitaPorFecha(String fecha){
    for(Cita citaR: cita){
      if(citaR.getFecha().equals(fecha)){
        System.out.println(citaR);
      }
    }
  }

}