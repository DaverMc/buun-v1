package de.buun.uni.util;

import de.buun.uni.log.Loggers;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Reflections {

    public static <T> T getValue(Object obj, String fieldName){
        Field field = null;
        T value;
        try {
            field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return (T) field.get(obj);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            Loggers.log(e);
            return null;
        }
    }

    public static Constructor<?> getConstructor(Class<?> clazz, Object...args){
        Class<?>[] parameters = new Class[args.length];
        ArrayIterator.forIndex(args.length, i -> {
            parameters[i] = args[i].getClass();
        });
        try {
            return clazz.getConstructor(parameters);
        }catch (NoSuchMethodException e) {
            Loggers.log(e);
            return null;
        }
    }

}
