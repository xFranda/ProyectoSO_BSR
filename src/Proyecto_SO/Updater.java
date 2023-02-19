/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto_SO;

import Proyecto_SO.Clases.PlantaTLOU.HBO1;
import javax.swing.JFrame;
/**
 *
 * @author frand
 */
public class Updater extends Thread{
    
    Dashboard dashboard;
    HBO1 hbo1;
    
    public Updater(Dashboard dashboard, HBO1 hbo1){
        this.dashboard = dashboard;
        this.hbo1 = hbo1;
        
    
    }
    
    @Override
    public void run(){
    
        while(true){
        
       dashboard.NumIntros.setText(String.valueOf(HBO1.Intro));
       dashboard.NumInicios.setText(String.valueOf(HBO1.Inicio));
       dashboard.NumCred.setText(String.valueOf(HBO1.Cred));
       dashboard.NumPlot.setText(String.valueOf(HBO1.Plot));
       dashboard.NumCierre.setText(String.valueOf(HBO1.Cierre));
       
       dashboard.CapsTLOU.setText(String.valueOf(HBO1.CapituloTLOU));
       
        
        }
    
    }
}
