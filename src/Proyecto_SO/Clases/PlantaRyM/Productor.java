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
    
    protected Semaphore x;
    protected Semaphore ensamblador;
    protected Semaphore productor;

    public Productor(Semaphore x, Semaphore ensamblador, Semaphore productor) {
        this.x = x;
        this.ensamblador = ensamblador;
        this.productor = productor;

    }
    
    public abstract void run();

}
    

