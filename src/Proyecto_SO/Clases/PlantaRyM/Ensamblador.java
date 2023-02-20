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
    Semaphore pIntroduccion;
    Semaphore pIntro;
    Semaphore pPTwist;
    Semaphore pCreditos;
    Semaphore pCierre;
    Semaphore eIntro;
    Semaphore eInicio;
    Semaphore ePTwist;
    Semaphore eCreditos;
    Semaphore eCierre;
    boolean introBoo = false; 
    boolean iniBoo = false; 
    boolean plotBoo = false; 
    boolean cierreBoo = false; 
    boolean credBoo = false; 
    Drive driveIntros; 
    Drive driveInicio;
    Drive driveCred;
    Drive driveCierre;
    Drive drivePlot; 
    
    
    int capitulos; 
    
    boolean empleado = true;  
    
    public Ensamblador(Semaphore introduccion, Semaphore inicio, Semaphore plottwist, 
            Semaphore cierre, Semaphore creditos, Semaphore pIntroduccion, Semaphore pIntro, Semaphore pPTwist, Semaphore pCreditos, Semaphore pCierre,
            Semaphore eIntro, Semaphore eInicio, Semaphore ePTwist, Semaphore eCreditos, Semaphore eCierre,
            Drive driveIntros, Drive driveInicio, Drive driveCred, Drive driveCierre, Drive drivePlot, boolean empleado, int capitulos ){
        
        this.introduccion = introduccion; 
        this.inicio = inicio; 
        this.plottwist = plottwist; 
        this.cierre = cierre; 
        this.creditos = creditos;  
        this.empleado = empleado; 
        this.capitulos = capitulos;
        this.pIntroduccion = pIntroduccion; 
        this.pIntro = pIntro; 
        this.pPTwist = pPTwist; 
        this.pCreditos = pCreditos; 
        this.pCierre = pCierre;
        this.eIntro = eIntro; 
        this.eInicio = eInicio; 
        this.ePTwist = ePTwist; 
        this.eCreditos = eCreditos; 
        this.eCierre = eCierre;
        this.driveIntros = driveIntros; 
        this.driveInicio = driveInicio; 
        this.driveCred = driveCred; 
        this.driveCierre = driveCierre;
        this.drivePlot = drivePlot; 
        
      
        
    }
    
    public void run(){
        while(empleado){
            try{
                this. 
                this.introduccion.acquire();
                
            }catch (InterruptedException ex) {
        }
    }
    }
}

