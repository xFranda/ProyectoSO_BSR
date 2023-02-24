package Proyecto_SO.Clases.PlantaGoT;

import java.util.HashMap;
import java.util.Random;

public class Productor {
    private HashMap<String, Integer> almacenamiento = new HashMap<>();
    public int capitulo = 0;
    public double ganancia = 0;

    public Productor() {
        almacenamiento.put("intro", 0);
        almacenamiento.put("inicio", 0);
        almacenamiento.put("cierres", 0);
        almacenamiento.put("creditos", 0);
        almacenamiento.put("plot", 0);
    }
    
    public HashMap<String, Integer> getDiccionario() {
        return almacenamiento;
    }

    private boolean hayEspacio(String variable) {
        switch (variable) {
            case "intro":
                return almacenamiento.get(variable) <= 29;
            case "inicio":
                return almacenamiento.get(variable) <= 49;
            case "cierres":
                return almacenamiento.get(variable) <= 54;
            case "creditos":
                return almacenamiento.get(variable) <= 24;
            case "plot":
                return almacenamiento.get(variable) <= 39;
            default:
                return false;
        }
    }

    public void prodIntro() {
        String variable = "intro";
        if (hayEspacio(variable)) {
            almacenamiento.put(variable, almacenamiento.get(variable) + 1);
        }
        if (hayEspacio(variable)) {
            almacenamiento.put(variable, almacenamiento.get(variable) + 1);
        }
    }

    public void prodInicio(int dia) {
        if (dia % 3 == 0) {
        String variable = "inicio";
        if (hayEspacio(variable)) {
            almacenamiento.put(variable, almacenamiento.get(variable) + 1);
        }
    }}

    public void prodCreditos() {
        String variable = "creditos";
        if (hayEspacio(variable)) {
            almacenamiento.put(variable, almacenamiento.get(variable) + 1);
        }
        if (hayEspacio(variable)) {
            almacenamiento.put(variable, almacenamiento.get(variable) + 1);
        }
    }

    public void prodCierre(int dia) {
        if (dia % 2 == 0) {
        String variable = "cierres";
        if (hayEspacio(variable)) {
            almacenamiento.put(variable, almacenamiento.get(variable) + 1);
        }
    }}

    public void prodPlot(int dia) {
        if (dia % 2 == 0) {
        String variable = "plot";
        if (hayEspacio(variable)) {
            almacenamiento.put(variable, almacenamiento.get(variable) + 1);
        }
    }}

    public void ensamblar(int dia, int capitulos) {
        if (dia % 4 == 0 && dia != 0) {
            if (capitulos % 5 == 0 && capitulos != 0) {
                if (almacenamiento.get("intro") > 0 && almacenamiento.get("inicio") > 0 && almacenamiento.get("creditos") > 0 && almacenamiento.get("plot") > 0 && almacenamiento.get("cierres") > 1) {
                    almacenamiento.put("intro", almacenamiento.get("intro") - 1);
                    almacenamiento.put("inicio", almacenamiento.get("inicio") - 1);
                    almacenamiento.put("creditos", almacenamiento.get("creditos") - 1);
                    almacenamiento.put("cierres", almacenamiento.get("cierres") - 2);
                    almacenamiento.put("plot", almacenamiento.get("plot") - 1);
                    capituloProducido(true);
                }
            } else {
                if (almacenamiento.get("intro") > 0 && almacenamiento.get("inicio") > 0 && almacenamiento.get("creditos") > 0 && almacenamiento.get("cierres") > 1) {
                    almacenamiento.put("intro", almacenamiento.get("intro") - 1);
                    almacenamiento.put("inicio", almacenamiento.get("inicio") - 1);
                    almacenamiento.put("creditos", almacenamiento.get("creditos") - 1);
                    almacenamiento.put("cierres", almacenamiento.get("cierres") - 2);
                    capituloProducido(false);
                }
            }
        }
    }

    private void capituloProducido(boolean plot) {
        capitulo++;
        if (plot) {
            int extra = new Random().nextInt(91) + 10;
            ganancia += (653333.33f + (((extra * 100) / 150) * 1000));
        } else {
            ganancia += 6533333.33f;
                    }
    }
    
    
}