package leyva.josef.xizuth.pip.lib;

import java.math.BigDecimal;

/**
 * Created by josef on 3/30/17.
 * Clase que calcula la Superficie corporal para
 * peso < 10Kg
 * peso > 10Kg
 */

public class SuperficieCorporal {

    public static final int K_SC_10 = 10;
    public static final int K_MORE_10 = 7;
    public static final int K_MORE_10_DIVIDE = 90;
    public static final int K_LESS_10_DIVIDE = 100;
    public static final int K_LESS_10 = 9;
    public static final int K_SC = 4;

    /**
     * @return Calculo de superficie corporal <strong>menor</strong> de 10 kg
     */
    public static double scLess10(double weight) {
        double r = ((weight * K_SC) + K_LESS_10) / K_LESS_10_DIVIDE;
        double s = new BigDecimal(r).setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue();
        return s;
    }

    /**
     * @return Calculo de superficie corporal <strong>Mayor</strong> de 10 kg
     */
    public static double scMore10(double weight) {
        double r = ((weight * K_SC) + K_MORE_10) / (weight + K_MORE_10_DIVIDE);
        double s = new BigDecimal(r).setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue();
        return s;
    }
}
