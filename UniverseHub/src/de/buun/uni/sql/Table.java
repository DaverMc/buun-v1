package de.buun.uni.sql;

import de.buun.uni.sql.internal.Valueset;
import de.buun.uni.sql.internal.ValuesetAction;

public interface Table<K> {

    Valueset getValues(K key);

    void addValues(Valueset values);

    boolean updateValues(K key, ValuesetAction action);

    boolean deleteValues(K key);

    String getName();

    void postUpdate();

    Column[] columns();

}
