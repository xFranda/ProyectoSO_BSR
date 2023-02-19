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

public abstract class Productor extends Thread {
    
    protected Semaphore ensamblador;
    protected Semaphore productor;
    protected Semaphore activo; 
    protected Drive drive; 
    

    public Productor(Drive drive, Semaphore ensamblador, Semaphore productor, Semaphore activo) {
        this.ensamblador = ensamblador;
        this.productor = productor;
        this.activo = activo;
        this.drive = drive; 

    }
    
    public abstract void run();

}
    

