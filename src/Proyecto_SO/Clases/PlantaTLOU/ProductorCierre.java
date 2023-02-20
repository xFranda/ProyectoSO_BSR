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
public class ProductorCierre extends Thread{
    
    //El ProductorIntro es el productor en el problema productos-consumidos
    
    //Atributos de la clase
    
    //Semaforos (Mutex, P, E) SE
    private Semaphore Productor, Mutex,Ensamblador;
    private Drive drive;
    private boolean activo = true;
    
    public ProductorCierre(Drive drive, Semaphore ProductorCierre, Semaphore MutexCierre, Semaphore EnsambladorCierre){
        this.Productor = ProductorCierre;
        this.Mutex = MutexCierre;
        this.Ensamblador = EnsambladorCierre;
        
        this.drive = drive;
    }
    
    @Override
    public void run(){
    
        while (activo){
            
            
            try{
                

                Productor.acquire(); //Trata de adquirir un espacio para subir la parte que le toca
                this.sleep(HBO1.DiaDuracion*4); //Tiempo que tarda en subir su parte
                
                Mutex.acquire(); //Adquiere permiso total del drive
                
                drive.producirInicio();
                HBO1.Cierre++;
                System.out.println("Cierres: "+HBO1.Cierre);
                
                Mutex.release();
                
                Ensamblador.release();
                
            
            
            
            } catch (InterruptedException e) {
                
                JOptionPane.showMessageDialog(null, "ERROR", "Un empleado tuvo un error", JOptionPane.ERROR_MESSAGE);
                
            }
            
        }
        
    }
    public void DespProdCierre() {
        activo = false;
    }
    
    
}
