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
    private static boolean activo = true;
    
    public Dia(){        
        this.Dia=HBO1.DiasParaCorte;
        this.contador=0;         
    }
    
    @Override
    public void run(){  //Va contando los dias que van pasando        
        while(activo){   
            try {
                Thread.sleep(HBO1.DiaDuracion);
                System.out.println("\nDIA: "+(Dia-1));
                Dia--;
                Director.Mes--;
            } catch (InterruptedException ex) {System.out.println("Ocurrió un error!");}
        }
    }
    
    public static void StopDia(){
    activo = false;
    }
    
}
