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
public class ProductorInicio extends Productor{
    
      public int dCantidadInicio;
      public int cantidadMaxInicio;
    
    public ProductorInicio(Drive drive, Semaphore ensamblador, Semaphore productor, Semaphore activo){
        super(drive, ensamblador, productor, activo);
        
    }
    @Override
    public void run(){
        
        while(true){
            try{
            if(this.drive.getCantidad()< this.drive.getCapacidad()){
                this.productor.acquire();
                this.sleep(HBO2.duracionDia*4);
                this.ensamblador.acquire();
                this.drive.setCantidad(this.drive.getCantidad()+1);
                dCantidadInicio = this.drive.getCantidad();
                
                this.productor.release();
                this.ensamblador.release();
                
                                        
                
            }
            }catch (Exception e){
                    System.out.println("Dio error");
                    }
                
            
        }
        
    }
}
