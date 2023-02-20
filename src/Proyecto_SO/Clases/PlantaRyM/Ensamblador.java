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
public class Ensamblador extends Thread{
    Semaphore introduccion;
    Semaphore inicio; 
    Semaphore plottwist; 
    Semaphore cierre;
    Semaphore creditos;
    boolean introBoo = false; 
    boolean iniBoo = false; 
    boolean plotBoo = false; 
    boolean cierreBoo = false; 
    boolean credBoo = false; 
    Drive google; 
    
    int capitulos; 
    
    boolean empleado; 
    
    public Ensamblador(Semaphore introduccion, Semaphore inicio, Semaphore plottwist, 
            Semaphore cierre, Semaphore creditos, Drive google, boolean empleado, int capitulos ){
        
        this.introduccion = introduccion; 
        this.inicio = inicio; 
        this.plottwist = plottwist; 
        this.cierre = cierre; 
        this.creditos = creditos; 
        this.google = google; 
        this.empleado = empleado; 
        this.capitulos = capitulos; 
    }
    
    public void run(){
        while(true){
            try{
                this.inicio.acquire();
                
            }catch (InterruptedException ex) {
        }
    }
    }
}

