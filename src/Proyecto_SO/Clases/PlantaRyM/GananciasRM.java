/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_SO.Clases.PlantaRyM;

import static java.lang.Math.round;

/**
 *
 * @author Gab
 */
public class GananciasRM extends Thread{
    
    public static int capiGanan; 
    public static int duracionDia; 
    public static int capitulos;
    public static int cantProdIntro; 
    public static int intrSueldo;
    public static int cantProdInicio; 
    public static int iniSueldo;
    public static int cantProdCierre; 
    public static int cierreSueldo;
    public static int cantProdCred; 
    public static int credSueldo;
    public static int cantPTwist; 
    public static int ptwistSueldo;
    public static int dirSueldo;
    public static int PmSueldo;
    public static int ensamCant;
    public static int EnsamSueldo;
    public static int Ganancias; 
    public static int Gastos; 
    
    public GananciasRM(){
        this.duracionDia = HBO2.duracionDia;
        this.capitulos = HBO2.capitulos; 
        this.cantProdIntro = HBO2.introProducciones.size();
        this.cantProdInicio = HBO2.openingProducciones.size(); 
        this.cantProdCierre =  HBO2.cierresProducciones.size(); 
        this.cantProdCred =  HBO2.creditosProducciones.size();
        this.cantPTwist =  HBO2.twistProducciones.size();
        this.ensamCant = HBO2.ensambladorLista.size();
        this.Ganancias = HBO2.pGanancias;
         this.Gastos = HBO2.pGastos;
        
    }
    
    public void run(){
        while (true){
            try{
                
                Thread.sleep(HBO2.duracionDia/24);
                capiGanan = HBO2.capitulos * 1000000;
                intrSueldo = 5  * cantProdIntro ; 
                iniSueldo = 7 * cantProdInicio;
                cierreSueldo = (int) (7.5 * cantProdCierre); 
                credSueldo = 3 * cantProdCred;
                ptwistSueldo = 10 * cantPTwist;
                dirSueldo = 100/24 ;
                PmSueldo = 7 ; 
                EnsamSueldo = ensamCant *8 ;  
                
                Gastos  += intrSueldo + iniSueldo + cierreSueldo + credSueldo + ptwistSueldo + dirSueldo + PmSueldo + EnsamSueldo; 
                Ganancias = capiGanan;  
                
            }catch (Exception e){
                
            }
        }
        
    }
    
    
    
}
