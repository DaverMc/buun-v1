package de.buun.uni.sql.internal;

public record ValueNode<T>(T value) {

    public T getValue(){
        return value;
    }
}
