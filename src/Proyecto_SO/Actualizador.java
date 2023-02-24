/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto_SO;

import Proyecto_SO.Clases.PlantaRyM.HBO2;
import Proyecto_SO.Clases.PlantaTLOU.Dia;
import Proyecto_SO.Clases.PlantaTLOU.Director;
import Proyecto_SO.Clases.PlantaTLOU.HBO1;
import Proyecto_SO.Clases.PlantaTLOU.ProyectM;
import javax.swing.JFrame;
/**
 *
 * @author frand
 */
public class Actualizador extends Thread{
    
    Dashboard dashboard;
    HBO1 hbo1;
    private static boolean activo = true;
    HBO2 hbo2; 
    
    public Actualizador(Dashboard dashboard, HBO1 hbo1){
        this.dashboard = dashboard;
        this.hbo1 = hbo1;
        
    
    }
    
    @Override
    public void run(){
    
        while(activo){
        
            
      // The Last of Us
       dashboard.NumIntros.setText(String.valueOf(HBO1.Intro));
       dashboard.NumInicios.setText(String.valueOf(HBO1.Inicio));
       dashboard.NumCred.setText(String.valueOf(HBO1.Cred));
       dashboard.NumPlot.setText(String.valueOf(HBO1.Plot));
       dashboard.NumCierre.setText(String.valueOf(HBO1.Cierre));
 
       dashboard.CapsTLOU.setText(String.valueOf(HBO1.CapituloTLOU));
       
       dashboard.NumEmpIntros.setText(String.valueOf(HBO1.prodIntro));
       dashboard.NumEmpInicios.setText(String.valueOf(HBO1.prodInicio));
       dashboard.NumEmpCred.setText(String.valueOf(HBO1.prodCred));
       dashboard.NumEmpPlot.setText(String.valueOf(HBO1.prodPlot));
       dashboard.NumEmpCierre.setText(String.valueOf(HBO1.prodCierre));
       dashboard.NumEmpEnsamblador.setText(String.valueOf(HBO1.ensamblador));
       
       dashboard.NumEmpDispo.setText(String.valueOf(HBO1.empleadosMax-(HBO1.prodIntro+HBO1.prodInicio+HBO1.prodCred+HBO1.prodPlot+HBO1.prodCierre+HBO1.ensamblador)));
       
       dashboard.PMStatus.setText(String.valueOf(ProyectM.PM));
       dashboard.DirTLOU.setText(String.valueOf(Director.DIR));
       dashboard.DiasRestantesTLOU.setText(String.valueOf(Dia.Dia));
       dashboard.GananciasTLOU.setText(String.valueOf(HBO1.Ganancias));
       dashboard.FallasPM.setText(String.valueOf(Director.contadorRM));
       dashboard.GastosMensuales.setText(String.valueOf(HBO1.GastosM));
       dashboard.UltimoLoteTLOU.setText(String.valueOf(HBO1.LoteTLOU));
       dashboard.GananciasUL.setText(String.valueOf(HBO1.GananciasLote));
       
       // Rick y Morty
       dashboard.NumIntrosRM.setText(String.valueOf(HBO2.cantidadIntro));
       dashboard.NumIniciosRM.setText(String.valueOf(HBO2.cantidadInicio));    
       dashboard.NumCreditosRM.setText(String.valueOf(HBO2.cantidadCreditos));
       dashboard.NumPTwistRM.setText(String.valueOf(HBO2.cantidadPTwist));
       dashboard.NumCierresRM.setText(String.valueOf(HBO2.cantidadCierre));
       dashboard.NumCapRM.setText(String.valueOf(HBO2.capitulos));
       
        }
    
    }
    public static void Stop(){
    activo=false;
    }
    /**public void Reinicio(){
    this.start();
    }*/
}
