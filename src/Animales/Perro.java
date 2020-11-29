/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animales;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author UserPC
 */
public class Perro extends Animal {
    private Tamano tamanio;
    
    public Perro(LocalDate fechaIngreso,String nombre, String raza, Sexo sexo,  int edad, double peso, ArrayList<String> observaciones,int codigo, String estado,Tamano tamano){
        super(fechaIngreso, nombre, raza, sexo,edad,peso,observaciones,codigo,estado);
        this.tamanio=tamanio;
    }

    public Tamano getTamanio() {
        return tamanio;
    }
    
    
    
}
