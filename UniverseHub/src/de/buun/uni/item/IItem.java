package de.buun.uni.item;

public interface IItem<T> {

    T toMinecraftStack(Item item);

}
