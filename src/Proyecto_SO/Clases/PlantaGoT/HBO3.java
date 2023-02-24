/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_SO.Clases.PlantaGoT;

import java.util.HashMap;

/**
 *
 * @author Roy
 */
public class HBO3 {
    
    //variables generales
    
    public static int productores = 14; //faltan 6 que serian los ya usandose. Para un total de 10 + 4 de mi cedula
    public static int dia = 0;
    public static int capitulo = 0;
    private Productor productor;
    public static HashMap almacenamiento;
    public static double ganancia;
    
    //variables de los productores

    public    int intro = 1;
    public    int creditos = 1;
    public    int inicio = 1;
    public    int cierre = 1;
    public    int plot = 1;
    public    int assembler = 1;
        

        public void start(int intro, int creditos, int inicio, int cierre, int plot, int assembler) {
            productor = new Productor();
            almacenamiento = productor.getDiccionario();
            
            Thread hilo = new Thread(new Runnable() {
                @Override
            public void run() {
                 while (true) {
                     for (int i = 1; i <= intro ; i++) {
                        productor.prodIntro();}
                     for (int i = 1; i <= inicio ; i++) {
                        productor.prodInicio(dia);}
                     for (int i = 1; i <= cierre ; i++) {
                        productor.prodCierre(dia);}
                     for (int i = 1; i <= creditos ; i++) {
                        productor.prodCreditos();}
                     for (int i = 1; i <= plot ; i++) {
                        productor.prodPlot(dia);}
                     for (int i = 1; i <= assembler ; i++) {
                        productor.ensamblar(dia, capitulo);}
                        capitulo = productor.capitulo;
                        almacenamiento = productor.getDiccionario();
                    dia++;
                     //System.out.println(dia);
                     //System.out.println(String.valueOf(almacenamiento.get("plot")));
                     if (dia == 30) {
            ganancia = productor.ganancia;}
                    try {
                        Thread.sleep(5000);
                        } catch (InterruptedException e) {
                        e.printStackTrace();
                }
            }
        }
    });
    hilo.start();
}
        
        
    }


    

