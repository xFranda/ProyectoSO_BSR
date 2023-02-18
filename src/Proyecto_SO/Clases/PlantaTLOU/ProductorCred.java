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
public class ProductorCred extends Thread{
    
    //El ProductorIntro es el productor en el problema productos-consumidos
    
    //Atributos de la clase
    
    //Semaforos (Mutex, P, E) SE
    private Semaphore Productor, Mutex,Ensamblador;
    private Drive drive;
    private boolean activo = true;
    
    public ProductorCred(Drive drive, Semaphore ProductorCred, Semaphore MutexCred, Semaphore EnsambladorCred){
        this.Productor = ProductorCred;
        this.Mutex = MutexCred;
        this.Ensamblador = EnsambladorCred;
        
        this.drive = drive;
    }
    
    @Override
    public void run(){
    
        while (activo){
            
            
            try{
           

                Productor.acquire(); //Trata de adquirir un espacio para subir la parte que le toca
                this.sleep(250); //Tiempo que tarda en subir su parte
                
                Mutex.acquire(); //Adquiere permiso total del drive
                
                drive.producirInicio();
                HBO1.Cred++;
                System.out.println("Creditos: "+HBO1.Cred);
                
                Mutex.release();
                
                Ensamblador.release();
                
            
            
            
            } catch (InterruptedException e) {
                
                JOptionPane.showMessageDialog(null, "ERROR", "Un empleado tuvo un error", JOptionPane.ERROR_MESSAGE);
                
            }
            
        }
        
    }
    
    
}
