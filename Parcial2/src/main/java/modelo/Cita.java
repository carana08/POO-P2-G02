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
import java.util.Scanner;
import java.util.ArrayList;

public class Cita {

    private static ArrayList<Cita> cita = new ArrayList<Cita>();
    private Cliente cliente;
    private Empleado empleado;
    private Servicio servicio;
    private String fecha;
    double duracionR;
    private String horaInicio;
    private String horaFin;//se crean las variables de la clase cita
    
    //Scanner
    transient Scanner sc = new Scanner(System.in);

    public void setFecha(String f) {
        fecha = f;
    }
    
    public void setDuracion(double d){
        duracionR = d;
    }
    public void setHoraInicio(String horaI) {
        horaInicio = horaI;
    }

    public void setHoraFin(String horaF) {
        horaFin = horaF;
    }
    
    public void setServicio(Servicio s){
        servicio = s;
    }
    
    public void setEmpleado(Empleado e){
        empleado = e;
    }

    public void setCita(ArrayList<Cita> cita) {
        this.cita = cita;
    }
    public void setCliente(Cliente c){
    this.cliente=c;}

    public String getFecha() {
        return fecha;
    }
    
    public double getDuracionR(){
        return duracionR;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public static ArrayList<Cita> getCita() {
        return cita;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }
    //getters y setters de las variables definidas
    public Cita(){}

    public Cita(Cliente c, Empleado e, Servicio s, String f, double duracionR, String h, String hf) {
        fecha = f;
        horaInicio = h;
        horaFin = hf;
        cliente = c;
        servicio = s;
        empleado = e;
        this.duracionR = duracionR;
    }

    public void crearCita(Cita citaA) {
       cita.add(citaA);
        }
        /*Comprueba si el empleado tiene cita en la fecha designada si la tiene muestra 
        que en esa fecha y hora ya hay una cita designada y en caso de no tener crea la cita*/
    

    public static void eliminarCita(String cedula) {
        //recorre cita para ver las citas de la cedula ingresada
        
        for(Cita citaR: cita){
        if((citaR.getCliente().getCedula()).equals(cedula)){
            System.out.println(citaR);
        }}
        String salida = "SI";
        do {
            
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese fecha de cita a eliminar");
            String ingresoF = sc.nextLine();
            System.out.println("Ingrese hora de cita a eliminar");
            String ingresoH = sc.nextLine();
            Cita citaA= new Cita();
            for (Cita citaR : cita){ 
                if((citaR.getCliente().getCedula()).equals(cedula)&&(ingresoF.equals(citaR.getFecha())) &&(ingresoH.equals(citaR.getHoraInicio()))){
                citaA=citaR;
                }
                // 
                
            //&&(ingresoF.equals(citaR.getFecha())) &&(ingresoH.equals(citaR.getHoraInicio()))) {
                //citaA=citaR;
                
            }
            cita.remove(citaA);
            System.out.println("¿Desea seguir eliminando citas?, escriba si para continuar o no para para salir: ");
            String ingresoS = sc.nextLine();
            if (ingresoS.toUpperCase().equals("NO")) {
                salida = "NO";
            }
        } while (salida.equals("SI"));
    }

    public static void consultarCitaPorFecha(String fecha) {  
        for(Cita citaR:Cita.getCita()){
            if(fecha.equals(citaR.getFecha())){
              System.out.println(citaR);  }
        }}
   
    //Sobreescritura metodo toString
    @Override
    public String toString(){
        return "Fecha cita: " +this.getFecha() + "\nHora inicio: " + this.getHoraInicio() +" \nDatos del Cliente: " + this.getCliente().toString() + "\nSERVICIO:" + this.getServicio().toString() +"\nDatos del Empleado:" + this.getEmpleado().toString() + "\nDuracion de la cita en horas:" + this.getDuracionR();
    }
    
    //Nuevos métodos
    public static void crearArchivoCitas(){
        try(ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(Constantes.rutaCitas))){
            ArrayList<Cita> listaRegistros = new ArrayList<>();
            escritor.writeObject(listaRegistros);
            escritor.flush();
            
            
        }catch(IOException e){
            e.printStackTrace();}
        catch(Exception e){
            System.out.println("-------Excepcion general--------");
        }
    
    }
    
    public static ArrayList<Cita> cargarCita(){
        ArrayList<Cita> listaRetorno  = new ArrayList<>();
        
        try(ObjectInputStream lector = new ObjectInputStream(new FileInputStream(Constantes.rutaCitas))) {
            listaRetorno = (ArrayList<Cita>)lector.readObject();   
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
    public static void registrarCita(Cita c){
        ArrayList<Cita>listaActualizada = cargarCita();
        listaActualizada.add(c);
        try(ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(Constantes.rutaCitas))) {
            escritor.writeObject(listaActualizada);
        }
        
        catch (IOException ex){
            ex.printStackTrace();
        }
    
    }

}
