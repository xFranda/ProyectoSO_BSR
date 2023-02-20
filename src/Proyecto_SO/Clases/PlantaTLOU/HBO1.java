/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto_SO.Clases.PlantaTLOU;

import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.Integer.parseInt;
import java.text.ParseException;
import java.util.concurrent.Semaphore;
import java.util.ArrayList;
import java.util.Scanner;

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
    public static int PosVecIntro; 
    public static ProductorInicio[] vecProductoresInicio;
    public int PosVecInicio;
    public static ProductorCred[] vecProductoresCred;
    public int PosVecCred;
    public static ProductorCierre[] vecProductoresCierre;
    public int PosVecCierre; 
    public static ProductorPlot[] vecProductoresPlot;
    public int PosVecPlot; 
    public static Ensamblador[] vecEnsamblador;
    public int PosVecEnsamblador; 
    
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
    public void InicializarValores() throws InterruptedException, FileNotFoundException {
    
        driveInicio = new Drive();
        driveIntros = new Drive();
        driveCred = new Drive();
        driveCierre = new Drive();
        drivePlot = new Drive();
        
        
        
        Inicio = 0;
        Intro = 0;
        Cred = 0;
        Cierre = 0;
        Plot = 0;
        CapituloTLOU =0;
        empleadosMax=10;
        
        Scanner doc = new Scanner(new File("src/Proyecto_SO/Clases/PlantaTLOU/DatosTLOU.txt"));
        String line = doc.nextLine();
        
        //Se procede a leer cada dato y se guardara en su respectiva variable.
        DiaDuracion = parseInt(line.substring(17, 25).trim());
        line = doc.nextLine();
        DiasParaCorte = parseInt(line.substring(17, 25).trim());
        line = doc.nextLine();
        
        inicioDrive = parseInt(line.substring(17, 25).trim());
        line = doc.nextLine(); //Almacenamiento de Inicios en el Drive
        introDrive = parseInt(line.substring(17, 25).trim());
        line = doc.nextLine();; //Almacenamiento de Intros en el Drive
        credDrive= parseInt(line.substring(17, 25).trim());
        line = doc.nextLine(); //Almacenamiento de Creditos en el Drive
        cierreDrive= parseInt(line.substring(17,25).trim());
        line = doc.nextLine();; //Almacenamiento de Cierres en el Drive
        plotDrive=parseInt(line.substring(17, 25).trim());
        line = doc.nextLine();; //Almacenamiento de Plot en el Drive
        
        prodInicio =parseInt(line.substring(17,25).trim());
        line = doc.nextLine(); // Numero de productores de Inicio
        prodIntro=parseInt(line.substring(17, 25).trim());
        line = doc.nextLine(); // Numero de productores de Intros
        prodCred=parseInt(line.substring(17, 25).trim());
        line = doc.nextLine(); // Numero de productores de Creditos
        prodCierre=parseInt(line.substring(17, 25).trim());
        line = doc.nextLine(); // Numero de productores de Cierres
        prodPlot=parseInt(line.substring(17, 25).trim());
        line = doc.nextLine(); // Numero de productores de Plot
        ensamblador=parseInt(line.substring(17, 25).trim()); //Numeros de ensambladores 
        
        PInicio = new Semaphore(inicioDrive);
        PIntro = new Semaphore(introDrive);
        PCred = new Semaphore(introDrive);
        PCierre = new Semaphore(cierreDrive);
        PPlot = new Semaphore(plotDrive);
        
        
        vecProductoresIntro = new ProductorIntro[empleadosMax];
        vecProductoresInicio = new ProductorInicio[empleadosMax];
        vecProductoresCred = new ProductorCred[empleadosMax];
        vecProductoresCierre = new ProductorCierre[empleadosMax];
        vecProductoresPlot = new ProductorPlot[empleadosMax];
  
        vecEnsamblador = new Ensamblador[empleadosMax];
        
    }
    
    
    //Metodo para craer Hilos y empleados
    public void Start() throws ParseException, InterruptedException, FileNotFoundException{
        InicializarValores();
        CrearContadorDia();
        CrearDirector();
        CrearProyectM();
        if ((prodInicio+prodIntro+prodCred+prodCierre+prodPlot+ensamblador)<empleadosMax){
            for(int i=0; i < prodIntro; i++){  //1 productores iniciales
                ProductorIntro ();
            }
            for(int i=0; i < prodInicio; i++){  //1 
                ProductorInicio ();
            }
            for(int i=0; i < prodCred; i++){  //1 
                ProductorCred ();
            }
            for(int i=0; i < prodPlot; i++){  //1 
                ProductorPlot ();
            }
            for(int i=0; i < prodCierre; i++){  //1 
                ProductorCierre ();
            }
            for(int i=0; i < ensamblador; i++){  //1 
                Ensamblador ();
            }
        }else{
            
        
        }

            
        
        }
    public void ProductorIntro(){
        vecProductoresIntro[PosVecIntro] = new ProductorIntro(driveIntros,PIntro,MIntro,EIntro);
        vecProductoresIntro[PosVecIntro].start();
        PosVecIntro++;
    
    }
    public void DespProductorIntro () {
            PosVecIntro--;
            vecProductoresIntro[PosVecIntro].DespProdIntro();
    }
    
    public void ProductorInicio(){
        vecProductoresInicio[PosVecInicio] = new ProductorInicio(driveInicio,PInicio,MInicio,EInicio);
        vecProductoresInicio[PosVecInicio].start();
        PosVecInicio++;
    
    }
    public void DespProductorInicio () {
            PosVecInicio--;
            vecProductoresInicio[PosVecInicio].DespProdInicio();
    }
    
    public void ProductorCred(){
        vecProductoresCred[PosVecCred] = new ProductorCred(driveCred,PCred,MCred,ECred);
        vecProductoresCred[PosVecCred].start();
        PosVecCred++;
    
    }
    public void DespProductorCred () {
            PosVecCred--;
            vecProductoresCred[PosVecCred].DespProdCred();
    }
    public void ProductorCierre(){
        vecProductoresCierre[PosVecCierre] = new ProductorCierre(driveCierre,PCierre,MCierre,ECierre);
        vecProductoresCierre[PosVecCierre].start();
        PosVecCierre++;
    
    }
    public void DespProductorCierre () {
            PosVecCierre--;
            vecProductoresCierre[PosVecCierre].DespProdCierre();
    }
    public void ProductorPlot(){
        vecProductoresPlot[PosVecPlot] = new ProductorPlot(drivePlot,PPlot,MPlot,EPlot);
        vecProductoresPlot[PosVecPlot].start();
        PosVecPlot++;
    
    }
    public void DespProductorPlot () {
            PosVecPlot--;
            vecProductoresPlot[PosVecPlot].DespProdPlot();
    }
    
    public void Ensamblador(){
       vecEnsamblador[PosVecEnsamblador] = new Ensamblador (driveIntros, driveInicio, driveCred, driveCierre,drivePlot,PIntro, PInicio, PCred, PCierre,MIntro,MInicio,MCred,MCierre,MPlot, PPlot, EIntro, EInicio, ECred,ECierre, EPlot, Capitulo);
       vecEnsamblador[PosVecEnsamblador].start();
       PosVecEnsamblador++;
    }
    public void DespProductorE () {
            PosVecEnsamblador--;
            vecEnsamblador[PosVecEnsamblador].DespedirEnsamblador();
    }
    
        public void CrearDirector (){
        Director Dir = new Director(Reloj, Capitulo);
        Dir.start();
    }
    
    public void CrearProyectM (){
        ProyectM PM = new ProyectM(Reloj);
        PM.start();
    }
    
    public void CrearContadorDia (){
        Dia Dia = new Dia();
        Dia.start();
    }
    
    }
    
