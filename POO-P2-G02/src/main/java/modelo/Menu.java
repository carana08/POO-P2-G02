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
public class Menu {
    
    //Se crea un empleado
    Empleado e = new Empleado("Juan", "Flores", "0958164865", "0952564444", "juanflores@hotmail.com", "Activo");
    //Se crean dos cliientes
    private Cliente c1 = new Cliente("Maria", "Perez", "09998225553", "0996955651", "mariaperez@hotmail.com", "Papá de Maria");
    private Cliente c2 = new Cliente("Pedro", "Coronel", "0909951111", "0984786321", "pedrocoronel@hotmail.com", "Mamá de Pedro");
    //Se crean 3 servicios
    private Servicio s1 = new Servicio("Terapcia de Lenguaje", "Activo", "Tipo A", 1, 23.0f);
    private Servicio s2 = new Servicio("Terapia de Colores", "Activo", "Tipo A", 2, 22.5f);
    private Servicio s3 = new Servicio("Terapia Visual", "Activo", "Tipo B", 3, 20.0f);
    //Se crean 2 citas
    private Cita cita1 = new Cita("15/07/2022", "16:00", c1, s1, e, 0);
    private Cita cita2 = new Cita("16/07/2022", "15:00", c2, s2, e, 0);
    //Se crea 1 atencion
    private Atencion a = new Atencion(cita1);
    //Declaramos el Scanner
    Scanner sc = new Scanner(System.in);
    public void iniciarSistema(){
        System.out.println("Bienvenido al sistema del Centro de Terapias Therapy \nSeleccione su usuario: \n 1.Cliente \n 2.Empleado");
        int i = sc.nextInt();
        sc.nextLine();
        //Selecciona Cliente
        switch (i) {
            //Pedimos que desea hacer como Cliente
            case 1:
                System.out.println("Opciones para Clientes: \n 1.Informacion sobre registro \n 2.Edicion de datos");
                int e = sc.nextInt();
                sc.nextLine();
                switch (e){
                    System.out.println("Seleccione la información que desea \n 1.Cliente \n 2.Empleado \n 3.Servicio");
                    int o = nextInt();
                    sc.nextLine();
                    
                }
        //Selecciona empleado
            case 2:
                System.out.println("Opciones para Empleados; \n \\");
        }
    }
    public void salirSistema(){
        
    }
}
