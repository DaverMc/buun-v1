package de.buun.uni.sql.internal;

public class Valueset {

    private final ValueNode<?>[] nodes;

    public Valueset(int size){
        this.nodes = new ValueNode[size];
    }

    public <T> T get(int index){
        return (T) this.nodes[index].getValue();
    }

    public <T> void setValue(int index, T obj){
        ValueNode<T> node = new ValueNode<>(obj);
        this.nodes[index] = node;
    }
}
