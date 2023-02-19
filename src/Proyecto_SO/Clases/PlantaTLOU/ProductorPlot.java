/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto_SO.Clases.PlantaTLOU;

import java.util.Set;
import java.util.concurrent.Semaphore;
import javax.swing.JOptionPane;
/**
 *
 * @author frand
 */
public class ProductorPlot extends Thread{
    
    //El ProductorIntro es el productor en el problema productos-consumidos
    
    //Atributos de la clase
    
    //Semaforos (Mutex, P, E) SE
    private Semaphore Productor, Mutex,Ensamblador;
    private Drive drive;
    private boolean activo = true;
    
    public ProductorPlot(Drive drive, Semaphore ProductorPlot, Semaphore MutexPlot, Semaphore EnsambladorPlot){
        this.Productor = ProductorPlot;
        this.Mutex = MutexPlot;
        this.Ensamblador = EnsambladorPlot;
        
        this.drive = drive;
    }
    
    @Override
    public void run(){
    
        while (activo){
            
            
            try{
           

                Productor.acquire(); //Trata de adquirir un espacio para subir la parte que le toca
                this.sleep(2000); //Tiempo que tarda en subir su parte
                
                Mutex.acquire(); //Adquiere permiso total del drive
                
                drive.producirInicio();
                HBO1.Plot++;
                System.out.println("Plot: "+HBO1.Plot);
                
                Mutex.release();
                
                Ensamblador.release();
                
            
            
            
            } catch (InterruptedException e) {
                
                JOptionPane.showMessageDialog(null, "ERROR", "Un empleado tuvo un error", JOptionPane.ERROR_MESSAGE);
                
            }
            
        }
        
    }
    public void DespProdPlot() {
        activo = false;
    }
    
    
}
