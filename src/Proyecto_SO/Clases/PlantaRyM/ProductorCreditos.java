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
    
    public ProductorCreditos(Semaphore ensamblador, Semaphore productor, Semaphore activo){
        super(ensamblador, productor, activo);
        
    }
    @Override
    public void run(){
        
    }
    
}
