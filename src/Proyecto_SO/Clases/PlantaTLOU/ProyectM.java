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
        Semaphore Capitulo = new Semaphore(1);
        Random r = new Random();
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
                    PM = "Rick y Morty Time!";
                    Thread.sleep(100);
                    System.out.println("El PM esta revisando el contador");
                    Reloj.acquire();
                        PM = "Contador";
                        Thread.sleep(200);
                    Reloj.release();
                    
                
                
                } catch(InterruptedException ex){System.out.println("PM Celebra!");}
            
            
            
            }
        
        
        }
}
