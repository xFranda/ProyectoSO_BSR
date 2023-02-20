/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto_SO.Clases.PlantaTLOU;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author frand
 */
public class ProyectM extends Thread {
        Semaphore Reloj = new Semaphore(1);
        public static int DiasAntesCorte;
        public static String PM;
        
        public ProyectM (Semaphore Reloj){
            this.Reloj = Reloj;
            PM = "";
        }
        
        
        @Override
        public void run (){
            while(true){
            
                try{
                    System.out.println("El PM esta viendo RM");
                    PM = "RM Time";
                    Thread.sleep((HBO1.DiaDuracion/5));
                    PM = "Sprint";
                    Thread.sleep((HBO1.DiaDuracion/5));
                    System.out.println("El PM esta revisando el contador");
                    Reloj.acquire();
                        PM = "Contador";
                        Thread.sleep(200);
                        DiasAntesCorte--;
                    Reloj.release();
                    
                
                
                } catch(InterruptedException ex){System.out.println("PM Celebra!");}
            
            
            
            }
        
        
        }
}
