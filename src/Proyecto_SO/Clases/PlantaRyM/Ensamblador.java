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
    Semaphore eIntro;
    Semaphore eInicio;
    Semaphore ePTwist;
    Semaphore eCreditos;
    Semaphore eCierre;
    Semaphore pIntroduccion;
    Semaphore pInicio;
    Semaphore pPTwist;
    Semaphore pCreditos;
    Semaphore pCierre;

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
          Semaphore cierre, Semaphore creditos, 
          Semaphore eIntro, Semaphore eInicio, Semaphore ePTwist, Semaphore eCreditos, Semaphore eCierre,
          Semaphore pIntroduccion, Semaphore pInicio, Semaphore pPTwist, Semaphore pCreditos, Semaphore pCierre,
            
            Drive driveIntros, Drive driveInicio, Drive driveCred, Drive driveCierre, Drive drivePlot, boolean empleado, int capitulos ){
        
        this.introduccion = introduccion; 
        this.inicio = inicio; 
        this.plottwist = plottwist; 
        this.cierre = cierre; 
        this.creditos = creditos;  
        this.empleado = empleado; 
        this.capitulos = capitulos;
        this.eIntro = eIntro; 
        this.eInicio = eInicio; 
        this.ePTwist = ePTwist; 
        this.eCreditos = eCreditos; 
        this.eCierre = eCierre;
        this.pIntroduccion = pIntroduccion; 
        this.pInicio = pInicio; 
        this.pPTwist = pPTwist; 
        this.pCreditos = pCreditos; 
        this.pCierre = pCierre;
        this.driveIntros = driveIntros; 
        this.driveInicio = driveInicio; 
        this.driveCred = driveCred; 
        this.driveCierre = driveCierre;
        this.drivePlot = drivePlot; 
        
      
        
    }
    
    public void run(){
        while(empleado){
            try{
                // introducciones
                this.eIntro.acquire();
                this.introduccion.acquire();

 
                if((this.driveIntros.getCantidad() >= 1 )&&(this.introBoo==false)){
                    this.introBoo = true; 
                    this.driveIntros.setCantidad(this.driveIntros.getCantidad()-1);
                   
                    
                }
                this.introduccion.release(); 
                this.pIntroduccion.release();
                
                
                // inicios 
                this.eInicio.acquire();
                this.inicio.acquire();
                if((this.driveInicio.getCantidad() >= 2 )&&(this.iniBoo==false)){
                    this.iniBoo = true;                    
                    this.driveInicio.setCantidad(this.driveInicio.getCantidad()-1);
                     
                    
                }
                this.inicio.release(); 
                this.pInicio.release();
                
                // cierres 
                this.eCierre.acquire();
                this.cierre.acquire();
                if((this.driveCierre.getCantidad() >= 1 )&&(this.cierreBoo==false)){
                    this.cierreBoo = true;                     
                    this.driveCierre.setCantidad(this.driveCierre.getCantidad()-1);
                    
                    
                }
                this.cierre.release(); 
                this.pCierre.release();
                
                // ptwists 
                
                this.ePTwist.acquire();
                this.plottwist.acquire();
                if((this.drivePlot.getCantidad() >= 1 )&&(this.plotBoo==false)){                    
                    this.drivePlot.setCantidad(this.drivePlot.getCantidad()-1);
                    this.plotBoo = true; 
                    
                }
                this.plottwist.release(); 
                this.pPTwist.release();
                
                // creditos 
                this.eCreditos.acquire();
                this.creditos.acquire();
                if((this.driveCred.getCantidad() >= 1 )&&(this.credBoo==false)){                    
                    this.driveCred.setCantidad(this.driveCred.getCantidad()-1);
                    this.credBoo = true; 
                    
                }
                this.creditos.release(); 
                this.pCreditos.release();
                
                
                
                  if((this.introBoo==true)&&(this.iniBoo==true)&&(this.cierreBoo==true)&&(this.plotBoo==true)&&(this.credBoo==true)){
                        this.introBoo=false;
                        this.iniBoo=false;
                        this.cierreBoo=false;
                        this.plotBoo=false;
                        this.credBoo=false;
                       
                        this.capitulos++;
                        System.out.println("Intro" + driveIntros.getCantidad());
                        System.out.println("Inicio" + driveInicio.getCantidad());
                        System.out.println("Cred" + driveCred.getCantidad());
                        System.out.println("Cierre" + driveCierre.getCantidad());
                        System.out.println("Ptwist" + drivePlot.getCantidad());
                        System.out.println("Capitulos" + capitulos);
                        
                    }
                
            }catch (InterruptedException ex) {
        }
    }
    }
}

