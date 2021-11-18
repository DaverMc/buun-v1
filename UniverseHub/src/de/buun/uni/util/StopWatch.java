package de.buun.uni.util;

public interface StopWatch {

    void run();

    public static float stopTime(StopWatch watch){
        float start = System.currentTimeMillis();
        watch.run();
        return System.currentTimeMillis() - start;
    }

}
