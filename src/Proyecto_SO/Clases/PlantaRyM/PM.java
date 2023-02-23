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
public class PM extends Thread{
                                                                   
    int duracionDia;                                                           
    String status;                                                              
    Semaphore reloj = new Semaphore(1); 
    int limite; 

    //Constructor
    public PM (Semaphore reloj) {
        status = "";
        this.reloj = reloj;
     
    }

    
    public void run() {
        while (true) {
            try {
              
              status = "Viendo R&M";
              Thread.sleep((HBO2.duracionDia/48));
              status = "Sprint Reviews";
             
              Thread.sleep((HBO2.duracionDia/48));
              reloj.acquire();
              status = "Contador";
              Thread.sleep(3*(HBO2.duracionDia/24));
             
              limite--;
           
              reloj.release();
                    

               
            
                
            } catch (Exception e) {
                System.out.println("Se fundio el PM");
            }
        }  
    }
}
