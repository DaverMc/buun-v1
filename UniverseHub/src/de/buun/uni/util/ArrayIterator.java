package de.buun.uni.util;

public interface ArrayIterator {

    void run(int index);

    static void forIndex(int start, int max, ArrayIterator loop){
        for(int i = start; i < max; i++){
            loop.run(i);
        }
    }

    static void forIndex(int max, ArrayIterator loop){
        forIndex(0, max, loop);
    }

}
