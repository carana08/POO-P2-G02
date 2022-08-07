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

    Empleado e = new Empleado("Juan", "Flores", "0958164865", "0952564444", "juanflores@hotmail.com", "Activo");

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
                    System.out.println("Servicios Ofrecidos en Therapy: ");
                    for (Servicio s : Servicio.getServicios()) {
                        System.out.println(s);//quitar linea de sout("Servicios")
                    }
                    System.out.println("Ingrese la opcion de lo que quiere hacer: \n 1. Agregar Servicio \n 2.Editar Servicio \n 3.Eliminar Servicio \n 4.Salir al Menú principal");
                    int ingresoS = sc.nextInt();
                    sc.nextLine();
                    switch (ingresoS) {
                        case 1: {
                            System.out.print("Ingrese el nombre del servicio: ");
                            String nombreS = sc.nextLine();
                            System.out.print("Ingrese estado del servicio: ");
                            String estadoS = sc.nextLine();
                            System.out.print("Ingrese duracion del servicio: ");
                            int duracionS = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Ingrese precio del servicio: ");
                            double precioS = sc.nextDouble();
                            sc.nextLine();
                            Servicio servicio = new Servicio(nombreS, estadoS, duracionS, precioS);
                            Servicio.agregarServicio(servicio);
                            System.out.println("Servicio Agregado");
                            break;
                        }
                        case 2: {
                            System.out.println("Ingrese nombre del servicio");
                            String nombreS = sc.nextLine();
                            Servicio servicio = new Servicio();
                            for (Servicio servicioR : Servicio.getServicios()) { 
                                if (nombreS.equals(servicioR.getNombreServicio())) {
                                    servicio = servicioR;
                                }
                                
                            }servicio.editarServicio(servicio);
                            break;
                        }
                        case 3: {
                            System.out.println("Ingrese nombre del servicio");
                            String nombreS = sc.nextLine();
                            Servicio servicio = new Servicio();
                            for (Servicio servicioR : Servicio.getServicios()) {
                                if (nombreS.equals(servicioR.getNombreServicio())) {
                                    servicio = servicioR;
                                }servicio.eliminarServicio(servicio);
                                System.out.println("Eliminando servicio");
                                
                            }
                            break;
                        }
                        case 4: {
                            System.out.println("Saliendo del Menú de Servicios");
                        }

                    }

                    break;
                }//Muestra al usuario los servicios ofrecidos por el centro y el menú de servicios

                case 2: {
                    for (Empleado c : Empleado.getEmpleados()) {
                        System.out.println("Empleados");
                        System.out.println(c);
                    }
                    System.out.println("Ingrese la opcion de lo que quiere hacer: \n 1. Agregar Empleado \n 2.Editar Empleado \n 3.Eliminar Empleado \n 4.Salir al Menú principal");
                    int ingresoE = sc.nextInt();
                    sc.nextLine();
                    switch (ingresoE) {
                        case 1: {
                            System.out.print("Ingrese el nombre del Empleado: ");
                            String nombreE = sc.nextLine();
                            System.out.print("Ingrese apellido del Empleado: ");
                            String ApellidoE = sc.nextLine();
                            System.out.println("Ingrese cédula del Empleado: ");
                            String cedulaE = sc.nextLine();
                            System.out.println("Ingrese teléfono del Empleado: ");
                            String telefonoE = sc.nextLine();
                            System.out.println("Ingrese email del Empleado: ");
                            String emailE = sc.nextLine();
                            System.out.println("Ingrese estado del Empleado");
                            String estadoE = sc.nextLine();
                            Empleado empleado = new Empleado(nombreE, ApellidoE, cedulaE, telefonoE, emailE, estadoE);
                            Empleado.agregarEmpleado(empleado);
                            System.out.println("Empleado Agregado");
                            break;
                        }

                        case 2: {
                            System.out.println("Ingrese cédula del Empleado");
                            String cedulaE = sc.nextLine();
                            Empleado empleado = new Empleado();
                            for (Empleado empleadoR : Empleado.getEmpleados()) {
                                if (cedulaE.equals(empleadoR.getCedula())) {
                                    empleado = empleadoR;
                                }
                                empleado.editarEmpleado(empleado);
                            }
                            break;
                        }
                        case 3: {
                            System.out.println("Ingrese cedula del Empleado");
                            String cedulaE = sc.nextLine();
                            Empleado empleado = new Empleado();
                            for (Empleado empleadoR : Empleado.getEmpleados()) {
                                if (cedulaE.equals(empleadoR.getCedula())) {
                                    empleado = empleadoR;
                                }
                                empleado.eliminarEmpleado(empleado);
                                System.out.println("Eliminando servicio");
                            }
                            break;
                        }
                        case 4: {
                            System.out.println("Saliendo del Menú de Empleado");
                        }

                    }

                    break;
                }
                //Muesta al usuario la informacion de los empleados del centro
                case 3: {
                    for (Cliente c : Cliente.getArregloC()) {
                        System.out.println("Clientes");
                        System.out.println(c);
                    }
                    System.out.println("Ingrese la opcion de lo que quiere hacer: \n 1. Agregar Cliente \n 2.Editar Cliente \n 3.Salir al Menú principal");
                    int ingresoE = sc.nextInt();
                    sc.nextLine();
                    switch (ingresoE) {
                        case 1: {
                            System.out.print("Ingrese el nombre del Cliente: ");
                            String nombreC = sc.nextLine();
                            System.out.print("Ingrese apellido del Cliente: ");
                            String ApellidoC = sc.nextLine();
                            System.out.println("Ingrese cédula del Cliente: ");
                            String cedulaC = sc.nextLine();
                            System.out.println("Ingrese teléfono del Cliente: ");
                            String telefonoC = sc.nextLine();
                            System.out.println("Ingrese email del Cliente: ");
                            String emailC = sc.nextLine();
                            System.out.println("Ingrese datos del representante del Cliente");
                            String datosC = sc.nextLine();
                            Cliente cliente = new Cliente(nombreC, ApellidoC, cedulaC, telefonoC, emailC, datosC);
                            Cliente.agregarCliente(cliente);
                            System.out.println("Cliente Agregado");
                            break;
                        }

                        case 2: {
                            System.out.println("Ingrese cédula del Cliente");
                            String cedulaC = sc.nextLine();
                            Cliente cliente= new Cliente();
                            for (Cliente clienteR : Cliente.getArregloC()) {
                                if (cedulaC.equals(clienteR.getCedula())) {
                                    cliente = clienteR;
                                }
                                
                            }cliente.editarCliente();
                            break;
                        }
                        
                        
                        case 3: {
                            System.out.println("Saliendo del Menú de Cliente");
                        }

                    }
                    break;
                }//Muesta al usuario la informacion de los clientes del centro
                case 4: {
                    System.out.println("1.Crear Cita\n" + "2.Eliminar Cita\n" + "3.Consultar citas por fecha");
                    int in = sc.nextInt();
                    sc.nextLine();
                    /*Con el valor del ingreso mediante switch se ejecutara la opcion relacionada*/
                    switch (in) {
                        case 1: {
                            /*Si la opcion es 1 se pedira el ingreso de los atributos necesarios 
                            para poder crear la cita en el caso de cliente y empleado
                            se pedira el ingreso de la cedula para verficarla en el sistema*/
                            System.out.print("Ingrese la fecha de la cita con el formato dd/mm/aaaa: ");
                            String fecha = sc.nextLine();
                            System.out.print("Ingrese la hora de la cita hh:mm: ");
                            String hora = sc.nextLine();
                            System.out.print("Ingrese la cedula del cliente: ");
                            String cedula = sc.nextLine();
                            Cliente c = new Cliente();
                            int agregado = 0;
                            int agregado2=0;
                            String m1 = "";
                            String m2 = "";
                            for (Cliente cliente : Cliente.getArregloC()) {
                                if (cedula.equals(cliente.getCedula())) {
                                    c = cliente;
                                    agregado=1;
                                    
                                }
                            }if(agregado==0){
                                m1= "Cedula no esta en la lista de cliente";
                            System.out.println(m1);}
                            if(!(m1.equals("Cedula no esta en la lista de cliente"))){
                            System.out.print("Ingrese la cedula del empleado: ");
                            
                            String cedulaE = sc.nextLine();
                            Empleado e = new Empleado();
                            int igualdad = 0;
                            for (Empleado empleado : Empleado.getEmpleados()) {
                                if (cedulaE.equals(empleado.getCedula())) {
                                    e = empleado;
                                    agregado2=1;
                                } 
                            }if(agregado2==0){
                            m2="Cedula no esta en la lista de Empleados";
                                System.out.println(m2);
                            }
                            }
                            if(!(m1.equals("Cedula no esta en la lista de cliente"))&&!(m2.equals("Cedula no esta en la lista de Empleados"))){
                            System.out.print("Ingrese el servicio: ");
                            String servicio = sc.nextLine();
                            Servicio s = new Servicio();
                            for (Servicio servi : Servicio.getServicios()) {
                                if ( (servicio.toLowerCase().equals(servi.getNombreServicio())) || (servicio.toUpperCase().equals(servi.getNombreServicio()))) {
                                    s = servi;
                                } 
                            }
                            for(Cita citaR:Cita.getCita()){
        if(citaR.getEmpleado().equals(e)&&citaR.getFecha().equals(fecha)&& citaR.getHoraInicio().equals(hora)){
            
        
        }
        else{
        
        
        }
        }
                            Cita cita = new Cita(fecha, hora, c, s, e, s.getDuracionServicio());
                            cita.crearCita(cita);
                            System.out.println("Cita Agregada");
                        }}
                        break;
                        /*Si la opcion es 2 pedira la cedula del cliente para elimar la cita*/
                        case 2: {
                            System.out.print("Ingrese la cedula del Cliente: ");
                            String cedula = sc.nextLine();
                            //Cita c = new Cita();
                            Cita.eliminarCita(cedula);
                        }
                        break;
                        /*Si la opcion es 3 mostrara las citas en la fecha ingresada por el usuario*/
                        case 3: {
                            System.out.print("Ingrese la fecha a consultar dd/mm/aaaa: ");
                            String fecha = sc.nextLine();
                            Cita.consultarCitaPorFecha(fecha);}break;
                            
                        
                    }}
                
                break;//Muestra al usuario el submenu de Cita;
                case 5: {

                    System.out.println("1.Registar Atencion\n" + "2.Consultar Atencion");
                    int in = sc.nextInt();
                    sc.nextLine();
                    switch (in) {
                        case 1: {
                            System.out.println("Ingrese la cedula del Cliente: ");
                            String cedulaC = sc.nextLine();
                            System.out.println("Ingrese fecha de la Cita: ");
                            String fecha = sc.nextLine();
                            Cita citaC = new Cita();
                            System.out.println("Ingrese cedula de empleado: ");
                            String cedulaE = sc.nextLine();
                            Servicio servicio = new Servicio();
                            Empleado empleado = new Empleado();
                            for (Cita cita : Cita.getCita()) {
                                if ((cedulaC.equals(cita.getCliente().getCedula())) && (cedulaE.equals(cita.getEmpleado().getCedula())) && (fecha.equals(cita.getFecha()))) {
                                    citaC = cita;
                                    empleado = cita.getEmpleado();
                                    servicio = cita.getServicio();
                                } else if (cedulaE.equals(cita.getEmpleado())) {
                                    citaC = cita;
                                    empleado = cita.getEmpleado();
                                    servicio = cita.getServicio();
                                }
                            }
                            System.out.println("Ingrese duracion de la cita");
                            int duracion = sc.nextInt();
                            sc.nextLine();
                            Atencion atencion = new Atencion(citaC);
                            atencion.registrarAtencion(atencion);
                            System.out.println("Atencion Registrada");
                            break;
                        }
                        case 2: {
                            //System.out.println("Para consultar la atencion ingrese la cedula del cliente , cedula de empleado o la fecha");
                            //String ingresoD= sc.nextLine();
                            Atencion.consultarAtencion();

                            break;
                        }
                    }

                    break;
                }

                //Muesta al usuario el submenu de Atencion
                case 6: {
                    System.out.println("Saliendo del Menú");
                    break;
                }//Hace que el usuario salga del programa

            }

        } while (ingreso
                != 6);
    }

    public static void main(String[] args) {
        //Servicio s =new Servicio();
        Empleado e = new Empleado("Miguel", "Ochoa", "12032884843", "098687454", "jose@hotmail.es", "Inactivo");
        Cliente c1 = new Cliente("Maria", "Perez", "09998225553", "0996955651", "mariaperez@hotmail.com", "Papá de Maria");
        Cliente c2 = new Cliente("Pedro", "Coronel", "0909951111", "0984786321", "pedrocoronel@hotmail.com", "Mamá de Pedro");
        //Se crean 3 servicios
        Servicio s1 = new Servicio("terapia de lenguaje", "Activo", 1, 23.0f);
        Servicio s2 = new Servicio("terapia de psicopedagogica", "Activo", 2, 22.5f);
        Servicio s3 = new Servicio("terapia lenguaje 2", "Activo", 3, 20.0f);
        Cita cita1 = new Cita("15/07/2022", "16:00", c1, s1, e, 0);
        Cita cita2 = new Cita("16/07/2022", "15:00", c2, s2, e, 0);
        cita1.crearCita(cita1);
        
        //cita2.crearCita(cita2);
        System.out.println(Cita.getCita());
        //Cita.crearCita("15-07-2022","15:25",c1,s,e);
        //System.out.println(s1);
       Atencion a = new Atencion(cita1);
        a.registrarAtencion(a);
        System.out.println(" ");
        System.out.println(Atencion.getAtenciones());
        Cliente.agregarCliente(c1);
        Cliente.agregarCliente(c2);
        Sistema s = new Sistema();
        Empleado.agregarEmpleado(e);
        Servicio.agregarServicio(s1);
        Servicio.agregarServicio(s2);
        Servicio.agregarServicio(s3);
        
        //System.out.println(Servicio.getServicios());

        s.inicializarSistema();

    }
}
