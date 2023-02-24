/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_SO.Clases.PlantaRyM;

import Proyecto_SO.Dashboard;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import javax.swing.JOptionPane;


/**
 *
 * @author Gab
 */
public class HBO2 {
    
    Dashboard dashboard;
    //Cantidad episodios 
    
    public static int capitulos; 
    
    // Limites empleados
    public static int cantidadMaxProductores; 
    public static int cantidadMaxProjectManager;
    public static int cantidadMaxEnsambladores;
    public static int cantidadDirectores;
    
    // Tiempo
    public static int duracionDia;
    public static int limiteDia;
    
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
     
     Semaphore Capitulos = new Semaphore(1);
     
     public static int pGastos;
     public static int pGanancias; 
     
     public static ArrayList<Integer> infoDocumento = new ArrayList<>();


    
   
     
    public void start() throws FileNotFoundException, IOException{
        
        
        
         BufferedReader br = new BufferedReader(new FileReader("src/Proyecto_SO/Clases/PlantaRyM/DatosRM.txt"));       
        String line = null;
         while((line = br.readLine()) != null){
        String[] values = line.split(",");
         
        int[] intValues = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            try{
             intValues[i] = Integer.parseInt(values[i]);
             infoDocumento.add(intValues[i]);
    }catch (NumberFormatException nfe) {
        continue;
    }
            
        }  
         }
        

             br.close();            

    
    
        duracionDia = infoDocumento.get(0) * 4000;
        limiteDia = infoDocumento.get(1) * 1000;
      

        
        driveIntros = new Drive(30, infoDocumento.get(2)); 
        driveInicio = new Drive(50, infoDocumento.get(3));     
        driveCred = new Drive(25, infoDocumento.get(4)); 
        driveCierre = new Drive(55, infoDocumento.get(5) ); 
        drivePlot = new Drive(40, infoDocumento.get(6) );         
        
        
        pGanancias = 0; 
        pGastos = 0;
        cantidadIntro =0; 
        cantidadInicio =0; 
        cantidadCreditos =0; 
        cantidadCierre =0; 
        cantidadPTwist =0; 
        
        PM projectm = new PM(Reloj);  
        projectm.start();
        
        Director gab = new Director(Reloj, Capitulos);
        gab.start();
        
        Tiempo jimin = new Tiempo();
        GananciasRM yoongi = new GananciasRM(); 
        yoongi.start();
        
  
        
        capitulos = 0; 
        cantidadMaxProductores = 19; 
        
        
        // Gebrayel estos son pruebas de la capacidad en el Drive por favor no las veas que estan horribles
        
        cierresProducciones.add(new ProductorCierre(driveCierre, ECierre, cierreProd, cierre ) );
        cierresProducciones.get(infoDocumento.get(7)).start();
       
  
       openingProducciones.add(new ProductorInicio(driveInicio, EInicio, iniProd, ini ) );
       openingProducciones.get(infoDocumento.get(7)).start(); 
        
        
       
        introProducciones.add(new ProductorIntro(driveIntros, EIntro, intrProd, intr ) );
        introProducciones.get(infoDocumento.get(7)).start(); 
        
        
        creditosProducciones.add(new ProductorCreditos(driveCred, ECred, credProd, cred ) );
        creditosProducciones.get(infoDocumento.get(7)).start(); 

        twistProducciones.add(new ProductorPTwist(drivePlot, EPlot, ptwistProd, ptwist ) );
        twistProducciones.get(infoDocumento.get(7)).start(); 
       
        
    

        ensambladorLista.add(new Ensamblador(intr, ini, ptwist, cierre, cred, EIntro, EInicio, EPlot, ECred, ECierre, 
                intrProd, iniProd, ptwistProd, credProd, cierreProd, driveIntros, driveInicio, driveCred, driveCierre, drivePlot,
                true, 0));
       ensambladorLista.get(infoDocumento.get(7)).start();
       
       
      
      

               
    } 
    
    public void contratarProductorIntros() {
        int x = introProducciones.size();
    
   if (x < 19 ) { 
        
            introProducciones.add(new ProductorIntro(driveIntros, EIntro, intrProd, intr ) );
            introProducciones.get(x).start(); 
              System.out.println(introProducciones.get(x));
            

        
        }
    }

  
}    
        
        
        
        
        
        
        
     


     
    

     
    
   

