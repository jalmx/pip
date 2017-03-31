package leyva.josef.xizuth.pip.lib;

import android.util.Log;

/**
 * Created by josef on 3/30/17.
 * Calculo
 */

public class PerdidaInsensible {

    /**Constante para Fiebre*/
    public static final int K_FEVER = 800;
    /**Constante para NO Fiebre*/
    public static final int K_NO_FEVER = 600;

    /***/
    private final double TURN;
    private final double piF;
    private final double piNF;

    public PerdidaInsensible(double sc, double hrsWithFever, double TURN) {
        this.TURN = TURN;
        piF = piFever(sc,hrsWithFever);

        piNF = piNoFever(sc,TURN - hrsWithFever);

    }

    /**@return Calculo de Perdida insensible <strong>CON</strong> Fiebre*/
    private double piFever(double sc, double hrsWithFever){
        return (sc * K_FEVER * hrsWithFever)/TURN;
    }

    /**@return Calculo de Perdida insensible <strong>SIN</strong> Fiebre*/
    private double piNoFever(double sc, double hrsWithoutFever){
        return (sc * K_NO_FEVER * hrsWithoutFever)/TURN;
    }

    public double getTURN() {
        return TURN;
    }

    /**@return el total en mililitros a suministrar*/
    public double piTotal(){
        return piF + piNF;
    }

}
