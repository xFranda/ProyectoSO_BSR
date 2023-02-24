/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_SO.Clases.PlantaRyM;

/**
 *
 * @author Gab
 */
public class Tiempo {
     public static int Dia;
    public int counter; 


    
    public Tiempo(){        
        this.Dia=Director.Mes;
        this.counter=0;         
    }
    
    public void run(){  //Va contando los dias que van pasando        
        while(true){   
            try {
                Thread.sleep(HBO2.duracionDia);
                System.out.println("\nDIA: "+(Dia-1));
                Dia--;
                Director.Mes--;
            } catch (InterruptedException ex) {System.out.println("Ocurrió un error!");}
        }
    }
    
}
