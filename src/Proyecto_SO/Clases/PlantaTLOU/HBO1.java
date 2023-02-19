/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto_SO.Clases.PlantaTLOU;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.concurrent.Semaphore;
import java.util.ArrayList;

/**
 *
 * @author frand
 */
public class HBO1 {
    
    //Atributos de la clase
    Drive driveIntros; //Creacion de buffer de intros
    Drive driveInicio;//Creacion de buffer de Inicio
    Drive driveCred;//Creacion de buffer de Creditos
    Drive driveCierre;//Creacion de buffer de Cierre
    Drive drivePlot;//Creacion de buffer de Plot
    
    
    public static int tiempoHora; // Tiempo que dura un dia en el programa
    public static int empleadosMax; // Cantidad maxima de empleados
    public static int directorMax;  // Cantidad maxima del director
    public static int ProyectMax; //Cantidad maxima del Proyect Manager
    
    
    //Datos a mostrar en el Dashboard
    public static int prodInicio; // Numero de productores de Inicio
    public static int prodIntro; // Numero de productores de Intros
    public static int prodCred; // Numero de productores de Creditos
    public static int prodCierre; // Numero de productores de Cierres
    public static int prodPlot; // Numero de productores de Plot
    public static int ensamblador; // Cantidad de ensambladores

    public static int DiaDuracion; //Duracion de un dia
    public static int DiasParaCorte; //Duracion de dias para el corte de comparacion
    public static int Inicio; // Numero de partes de Inicio
    public static int Intro; // Numero de partes de Intros
    public static int Cred; // Numero de partes de Creditos
    public static int Cierre; // Numero de partes de Cierres
    public static int Plot; // Numero de partes de Plot
    public static int CapituloTLOU; //Numero de capitulos listos de TLOU
    
    public static int inicioDrive; //Almacenamiento de Inicios en el Drive
    public static int introDrive; //Almacenamiento de Intros en el Drive
    public static int credDrive; //Almacenamiento de Creditos en el Drive
    public static int cierreDrive; //Almacenamiento de Cierres en el Drive
    public static int plotDrive; //Almacenamiento de Plot twist en el Drive
    
    public static ProductorIntro[] vecProductoresIntro;
    int PosVecIntro; 
    public static ProductorInicio[] vecProductoresInicio;
    int PosVecInicio;
    public static ProductorCred[] vecProductoresCred;
    int PosVecCred;
    public static ProductorCierre[] vecProductoresCierre;
    int PosVecCierre; 
    public static ProductorPlot[] vecProductoresPlot;
    int PosVecPlot; 
    public static Ensamblador[] vecEnsamblador;
    int PosVecEnsamblador; 
    
    public static int gananciasTLOU; // Ganancias TLOU
    
    //Semaforos (M = Mutex, P = ProductorIntro, E = Ensamblador
    Semaphore PIntro;
    Semaphore PInicio;
    Semaphore PCred;
    Semaphore PCierre;
    Semaphore PPlot;
    
    Semaphore MIntro = new Semaphore(1);
    Semaphore MInicio = new Semaphore(1);
    Semaphore MCred = new Semaphore(1);
    Semaphore MCierre = new Semaphore(1);
    Semaphore MPlot = new Semaphore(1);
    
    Semaphore EIntro = new Semaphore(0);
    Semaphore EInicio = new Semaphore(0);
    Semaphore ECred = new Semaphore(0);
    Semaphore ECierre = new Semaphore(0);
    Semaphore EPlot = new Semaphore(0);
    
    Semaphore Reloj = new Semaphore(1);
    
    Semaphore Capitulo = new Semaphore(1);
    
    public HBO1(){
    
    }
    
    //Metodo que crea los semaforos
    public void InicializarValores() throws InterruptedException {
    
        driveInicio = new Drive();
        driveIntros = new Drive();
        driveCred = new Drive();
        driveCierre = new Drive();
        drivePlot = new Drive();
        
        
        PInicio = new Semaphore(50);
        PIntro = new Semaphore(30);
        PCred = new Semaphore(25);
        PCierre = new Semaphore(55);
        PPlot = new Semaphore(40);
        
        
        Inicio = 0;
        Intro = 0;
        Cred = 0;
        Cierre = 0;
        Plot = 0;
        CapituloTLOU =0;
        
        DiaDuracion = 1;
        DiasParaCorte = 30;
        
        inicioDrive = 50; //Almacenamiento de Inicios en el Drive
        introDrive = 30; //Almacenamiento de Intros en el Drive
        credDrive= 25; //Almacenamiento de Creditos en el Drive
        cierreDrive= 55; //Almacenamiento de Cierres en el Drive
        plotDrive=40; //Almacenamiento de Plot en el Drive
        
        vecProductoresIntro = new ProductorIntro[10];
        vecProductoresInicio = new ProductorInicio[10];
        vecProductoresCred = new ProductorCred[10];
        vecProductoresCierre = new ProductorCierre[10];
        vecProductoresPlot = new ProductorPlot[10];
  
        vecEnsamblador = new Ensamblador[10];
        
    }
    
    
    //Metodo para craer Hilos y empleados
    public void Start() throws ParseException, InterruptedException{
        InicializarValores();
        ProductorIntro();
        ProductorInicio();
        ProductorCred();
        ProductorPlot();
        ProductorCierre();
        Ensamblador();
            
        
        }
    public void ProductorIntro(){
        vecProductoresIntro[PosVecIntro] = new ProductorIntro(driveIntros,PIntro,MIntro,EIntro);
        vecProductoresIntro[PosVecIntro].start();
        PosVecIntro++;
    
    }
    
    public void ProductorInicio(){
        vecProductoresInicio[PosVecInicio] = new ProductorInicio(driveInicio,PInicio,MInicio,EInicio);
        vecProductoresInicio[PosVecInicio].start();
        PosVecInicio++;
    
    }
    
    public void ProductorCred(){
        vecProductoresCred[PosVecCred] = new ProductorCred(driveCred,PCred,MCred,ECred);
        vecProductoresCred[PosVecCred].start();
        PosVecCred++;
    
    }
    public void ProductorCierre(){
        vecProductoresCierre[PosVecCierre] = new ProductorCierre(driveCierre,PCierre,MCierre,ECierre);
        vecProductoresCierre[PosVecCierre].start();
        PosVecCierre++;
    
    }
    public void ProductorPlot(){
        vecProductoresPlot[PosVecPlot] = new ProductorPlot(drivePlot,PPlot,MPlot,EPlot);
        vecProductoresPlot[PosVecPlot].start();
        PosVecPlot++;
    
    }
    
    public void Ensamblador(){
       vecEnsamblador[PosVecEnsamblador] = new Ensamblador (driveIntros, driveInicio, driveCred, driveCierre,drivePlot,PIntro, PInicio, PCred, PCierre,MIntro,MInicio,MCred,MCierre,MPlot, PPlot, EIntro, EInicio, ECred,ECierre, EPlot, Capitulo);
       vecEnsamblador[PosVecEnsamblador].start();
       PosVecEnsamblador++;
    }
    
    }
    
