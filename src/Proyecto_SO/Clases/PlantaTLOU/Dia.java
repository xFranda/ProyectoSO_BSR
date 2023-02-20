/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto_SO.Clases.PlantaTLOU;

/**
 *
 * @author frand
 */
public class Dia extends Thread {
    
    public static int Dia;
    public int contador; 
    
    public Dia(){        
        this.Dia=HBO1.DiasParaCorte;
        this.contador=0;         
    }
    
    @Override
    public void run(){  //Va contando los dias que van pasando        
        while(true){   
            try {
                Thread.sleep(HBO1.DiaDuracion);
                System.out.println("\nDIA: "+(Dia-1));
                Dia--;
            } catch (InterruptedException ex) {System.out.println("Ocurrió un error!");}
        }
    }
    
}
