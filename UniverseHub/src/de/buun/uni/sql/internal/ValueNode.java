package de.buun.uni.sql.internal;

public class ValueNode<T> {

    private final T value;

    public ValueNode(T value){
        this.value = value;
    }

    public T getValue(){
        return value;
    }
}
