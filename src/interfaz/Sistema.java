/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import Empleados.Administrador;
import Empleados.Empleado;
import Empleados.Funcionario;
import Fundacion.Fundacion;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Personal
 */
 
public class Sistema {
   private Scanner sc;
   private Fundacion fd;
    
    public Sistema(){
       sc = new Scanner(System.in);
       fd = new Fundacion();
    }
    
    public void presentarMenuFuncionario(){
        String respuesta = "";
        System.out.println("Bienvenido/a al menú FUNCIONARIO de la  fundación Amigo de cuatro patas! ");
        System.out.println("Escoja una opcion: ");
        System.out.println("1. Registrar nuevo animal");
        System.out.println("2. Consultar animales en la fundacion");
        System.out.println("3. Registrar interesado adopcion");
        System.out.println("4. Registrar adopcion");
        System.out.println("5. Consultar adopciones");
        System.out.println("6. Consultar adoptantes");
        System.out.println("7. Cerrar sesion");
        String opcion = sc.nextLine();
        switch (opcion){
            case "1":
                fd.registrarAnimal();
                System.out.println("¿Desea regresar al menú principal?(si/no)");
                respuesta = sc.nextLine();
                if (respuesta.toLowerCase().equals("si")){
                    presentarMenuFuncionario();
                }else{
                    break;
                }    
            case "2":
                fd.consultarAnimal();
                System.out.println("¿Desea regresar al menú principal?(si/no)");
                respuesta = sc.nextLine();
                if (respuesta.toLowerCase().equals("si")){
                    presentarMenuFuncionario();
                }else{
                    break;
                    }
            case "3":
                fd.registrarAdoptante();
                System.out.println("¿Desea regresar al menú principal?(si/no)");
                respuesta = sc.nextLine();
                if (respuesta.toLowerCase().equals("si")){
                    presentarMenuFuncionario();
                }else{
                    break;
                    }
            case "4":
                fd.registrarAdopciones();
                System.out.println("¿Desea regresar al menú principal?(si/no)");
                respuesta = sc.nextLine();
                if (respuesta.toLowerCase().equals("si")){
                    presentarMenuFuncionario();
                }else if(respuesta.toLowerCase().equals("no")){
                    break;
                 }
            case "5":
                fd.consultarAdopciones();
                System.out.println("¿Desea regresar al menú principal?(si/no)");
                respuesta = sc.nextLine();
                if (respuesta.toLowerCase().equals("si")){
                    presentarMenuFuncionario();
                }else{
                    break;
                    }
            case "6":
                fd.consultarAdoptante();
                System.out.println("¿Desea regresar al menú principal?(si/no)");
                respuesta = sc.nextLine();
                if (respuesta.toLowerCase().equals("si")){
                    presentarMenuFuncionario();
                }else{
                    break;
                    }
            case "7":
                System.out.println("Se ha cerrado la sesión");
                iniciarSistema();
                break;
        }           
    }
    
    public void presentarMenuAdministrador(){
        String respuesta = "";
        System.out.println("Bienvenido/a al menú ADMINISTRADOR de la  fundación Amigo de cuatro patas! ");
        System.out.println("Escoja una opcion: ");
        System.out.println("1. Registrar empleados");
        System.out.println("2. Consultar y registrar veterinaria");
        System.out.println("3. Consultar y registrar gasto veterinaria");
        System.out.println("4. Consultar presupuesto mensual");
        System.out.println("5. Enviar correo interesados");
        System.out.println("6. Cerrar sesion");
        String opcion = sc.nextLine();
        switch(opcion){
            case "1":
                fd.registrarEmpleado();
                System.out.println("¿Desea regresar al menú principal?(si/no)");
                respuesta = sc.nextLine();
                if (respuesta.toLowerCase().equals("si")){
                    presentarMenuAdministrador();
                }else if(respuesta.toLowerCase().equals("no")){
                    break;
                }
            case "2":
                fd.CyRVeterinarias();
                System.out.println("¿Desea regresar al menú principal?(si/no)");
                respuesta = sc.nextLine();
                if (respuesta.toLowerCase().equals("si")){
                     presentarMenuAdministrador();
                }else if(respuesta.toLowerCase().equals("no")){
                    break;
                }    
            case "3":
                fd.CyRGastoVeterinaria();
                System.out.println("¿Desea regresar al menú principal?(si/no)");
                respuesta = sc.nextLine();
                if (respuesta.toLowerCase().equals("si")){
                     presentarMenuAdministrador();
                }else if(respuesta.toLowerCase().equals("no")){
                    break;
                }
            case "4":
                fd.calcularPresupuestoMensual();
                System.out.println("¿Desea regresar al menú principal?(si/no)");
                respuesta = sc.nextLine();
                if (respuesta.toLowerCase().equals("si")){
                    presentarMenuAdministrador();
                }else if(respuesta.toLowerCase().equals("no")){
                    break;
                }
            case "5":
                fd.enviarCorreo();
                 System.out.println("¿Desea regresar al menú principal?(si/no)");
                respuesta = sc.nextLine();
                if (respuesta.toLowerCase().equals("si")){
                     presentarMenuAdministrador();
                }else if(respuesta.toLowerCase().equals("no")){
                    break;
                }
            case "6":
                System.out.println("Se ha cerrado la sesión.");
                iniciarSistema();
                break;

        }
    
    }
public void iniciarSistema(){
        System.out.println("Ingrese su usuario y contraseña");
        System.out.println("Usuario:");
        String usuario = sc.nextLine();
        System.out.println("Contraseña:");
        String contrasena = sc.nextLine();
        
        ArrayList<Empleado> empleados = fd.getEmpleados();
       
        boolean cond = true;
       while(cond==true){ 
           for(Empleado e : empleados){
               if(e.getUsuario().equals(usuario) && e.getContrasena().equals(contrasena)){
                     cond=false;
                     if(e instanceof Funcionario){
                         presentarMenuFuncionario();
                     }
                     else{
                        presentarMenuAdministrador();
                     }
                break;
              }
        }
           if(cond==true){
               System.out.println("Contraseña o usuarios Inválidos, vuelva a ingresar");
               System.out.println("Ingrese su usuario y contraseña");
               System.out.println("Usuario:");
               usuario = sc.nextLine();
               System.out.println("Contraseña:");
               contrasena = sc.nextLine();
            }             
        
        }     
    }
    
    
    
}
