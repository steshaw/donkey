package org.burroloco.test.util.dbunit;

import edge.org.dbunit.database.IDatabaseConnection;

public interface Querifier {
    String getSingleValue(String query, IDatabaseConnection connection, String columnName);
}