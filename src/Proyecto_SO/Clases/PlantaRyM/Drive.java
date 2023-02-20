/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_SO.Clases.PlantaRyM;

/**
 *
 * @author Gab
 */
public class Drive extends Thread{

    int capacidad;
    int cantidad; 
    
    public Drive(int capacidad, int cantidad){
        this.capacidad = capacidad; 
        this.cantidad = cantidad; 
    }
    
    
    public void setCapacidad(int capacidad){
        this.capacidad = capacidad; 
    }
    
    public void setCantidad(int cantidad){
        this.cantidad = cantidad; 
    }
    
    public int getCapacidad(){
        return capacidad;
    }
    
      public int getCantidad(){
        return cantidad;
      }
      
    
}
