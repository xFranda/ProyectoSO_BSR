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
        
        this.intro = new int[HBO1.introDrive];
        this.inicio = new int[HBO1.inicioDrive];
        this.cred = new int [HBO1.credDrive];
        this.cierre = new int [HBO1.cierreDrive];
        this.plot = new int [HBO1.plotDrive];
        
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
        introEntra = (introEntra +1)% HBO1.introDrive;
    
    }
    
    public void consumirIntro(){
        this.intro[introSale]=0;
        introSale = (introSale +1)%HBO1.introDrive;
    
    
    }
    
     //Produccion y consumo de inicio
    
    
    public void producirInicio(){
        this.inicio[inicioEntra]=1;
        inicioEntra = (inicioEntra +1)%HBO1.inicioDrive;
    
    }
    
    public void consumirInicio(){
        this.inicio[inicioSale]=0;
        inicioSale = (inicioSale +1)%HBO1.inicioDrive;
    
    
    }
    
    //Produccion y consumo de inicio
    
    
    public void producirCred(){
        this.cred[credEntra]=1;
        credEntra = (credEntra +1)%HBO1.credDrive;
    
    }
    
    public void consumirCred(){
        this.cred[credSale]=0;
        credSale = (credSale +1)%HBO1.credDrive;
    
    
    }
    
    //Produccion y consumo de inicio
    
    
    public void producirCierre(){
        this.cierre[cierreEntra]=1;
        cierreEntra = (cierreEntra +1)%HBO1.cierreDrive;
    
    }
    
    public void consumirCierre(){
        this.cierre[cierreSale]=0;
        cierreSale = (cierreSale +1)%HBO1.cierreDrive;
    
    
    }
    
    //Produccion y consumo de inicio
    
    
    public void producirPlot(){
        this.plot[plotEntra]=1;
        plotEntra = (plotEntra +1)%HBO1.plotDrive;
    
    }
    
    public void consumirPlot(){
        this.plot[plotSale]=0;
        plotSale = (plotSale +1)%HBO1.plotDrive;
    
    
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
    
    
    

