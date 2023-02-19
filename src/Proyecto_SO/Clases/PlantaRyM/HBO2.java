/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_SO.Clases.PlantaRyM;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Gab
 */
public class HBO2 {
    
    // Limites empleados
    public static int cantidadMaxProductores; 
    public static int cantidadMaxProjectManager;
    public static int cantidadMaxEnsambladores;
    public static int cantidadDirectores;
    
    // Tiempo
    public static int duracionDia;
    
    // Numero de partes de episodio 
    public static int cantidadIntro;
    public static int cantidadInicio;
    public static int cantidadPTwist;
    public static int cantidadCierre;
    public static int cantidadCreditos;
    public static int cantidadMaxIntro;
    public static int cantidadMaxInicio;
    public static int cantidadMaxPTwist;
    public static int cantidadMaxCierre;
    public static int cantidadMaxCreditos;
    
    //Cantidad maxima de Productores
    
    public static int cantidadProdIntro; 
    public static int cantidadProdInicio; 
    public static int cantidadProdPTwist; 
    public static int cantidadProdCierre; 
    public static int cantidadProdCreditos; 
    
    //Cantidad de partes en Drive
    public static int dCantidadIntro;
    public static int dCantidadInicio;
    public static int dCantidadPTwist;
    public static int dCantidadCierre;
    public static int dCantidadCreditos;
   
    // Semaforos de productores

     static Semaphore intr = new Semaphore(1, true);
     static Semaphore ini = new Semaphore(1, true);
     static Semaphore ptwist = new Semaphore(1, true);
     static Semaphore cierre = new Semaphore(1, true);
     static Semaphore cred = new Semaphore(1, true);
     
     // Semaforos de PManager and Director
     
     
    
    
}
