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
public class Ensamblador extends Thread{
    
    boolean activo = true;
    int tipo=1;
    Semaphore PIntro;
    Semaphore PInicio;
    Semaphore PCred;
    Semaphore PCierre;
    Semaphore PPlot;
    
    Semaphore MIntro;
    Semaphore MInicio;
    Semaphore MCred;
    Semaphore MCierre;
    Semaphore MPlot;
    
    Semaphore EIntro;
    Semaphore EInicio;
    Semaphore ECred;
    Semaphore ECierre;
    Semaphore EPlot;
    
    Semaphore Capitulo;
    
    public Drive driveIntro;
    public Drive driveInicio;
    public Drive driveCred;
    public Drive driveCierre;
    public Drive drivePlot;
    
    //Super ensamblador
    public Ensamblador (Drive driveIntro, Drive driveInicio, Drive driveCred, Drive driveCierre, Drive drivePlot,
    Semaphore PIntro, 
    Semaphore PInicio, 
    Semaphore PCred, 
    Semaphore PCierre, 
    Semaphore PPlot, 
    Semaphore MIntro,
    Semaphore MInicio,
    Semaphore MCred,
    Semaphore MCierre,
    Semaphore MPlot,
    Semaphore EIntro,
    Semaphore EInicio,
    Semaphore ECred,
    Semaphore ECierre,
    Semaphore EPlot, 
    Semaphore Capitulo){
        
        this.PIntro = PIntro;
        this.PInicio = PInicio;
        this.PCred = PCred;
        this.PCierre = PCierre;
        this.PPlot = PPlot;
        
        this.MIntro =MIntro;
        this.MInicio = MInicio;
        this.MCred = MCred;
        this.MCierre = MCierre;
        this.MPlot = MPlot;
        
        this.EIntro = EIntro;
        this.EInicio = EInicio;
        this.ECred = ECred;
        this.ECierre = ECierre;
        this.EPlot = EPlot;
        
        this.Capitulo = Capitulo;
        
        this.driveIntro = driveIntro;
        this.driveInicio = driveInicio;
        this.driveCred = driveCred;
        this.drivePlot = drivePlot;
        this.driveCierre = driveCierre;
    
    
    }
    
    public void run() {
                        System.out.println("Ensamblando...");
        while (activo){
            try {
                if (HBO1.CapituloTLOU %5 == 0/* && HBO1.CapituloTLOU > 1*/){
                EIntro.acquire(1);
                EInicio.acquire(2);
                ECred.acquire(1);
                System.out.println("Ensambladores empezando el trabajo");
                EPlot.acquire(2);
                Thread.sleep(HBO1.DiaDuracion*2);
                
                
                MInicio.acquire(1);
                MIntro.acquire(1);
                MCred.acquire(1);
                MPlot.acquire(1);
                
                driveIntro.consumirIntro();
                HBO1.Intro--;
                
                driveInicio.consumirInicio();
                driveInicio.consumirInicio();
                HBO1.Inicio = HBO1.Inicio-2;
                
                driveCred.consumirCred();
                HBO1.Cred--;
                
                drivePlot.consumirPlot();
                drivePlot.consumirPlot();
                HBO1.Plot = HBO1.Plot-2;
                
                MInicio.release(1);
                MIntro.release(1);
                MCred.release(1);
                MPlot.release(1);
                
                PInicio.release(2);
                PIntro.release(1);
                PCred.release(1);
                PPlot.release(2);
                
                }else{          //Fina linea de separacion entre un Cierre y un Plot
                EIntro.acquire(1);
                EInicio.acquire(2);
                ECred.acquire(1);
                System.out.println("Ensambladores empezando el trabajo");
                ECierre.acquire(2);
                Thread.sleep(HBO1.DiaDuracion*2);
                
                MInicio.acquire(1);
                MIntro.acquire(1);
                MCred.acquire(1);
                MCierre.acquire(1);
                
                driveIntro.consumirIntro();
                HBO1.Intro--;
                
                driveInicio.consumirInicio();
                driveInicio.consumirInicio();
                HBO1.Inicio = HBO1.Inicio-2;
                
                driveCred.consumirCred();
                HBO1.Cred--;
                
                driveCierre.consumirCierre();
                driveCierre.consumirCierre();
                HBO1.Cierre = HBO1.Cierre-2;
                
                MInicio.release(1);
                MIntro.release(1);
                MCred.release(1);
                MCierre.release(1);
                
                PInicio.release(2);
                PIntro.release(1);
                PCred.release(1);
                PCierre.release(2);
                
                
                }
                
                
                
                Capitulo.acquire();
                HBO1.CapituloTLOU++;
                Capitulo.release();
                
                System.out.println("Capitulos: "+HBO1.CapituloTLOU);
                System.out.println("Numero de Intros:"+HBO1.Intro+" \n Numero de Inicio:" +HBO1.Inicio+" \n Numero de creditos:"+HBO1.Cred+" Numero de Cierres;"+HBO1.Cierre+ " Numero de Plot:" +HBO1.Plot);
                System.out.println("Capitulo ensamblado!!!");
                
            } catch ( InterruptedException ex){
               System.out.println("Se nos crasheo el Camtasia Studio");
            
            }
        
        
        }
    
    
    }
    
    public void DespedirEnsamblador (){
        activo = false;
    }
}
