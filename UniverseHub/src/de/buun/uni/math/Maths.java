package de.buun.uni.math;

import de.buun.uni.log.Loggers;

public class Maths {

    public static int[] fromString(String string){
        try {
            return new int[]{Integer.parseInt(string)};
        }catch (NumberFormatException e){
            Loggers.log(e);
            return new int[]{0,0};
        }
    }

}
