package de.buun.uni.math;

import de.buun.uni.UniverseException;
import de.buun.uni.log.Loggers;
import de.buun.uni.util.ArrayIterator;

public class Vector {

    private final double[] values;

    public Vector(double...values){
        this.values = values;
    }

    public double get(int id){
        return values[id];
    }

    public void set(double value, int id){
        this.values[id] = value;
    }

    public int size(){
        return this.values.length;
    }

    public void add(Vector vector){
        add(vector, 1);
    }

    public void substract(Vector vector){
        add(vector, -1);
    }

    public void add(Vector vector, double factor){
        if(vector.size() != size()) {
            Loggers.log(new UniverseException("Vectors have to have the same size to add!"));
            return;
        }
        ArrayIterator.forIndex(size(), i -> {
            values[i] += factor * vector.get(i);
        });
    }

}
