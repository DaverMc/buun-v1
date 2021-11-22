package de.buun.uni.sql;

import de.buun.uni.sql.internal.Valueset;
import de.buun.uni.sql.internal.ValuesetAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SimpleTable<T> implements Table<T>{

    private final Map<T, Valueset> values;
    private final String name;
    private final List<Valueset> removedValues;
    private final Database database;
    private final Column[] columns;

    public SimpleTable(Database db, String name, Column...columns){
        this.columns = columns;
        this.name = name;
        this.database = db;
        SQLCommands.createTable(database, name, this.columns); //Wird in der Datenbank erstellt
        this.values = loadValues(); //Falls sie schon erstellt war werden alle Daten eingelesen ansonsten eine leere Map erstellt
        this.removedValues = new ArrayList<>();
    }

    @Override
    public Valueset getValues(T key) {
        return this.values.get(key);
    }

    @Override
    public void addValues(Valueset values) {
        values.setAction((byte) 1);
        this.values.put(values.get(0), values);
    }

    @Override
    public boolean updateValues(T key, ValuesetAction action) {
        Valueset set = getValues(key);
        if(set == null) return false;
        if(!action.run(set)) return false;
        set.setAction((byte) 2);
        return true;
    }

    @Override
    public boolean deleteValues(T key) {
        Valueset set = this.values.remove(key);
        if(set == null) return false;
        set.setAction((byte) 3);
        this.removedValues.add(set);
        return false;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void postUpdate() {
        this.removedValues.forEach(set -> SQLCommands.delete(this.database, this.name, createCondition(set)));
        this.removedValues.clear();
        this.values.values().stream()
                .filter(set -> set.getAction() != (byte) 0)
                .forEach(set -> {
                    switch (set.getAction()) {
                        case 1 :SQLCommands.insert(this.database, this.name, set);
                        break;
                        case 2 : SQLCommands.update(this.database, this, set);
                        break;
                    }
                    set.setAction((byte) 0);
                });
    }

    private String createCondition(Valueset set){
        return columns[0].name + "=" + set.get(0);
    }

    @Override
    public Column[] columns() {
        return this.columns;
    }

    private Map<T, Valueset> loadValues(){
        return SQLCommands.selectAll(this.database, this.name, this.columns)
                .stream()
                .collect(Collectors.toMap(set -> set.get(0), Function.identity()));
    }
}
