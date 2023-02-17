/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto_SO.Clases.PlantaTLOU;

import java.util.concurrent.Semaphore;

/**
 *
 * @author frand
 */
public class HBO1 {
    
    //Atributos de la clase
    public static Drive drive[];
    
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
    
    public static int Inicio; // Numero de partes de Inicio
    public static int Intro; // Numero de partes de Intros
    public static int Cred; // Numero de partes de Creditos
    public static int Cierre; // Numero de partes de Cierres
    public static int Plot; // Numero de partes de Plot
    
    public static int inicioDrive; //Almacenamiento de Inicios en el Drive
    public static int introDrive; //Almacenamiento de Intros en el Drive
    public static int credDrive; //Almacenamiento de Creditos en el Drive
    public static int cierreDrive; //Almacenamiento de Cierres en el Drive
    public static int plotDrive; //Almacenamiento de Plot twist en el Drive
    
    public static int ensamblador; // Cantidad de ensambladores
    
    public static int CapTLOU; //Contador de capitulos listos de TLOU
    
    public static int diasEntrega; //Dias que faltan para la entrega
    
    public static String haciendoPM; // Actividad que realica el PM
    public static int salarioPM; // Salario del PM en tiempo real
    
    public static String haciendoDir; // Actividad que realica el Dir
    
    public static int gananciasTLOU; // Ganancias TLOU
    
    //Semaforos (EM = Exclusion Mutua, P = Productor, E = Ensamblador
    private Semaphore[] SEMD,SPD,SED; //Semaforos de los Drives
    
    public HBO1(){
    
    }
    
    //Metodo que crea los semaforos
    public void CrearSemaforos() throws InterruptedException {
    SEMD = new Semaphore[5];
    SPD = new Semaphore[5];
    SED = new Semaphore[5];
    
    for (int i = 0; i < SEMD.length; i++) {
            this.SEMD[i] = new Semaphore(1);
        }
        
        for (int i = 0; i < SED.length; i++) {
            this.SED[i] = new Semaphore(HBO1.empleadosMax);
        }
        
        for (int i = 0; i < SPD.length; i++) {
            this.SPD[i] = new Semaphore(0);
        }
    }
    
    public void inicializarValores(){
        
        //Creando los drives
        HBO1.drive = new Drive[5];
        HBO1.drive[0] = new Drive(inicioDrive,1);
        HBO1.drive[1] = new Drive(introDrive,2);
        HBO1.drive[2] = new Drive(credDrive,3);
        HBO1.drive[3] = new Drive(cierreDrive,4);
        HBO1.drive[4] = new Drive(plotDrive,5);
        
    
    }
    
    //Metodo para craer Hilos
    public void crearHilo(int tipo, int numDrive){
        switch(tipo){
        
            case 0:
                //Se crea un productor de Inicio
            
            case 1:
                //Se crea un productor de Intros
            
            case 2:
                //Se crea un productor de cred
            
            case 3:
                //Se crea un productor de Cierre
            
            case 4:
                //Se crea un productor de Plot
            
            case 5:
                //Se crea un Ensamblador
            
        
        }
    
    }
}
