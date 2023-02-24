/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto_SO;

import Proyecto_SO.Clases.PlantaRyM.HBO2;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

/**
 *
 * @author frand
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws FileNotFoundException, InterruptedException, ParseException, IOException {
        // TODO code application logic here
        System.out.println("Hola Gebrayel");
        Dashboard dashboard = new Dashboard();
        HBO2 gab = new HBO2(); 
        gab.start();
        }
    
}
