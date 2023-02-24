/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_SO.Clases.PlantaRyM;

import static java.lang.Math.round;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Gab
 */
public class Director extends Thread{
    Semaphore Reloj = new Semaphore(1);
    Semaphore Capitulos = new Semaphore(1); 
    public static int limite; 
    public static String status; 
    public static int contador = 0; 
    public static int Mes = 30; 
    public boolean empleao = true;
    
    
    public Director(Semaphore Reloj, Semaphore Capitulos){
        this.Reloj = Reloj; 
        this.Capitulos = Capitulos; 
        this.limite = limite; 
        this.contador = contador; 
        this.Mes = Mes; 
        status = ""; 
        
    }
    
    @Override 
    public void run() {
        while(empleao){
            try{
                do{
                    this.sleep(round(Math.random()*(HBO2.duracionDia/32)));
                    status = "checking"; 
                    if("Viendo R&M".equals(PM.status)){
                        contador++; 
                        status ="AJA"; 
                    }
                    
                }while (limite != Mes); 
                Reloj.acquire();
                this.sleep(HBO2.duracionDia/4); 
                Tiempo.Dia = limite; 
                        status = "Despachado";
                        Thread.sleep(HBO2.duracionDia/4);
                        Capitulos.acquire();
                            
                            
                            HBO2.capitulos=0;
                            if (Mes == 0){
                            
                            Mes=30;
                            
                            }
                            
                            
                        Capitulos.release();
                        
                    Reloj.release();
            }catch(InterruptedException ex){System.out.println("Director Error");}
            
            
        }
    }
    
}
