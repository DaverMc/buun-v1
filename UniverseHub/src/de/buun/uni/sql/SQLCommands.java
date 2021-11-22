package de.buun.uni.sql;

import de.buun.uni.UniverseException;
import de.buun.uni.log.Loggers;
import de.buun.uni.sql.internal.Valueset;
import de.buun.uni.util.ArrayIterator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SQLCommands {

    /*
        INSERT INTO table_name VALUES (value1, value2, value3, ...);
     */
    protected static void insert(Database database, String tableName, Valueset set){
        StringBuilder sqlCommand = new StringBuilder("INSERT INTO ")
                .append(tableName)
                .append(" VALUES (");
        ArrayIterator.forIndex(set.size(), i ->
            sqlCommand.append(set.getSQLValue(i))
                    .append(",")
        );
        sqlCommand.delete(sqlCommand.length() - 1, sqlCommand.length() - 1)
                .append(");");
        executeSQL(sqlCommand.toString(), database, false);
    }

    /*UPDATE table_name
    SET column1 = value1, column2 = value2, ...
    WHERE condition;*/
    protected static void update(Database database, Table<?> table, Valueset set){
        StringBuilder sqlCommand = new StringBuilder("UPDATE" )
                .append(table.getName())
                .append(" SET ");
        ArrayIterator.forIndex(set.size(), i ->
            sqlCommand.append(table.columns()[i].name)
                    .append("=")
                    .append(String.valueOf(set.get(i)))
                    .append(",")
        );
        sqlCommand.delete(sqlCommand.length() - 1, sqlCommand.length() - 1)
                .append(" WHERE ")
                .append(table.columns()[0].name)
                .append("=")
                .append(String.valueOf(set.get(0)));
        executeSQL(sqlCommand.toString(), database, false);

    }
//DELETE FROM table_name WHERE condition;
    protected static void delete(Database database, String tableName, String condition){
        String sqlCommand = "DELETE FROM " +
                tableName +
                " WHERE " +
                condition +
                ";";
        executeSQL(sqlCommand, database, false);
    }

    protected static void createTable(Database database, String tableName, Column...columns){
        StringBuilder sqlCommand = new StringBuilder("CREATE TABLE IF NOT EXISTS ")
                .append(tableName)
                .append(" (");
        for(Column c : columns){
            sqlCommand.append(c.name)
                    .append(" ")
                    .append(c.type.getSql())
                    .append(",");
        }
        sqlCommand.delete(sqlCommand.length() - 1, sqlCommand.length() - 1)
                .append(");");
        executeSQL(sqlCommand.toString(), database, false);
    }

    protected static List<Valueset> selectAll(Database database, String tableName, Column[] columns){
        String sqlCommand = "SELECT * FROM " + tableName;
        ResultSet set = executeSQL(sqlCommand, database, true);
        if(set == null) return new ArrayList<>();
        try{
            return processResult(set, columns);
        }catch (SQLException e){
            Loggers.log(e);
            return new ArrayList<>();
        }
    }

    private static List<Valueset> processResult(ResultSet set, Column[] columns) throws SQLException{
        List<Valueset> list = new ArrayList<>();
        while(set.next()){
            Valueset newSet = new Valueset(columns.length);
            ArrayIterator.forIndex(columns.length, i -> {
                try {
                    newSet.setValue(i, set.getObject(i, columns[i].type.getJavaClass()));
                }catch (SQLException e) {
                    Loggers.log(e);
                }
            });
        }
        return list;
    }

    private static ResultSet executeSQL(String command, Database database, boolean result){
        if(!database.isConnected()){
            Loggers.log(new UniverseException("Database is not connected!"));
            return null;
        }
        Connection connection = database.connect();
        try{
            if(!result){
                Statement statement = connection.createStatement();
                statement.execute(command);
                return null;
            }
            PreparedStatement statement = connection.prepareStatement(command);
            return statement.executeQuery();
        }catch (SQLException e) {
            Loggers.log(e);
            return null;
        }
    }
}
