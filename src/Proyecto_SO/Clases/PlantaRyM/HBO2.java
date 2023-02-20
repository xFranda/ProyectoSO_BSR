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
    
    
    //Cantidad episodios 
    
    public int capitulos; 
    
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

     static Semaphore intr = new Semaphore(1, true);
     static Semaphore ini = new Semaphore(1, true);
     static Semaphore ptwist = new Semaphore(1, true);
     static Semaphore cierre = new Semaphore(1, true);
     static Semaphore cred = new Semaphore(1, true);
     
     // Semaforos de productores  

     static Semaphore intrProd = new Semaphore(1, true);
     static Semaphore iniProd = new Semaphore(1, true);
     static Semaphore ptwistProd = new Semaphore(1, true);
     static Semaphore cierreProd = new Semaphore(1, true);
     static Semaphore credProd = new Semaphore(1, true);
     
     // Semaforo de ensambladores
     
     Semaphore EIntro = new Semaphore(0);
     Semaphore EInicio = new Semaphore(0);
     Semaphore ECred = new Semaphore(0);
     Semaphore ECierre = new Semaphore(0);
     Semaphore EPlot = new Semaphore(0);
     
     
       
     // Salarios 
     
     public static int salarioIntro;
     public static int salarioInicio;
     public static int salarioPTwist;
     public static int salarioCierre;
     public static int salarioCreditos;
     
     //Listas de Productores y Ensambladores
     
     public static ArrayList<ProductorIntro> introProducciones = new ArrayList<>();
     public static ArrayList<ProductorInicio> openingProducciones = new ArrayList<>();
     public static ArrayList<ProductorCierre> cierresProducciones = new ArrayList<>();
     public static ArrayList<ProductorCreditos> creditosProducciones = new ArrayList<>();
     public static ArrayList<ProductorPTwist> twistProducciones = new ArrayList<>();
     
     //Drive de cada parte 
     
     Drive driveIntros; 
     Drive driveInicio;
     Drive driveCred; 
     Drive driveCierre;
     Drive drivePlot;
    
   
     
    public void start(){
        duracionDia = 1000;
        
        driveIntros = new Drive(30, 0 ); 
        driveInicio = new Drive(50, 0 );     
        driveCred = new Drive(25, 0 ); 
        driveCierre = new Drive(55, 0 ); 
        drivePlot = new Drive(40, 0 ); 
   
        
        
        cantidadIntro =0; 
        cantidadInicio =0; 
        cantidadCreditos =0; 
        cantidadCierre =0; 
        cantidadPTwist =0; 
        
        capitulos = 0; 
        cantidadMaxProductores = 19; 
        
        
        // Gebrayel estos son pruebas de la capacidad en el Drive por favor no las veas que estan horribles
        
        cierresProducciones.add(new ProductorCierre(driveCierre, cierreProd, cierre, ECierre ) );
        cierresProducciones.get(0).start(); 
       
       openingProducciones.add(new ProductorInicio(driveInicio, iniProd, ini, EInicio ) );
       openingProducciones.get(0).start(); 
        
        introProducciones.add(new ProductorIntro(driveIntros, intrProd, intr, EIntro ) );
        introProducciones.get(0).start(); 
        
        creditosProducciones.add(new ProductorCreditos(driveCred, credProd, cred, ECred ) );
        creditosProducciones.get(0).start(); 
        
        twistProducciones.add(new ProductorPTwist(drivePlot, ptwistProd, ptwist, EPlot ) );
        twistProducciones.get(0).start(); 
        
    } 
     
    

     
    
    
}
