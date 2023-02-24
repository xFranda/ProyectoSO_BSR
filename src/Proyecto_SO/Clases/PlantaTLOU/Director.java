/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto_SO.Clases.PlantaTLOU;

import static java.lang.Math.round;
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
        public static int DiasParaCorte;
        public static String DIR;
        int audiencia= 1100000;
        int dineroCap = 150000;
        public static int contadorRM =0;
        public static int Mes = 30;
        private static boolean activo = true;
        
        public Director (Semaphore Reloj, Semaphore Capitulo){
            this.Reloj = Reloj;
            DIR = "";
        }
        
        
        @Override
        public void run (){
            while(activo){
            
                try{
                    do {
                        Thread.sleep(round(Math.random()*(HBO1.DiaDuracion/16-HBO1.DiaDuracion/48)+HBO1.DiaDuracion/48));
                        //Thread.sleep(r.nextInt(1800-1200)+1200);
                        //System.out.println("Revisando al PM");
                        DIR ="Revisando";
                        
                        if ("RM Time".equals(ProyectM.PM)){
                            //System.out.println("Agarrado con las Manos en el Morty");
                            contadorRM++;
                            DIR="Divagando";
                        }
                        
                    
                    
                    }while(Dia.Dia!=DiasParaCorte);
                    
                    Reloj.acquire();
                        DIR = "Despachando";
                        Thread.sleep(HBO1.DiaDuracion/4);
                        Dia.Dia = HBO1.DiasParaCorte;
                        DIR = "Despachado";
                        Thread.sleep(HBO1.DiaDuracion/4);
                        Capitulo.acquire();
                        
                            HBO1.GananciasLote = HBO1.LoteTLOU * (7.333*100000);
                            for (int i=0;i<HBO1.CapituloTLOU-1;i++){
                                HBO1.Ganancias = HBO1.Ganancias + (7.333*100000*(i+1));
                            }
                            
                            HBO1.LoteTLOU = HBO1.CapituloTLOU;
                            HBO1.CapituloTLOU =0;
                            if (Mes == 0){
                            HBO1.GastosM= HBO1.GastosM-contadorRM;
                            contadorRM=0;
                            HBO1.GastosM = HBO1.Gastos;
                            Mes=30;
                            
                            }
                            
                            
                        Capitulo.release();
                        
                    Reloj.release();
                    
                    
                
                
                } catch(InterruptedException ex){System.out.println("Director en crisis");}
            
            
            
            }
        
        
        }
        
        
        public static void DespDir(){
        activo = false;
        DIR="STOP";
        
        }
}
