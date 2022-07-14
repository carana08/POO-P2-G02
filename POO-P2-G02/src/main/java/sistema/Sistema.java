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

    public void iniciarSistema() {
        Scanner sc = new Scanner(System.in);
        int ingreso;
        do {
            System.out.println("Bienvenido al Centro de Terapias Therapy \nElija la opción que desea del siguiente Menú \n 1.Servicios \n 2.Empleados \n 3.Clientes \n 4.Cita \n 5.Atención \n 6.Salir");
            ingreso = sc.nextInt();
            switch (ingreso) {
                case 1: {
                    System.out.println("");
                    break;
                }
                //System.out.println(Servicios.getArregloS());
                case 2: {
                    System.out.println("");
                    //System.out.println(Empleados.getArregloE());
                    break;
                }
                case 3: {
                    for (Cliente c : Cliente.getArregloC()) {
                        System.out.println("Cliente");
                        System.out.println(c);
                    }
                    break;
                }
                case 4: {
                    for (Cita c : Cita.getCita()) {
                        System.out.println("Cita");
                        System.out.println(c.getCliente() + ", " + c.getEmpleado() + ", " + c.getFecha() + " " + c.getHoraInicio());
                    }
                    break;
                }
                case 5: {
                    System.out.println("");
                    break;
                }
                //System.out.println(Atencion.getAtencion());
                case 6: {
                    System.out.println("Salinedo del Menú");
                    break;
                }
            }

        } while (ingreso != 6);
    }

    public static void main(String[] args) {
        //Servicio s =new Servicio();
        Cliente c1 = new Cliente("Jose", "Cordova", "1203296213", "0986808147", "jose@hotmail.com", "Madre");
        //Empleado e = new Empleado("Inactivo","Miguel", "Ochoa", "12032884843", "098687454", "jose@hotmail.es");
        //Cita.crearCita("15-07-2022","15:25",c1,s,e);
        Cliente.agregarCliente("Jose", "Cordova", "1203296213", "0986808147", "jose@hotmail.com", "Madre");
        Sistema s = new Sistema();
        s.iniciarSistema();
    }
}
