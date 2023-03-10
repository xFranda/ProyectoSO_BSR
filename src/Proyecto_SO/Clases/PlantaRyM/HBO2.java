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
    
    public static int capitulos; 
    
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
     public static ArrayList<Ensamblador> ensambladorLista = new ArrayList<>();
     
     //Drive de cada parte 
     
     public Drive driveIntros; 
     public Drive driveInicio;
     public Drive driveCred; 
     public Drive driveCierre;
     public Drive drivePlot;
     
     Semaphore Reloj = new Semaphore(1);

    
   
     
    public void start(){
        duracionDia = 4000;
        
        driveIntros = new Drive(30, 0 ); 
        driveInicio = new Drive(50, 0 );     
        driveCred = new Drive(25, 0 ); 
        driveCierre = new Drive(55, 0 ); 
        drivePlot = new Drive(40, 0 );         
        
        PM hola = new PM(Reloj);  
        hola.start();
        
        cantidadIntro =0; 
        cantidadInicio =0; 
        cantidadCreditos =0; 
        cantidadCierre =0; 
        cantidadPTwist =0; 
        
        capitulos = 0; 
        cantidadMaxProductores = 19; 
        
        
        // Gebrayel estos son pruebas de la capacidad en el Drive por favor no las veas que estan horribles
        
        cierresProducciones.add(new ProductorCierre(driveCierre, ECierre, cierreProd, cierre ) );
        cierresProducciones.get(0).start();
       
  
       openingProducciones.add(new ProductorInicio(driveInicio, EInicio, iniProd, ini ) );
       openingProducciones.get(0).start(); 
        
        
       
        introProducciones.add(new ProductorIntro(driveIntros, EIntro, intrProd, intr ) );
        introProducciones.get(0).start(); 
        
        
        creditosProducciones.add(new ProductorCreditos(driveCred, ECred, credProd, cred ) );
        creditosProducciones.get(0).start(); 

        twistProducciones.add(new ProductorPTwist(drivePlot, EPlot, ptwistProd, ptwist ) );
        twistProducciones.get(0).start(); 
       
        
    

        ensambladorLista.add(new Ensamblador(intr, ini, ptwist, cierre, cred, EIntro, EInicio, EPlot, ECred, ECierre, 
                intrProd, iniProd, ptwistProd, credProd, cierreProd, driveIntros, driveInicio, driveCred, driveCierre, drivePlot,
                true, 0));
       ensambladorLista.get(0).start();
       
       
       
    } 
}

     
    

     
    
   

