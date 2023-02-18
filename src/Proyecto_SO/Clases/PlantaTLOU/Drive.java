/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto_SO.Clases.PlantaTLOU;

import java.util.ArrayList;

/**
 *
 * @author frand
 */
public class Drive {
    
    //El drive sera el buffer en nuestro simulador
    
    //Vectores que almacenan temporalmente cada una de las partes de un capitulo
    private int intro[];
    private int inicio[];
    private int cierre[];
    private int cred[];
    private int plot[];
    
    //Apuntadores para admimistrar la entrada y salida de partes de los capitulos
    private int introEntra;
    private int introSale;
    
    private int inicioEntra;
    private int inicioSale;
    
    private int cierreEntra;
    private int cierreSale;
    
    private int credEntra;
    private int credSale;
    
    private int plotEntra;
    private int plotSale;
    
    // Atributos de la clase Drive
    /*
    private int capacidad;
    private int id;
    private ArrayList drive = new ArrayList (capacidad);
    */
    
    //Constructor de la clase
    
    
    public Drive(){
        //Se inicializan los vectores indicando su tamano
        
        this.intro = new int[30];
        this.inicio = new int[50];
        this.cred = new int [25];
        this.cierre = new int [55];
        this.plot = new int [40];
        
        //Posiciones de entrada y salida de las partes de los caps
        
        this.introEntra = 0;
        this.introSale = 0;
        this.inicioEntra = 0;
        this.inicioSale=0;
        this.credEntra = 0;
        this.credSale = 0;
        this.cierreEntra = 0;
        this.cierreSale = 0;
        this.plotEntra =0;
        this.plotSale = 0;
       
    }
    
    //Produccion y consumo de intro
    
    
    public void producirIntro(){
        this.intro[introEntra]=1;
        introEntra = (introEntra +1)%30;
    
    }
    
    public void consumirIntro(){
        this.intro[introSale]=0;
        introSale = (introSale +1)%30;
    
    
    }
    
     //Produccion y consumo de inicio
    
    
    public void producirInicio(){
        this.inicio[inicioEntra]=1;
        inicioEntra = (inicioEntra +1)%30;
    
    }
    
    public void consumirInicio(){
        this.inicio[inicioSale]=0;
        inicioSale = (inicioSale +1)%30;
    
    
    }
    
    //Produccion y consumo de inicio
    
    
    public void producirCred(){
        this.cred[credEntra]=1;
        credEntra = (credEntra +1)%30;
    
    }
    
    public void consumirCred(){
        this.cred[credSale]=0;
        credSale = (credSale +1)%30;
    
    
    }
    
    //Produccion y consumo de inicio
    
    
    public void producirCierre(){
        this.cierre[cierreEntra]=1;
        cierreEntra = (cierreEntra +1)%30;
    
    }
    
    public void consumirCierre(){
        this.cierre[cierreSale]=0;
        cierreSale = (cierreSale +1)%30;
    
    
    }
    
    //Produccion y consumo de inicio
    
    
    public void producirPlot(){
        this.plot[plotEntra]=1;
        plotEntra = (plotEntra +1)%30;
    
    }
    
    public void consumirPlot(){
        this.plot[plotSale]=0;
        plotSale = (plotSale +1)%30;
    
    
    }
    
    //Getters and Setters
    /*
    public int getCapacidad(){
        return capacidad;
        
    }
    
    public void setCapacidad(){
        this.capacidad = capacidad;
    }
    
    public int getCantidadPartes(){
        return this.drive.size();
        
    
    }
    
    public void setParte(int dato){
        this.drive.add(dato);
    }
    
    public void getParte(int index){
       
    
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    */
    }
    
    
    

