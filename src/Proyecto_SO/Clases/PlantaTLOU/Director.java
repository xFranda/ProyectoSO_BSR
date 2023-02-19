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
public class Director extends Thread {
        Semaphore Reloj = new Semaphore(1);
        Semaphore Capitulo = new Semaphore(1);
        Random r = new Random();
        public static String DIR;
        int NumMax = 900;
        int NumMin = 300;
        
        public Director (Semaphore Reloj, Semaphore Capitulo){
            this.Reloj = Reloj;
            DIR = "";
        }
        
        
        @Override
        public void run (){
            while(true){
            
                try{
                    Thread.sleep(r.nextInt(1800-1200)+1200);
                    do {
                        System.out.println("Revisando al PM");
                        DIR ="Revisando";
                        Thread.sleep(r.nextInt(NumMax-NumMin)+NumMin);
                        if ("Rick y Morty Time!".equals(ProyectM.PM)){
                            System.out.println("Agarrado con las Manos en el Morty");
                        }
                        
                    
                    
                    }while(HBO1.DiasParaCorte!=0);
                    System.out.println("El Dir esta despachando");
                    DIR = "Despachando";
                    Thread.sleep(1000);
                    Reloj.acquire(1);
                        DIR = "Despacho";
                        Thread.sleep(200);
                        Capitulo.acquire();
                            HBO1.CapituloTLOU =0;
                        Capitulo.release();
                    Reloj.release(1);
                    
                
                
                } catch(InterruptedException ex){System.out.println("Director en crisis");}
            
            
            
            }
        
        
        }
}
