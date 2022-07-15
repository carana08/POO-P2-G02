/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

/**
 *
 * @author César
 */
import modelo.*;
import java.util.Scanner;
import java.util.Arrays;

public class Sistema {

    public void inicializarSistema() {
        // Se crea inicializarSistema
        Scanner sc = new Scanner(System.in);
        int ingreso;
        do {
            /*Se implementa un do while pra mostrar al usuario el menu de seleccion hasta que el mismo
            seleccione la opcion de salir*/
            System.out.println("Bienvenido al Centro de Terapias Therapy \nElija la opción que desea del siguiente Menú \n 1.Servicios \n 2.Empleados \n 3.Clientes \n 4.Cita \n 5.Atención \n 6.Salir");
            ingreso = sc.nextInt();
            switch (ingreso) {
                /*Se implementa switch con las posibles opciones que se pueden dar dependiendo de la
                seleccion del usuario*/
                case 1: {
                        System.out.println("Servicios Ofrecidos en Therapy: \n Terapia de Lenguaje \n Terapia Psicopedagógica");
                        
                    
                    break;
                }//Muestra al usuario los servicios ofrecidos por el centro
              
                case 2: {
                    for (Empleado c : Empleado.getEmpleados()){
                        System.out.println("Empleados");
                        System.out.println(c);
                    }
                    break;
                }//Muesta al usuario la informacion de los empleados del centro
                case 3: {
                    for (Cliente c : Cliente.getArregloC()) {
                        System.out.println("Clientes");
                        System.out.println(c);
                    }
                    break;
                }//Muesta al usuario la informacion de los clientes del centro
                case 4: {
                    System.out.println("1.Crear Cita\n" +"2.Eliminar Cita\n" +"3.Consultar citas por fecha");
                    int in= sc.nextInt();
                    sc.nextLine();
                    /*Con el valor del ingreso mediante switch se ejecutara la opcion relacionada*/
                    switch(in){
                        case 1:{
                            /*Si la opcion es 1 se pedira el ingreso de los atributos necesarios 
                            para poder crear la cita en el caso de cliente y empleado
                            se pedira el ingreso de la cedula para verficarla en el sistema*/
                            System.out.print("Ingrese la fecha de la cita: ");
                            String fecha = sc.nextLine();
                            System.out.print("Ingrese la hora de la cita: ");
                            String hora=sc.nextLine();
                            System.out.print("Ingrese la cedula del cliente: ");
                            String cedula = sc.nextLine();
                            Cliente c=new Cliente();
                            for(Cliente cliente:Cliente.getArregloC()){
                            if(cedula.equals(cliente.getCedula())){
                            c=cliente;
                            }
                            else{
                                System.out.println("Cedula no esta en la lista de cliente");
                            c=null;}
                            }
                            System.out.print("Ingrese la cedula del empleado: ");
                            String cedulaE = sc.nextLine();
                            Empleado e=new Empleado();
                            for(Empleado empleado:Empleado.getEmpleados()){
                            if(cedula.equals(empleado.getCedula())){
                            e=empleado;
                            }
                            else{
                                System.out.print("Cedula no esta en la lista de Empleados");
                            e=null;}
                            }
                            System.out.print("Ingrese el servicio: ");
                            String servicio = sc.nextLine();
                            Servicio s=new Servicio();
                            for(Servicio servi : Servicio.getServicios() ){
                            if(((servicio.substring(0, 1).toUpperCase() + servicio.substring(1)).equals(servi.getNombreServicio()))||(servicio.toLowerCase().equals(servi.getNombreServicio()))||(servicio.toUpperCase().equals(servi.getNombreServicio()))){
                             s=servi;   
                            }
                            else{
                                System.out.println("Servicio no disponible en el Consultorio ");
                            s=null;}}
                            Cita.crearCita(fecha, hora, c, s, e, 0.0);
                            System.out.println(" ");
                        }break;
                        /*Si la opcion es 2 pedira la cedula del cliente para elimar la cita*/
                        case 2:{
                            System.out.print("Ingrese la cedula del Cliente: ");
                            String cedula = sc.nextLine();
                            Cita c=new Cita();
                            c.eliminarCita(cedula);
                        }break;
                        /*Si la opcion es 3 mostrara las citas en la fecha ingresada por el usuario*/
                        case 3:{
                            System.out.print("Ingrese la fecha a consultar: ");
                            String fecha = sc.nextLine();
                            Cita c=new Cita();
                            c.consultarCitaPorFecha(fecha);}break;
                    }
                    break;
                }//Muestra al usuario el submenu de Cita;
                case 5: {
                    
                      System.out.println("1.Registar Atencion\n" +"2.Consultar Atencion" );
                    int in= sc.nextInt();
                    sc.nextLine();
                    switch(in){
                        case 1:{
                            //Falta la creacion de la atencion y la consulta de atencion
                        //Atencion.
                        }
                    }
                    
                    }
                    break;
                    //Muesta al usuario el submenu de Atencion
                case 6: {
                    System.out.println("Salinedo del Menú");
                    break;
                }//Hace que el usuario salga del programa
                
            }
        } while (ingreso != 6);
    }

    public static void main(String[] args) {
        //Servicio s =new Servicio();
        Cliente c1 = new Cliente("Jose", "Cordova", "1203296213", "0986808147", "jose@hotmail.com", "Madre");
        Empleado e = new Empleado("Miguel", "Ochoa", "12032884843", "098687454", "jose@hotmail.es","Inactivo");
        //Cita.crearCita("15-07-2022","15:25",c1,s,e);
        Cliente.agregarCliente(c1);
        Sistema s = new Sistema();
        Empleado.agregarEmpleado(e);
        s.inicializarSistema();
        
    }
}
