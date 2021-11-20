package de.buun.uni.sql.internal;

public class Valueset {

    private final ValueNode<?>[] nodes;
    private byte action; //0 nothing changed | 1 created | 2 updated | 3 deleted;

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

    public void setAction(Byte id){
        this.action = id;
    }

    public byte getAction(){
        return this.action;
    }

    public int size(){
        return this.nodes.length;
    }

    public String getSQLValue(int index){
        return String.valueOf(get(index));
    }

    public boolean getBoolean(int value){
        return value == 1;
    }

    public String[] getArray(String value){
        return value.split(",");
    }
}
