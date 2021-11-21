package de.buun.uni.math;

public class Maths {

    public static int[] fromString(String string){
        try {
            return new int[]{Integer.parseInt(string)};
        }catch (NumberFormatException e){
            return new int[]{0,0};
        }
    }

}
