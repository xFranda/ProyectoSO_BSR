/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_SO.Clases.PlantaRyM;

import java.util.ArrayList;
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
    public int cantidadIntro;
    public int cantidadInicio;
    public int cantidadPTwist;
    public int cantidadCierre;
    public int cantidadCreditos;
    public static int cantidadMaxIntro;
    public static int cantidadMaxInicio;
    public static int cantidadMaxPTwist;
    public static int cantidadMaxCierre;
    public static int cantidadMaxCreditos;
    
    //Cantidad maxima de Productores
    
    public int cantidadProdIntro; 
    public int cantidadProdInicio; 
    public int cantidadProdPTwist; 
    public int cantidadProdCierre; 
    public int cantidadProdCreditos; 
    
    //Cantidad de partes en Drive
    public int dCantidadIntro;
    public int dCantidadInicio;
    public int dCantidadPTwist;
    public int dCantidadCierre;
    public int dCantidadCreditos;
   
    // Semaforos de partes 

     static Semaphore intr = new Semaphore(cantidadMaxIntro, true);
     static Semaphore ini = new Semaphore(cantidadMaxInicio, true);
     static Semaphore ptwist = new Semaphore(cantidadMaxPTwist, true);
     static Semaphore cierre = new Semaphore(cantidadMaxCierre, true);
     static Semaphore cred = new Semaphore(cantidadMaxCreditos, true);
     
     // Semaforos de productores  

     static Semaphore intrProd = new Semaphore(1, true);
     static Semaphore iniProd = new Semaphore(1, true);
     static Semaphore ptwistProd = new Semaphore(1, true);
     static Semaphore cierreProd = new Semaphore(1, true);
     static Semaphore credProd = new Semaphore(1, true);
       
     // Salarios 
     
     public static int salarioIntro;
     public static int salarioInicio;
     public static int salarioPTwist;
     public static int salarioCierre;
     public static int salarioCreditos;
     
     //Listas de Productores y Ensambladores
     
     public static ArrayList<ProductorIntro> introProducciones = new ArrayList<>();
     public static ArrayList<ProductorIntro> openingProducciones = new ArrayList<>();
     public static ArrayList<ProductorCierre> cierresProducciones = new ArrayList<>();
     public static ArrayList<ProductorCreditos> creditosProducciones = new ArrayList<>();
     public static ArrayList<ProductorPTwist> twistProducciones = new ArrayList<>();
     
     
     
    public void start(){
        
    } 
     
     
    
    
}
