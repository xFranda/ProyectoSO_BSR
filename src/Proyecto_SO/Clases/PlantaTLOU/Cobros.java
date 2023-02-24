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
public class Cobros extends Thread {
    
    public static int DiaDuracion;
    public int contador; 
    private static boolean activo = true;
    
    public Cobros(){        
        this.DiaDuracion =HBO1.DiaDuracion;
                
    }
    
    @Override
    public void run(){  //Va contando los dias que van pasando        
        while(true){   
            try {
                Thread.sleep(HBO1.DiaDuracion/24);
                //Productor Intro Cobro
                HBO1.Gastos = HBO1.Gastos -(5*HBO1.PosVecIntro);
                HBO1.Gastos = HBO1.Gastos -(7*HBO1.PosVecInicio);
                HBO1.Gastos = HBO1.Gastos -(3*HBO1.PosVecCred);
                HBO1.Gastos = HBO1.Gastos -((7.5)*HBO1.PosVecCierre);
                HBO1.Gastos = HBO1.Gastos -(10*HBO1.PosVecPlot);
                HBO1.Gastos = HBO1.Gastos -(8*HBO1.PosVecEnsamblador);
                HBO1.Gastos = HBO1.Gastos -(7); //Lo que cobra el PM por hora
                HBO1.Gastos = HBO1.Gastos -(40); //Lo que cobra el PM por hora
                
            } catch (InterruptedException ex) {System.out.println("Ocurrió un error!");}
        }
    }
    public static void StopCobros(){
    activo = false;
    }
    
}
