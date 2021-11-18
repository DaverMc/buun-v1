package de.buun.uni.sql;

import java.sql.Connection;
import java.util.Map;

public interface Database {

    Map<String, Table<?>> getTables();

    Connection connect();

}
