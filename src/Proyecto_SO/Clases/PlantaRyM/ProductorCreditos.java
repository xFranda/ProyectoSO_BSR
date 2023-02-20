/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_SO.Clases.PlantaRyM;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Gab
 */
public class ProductorCreditos extends Productor{
    
      public int dCantidadCreditos; 
      public int cantidadMaxCreditos; 
    
    public ProductorCreditos(Drive drive, Semaphore ensamblador, Semaphore productor, Semaphore activo){
        super(drive, ensamblador, productor, activo);
        
    }
    @Override
    public void run(){
        
        while(true){
            try{
            if(this.drive.getCantidad()< this.drive.getCapacidad()){
                this.productor.acquire();
                this.sleep(HBO2.duracionDia/3);
                
                this.ensamblador.acquire();
                this.drive.setCantidad(this.drive.getCantidad()+1);
                dCantidadCreditos = this.drive.getCantidad();
                System.out.println("Creditos:" + dCantidadCreditos);
                this.productor.release();
                this.ensamblador.release();
                                       
                
            }
            }catch (Exception e){
                    System.out.println("Dio error");
                    }
                
            
        }
        
    }
    
}
