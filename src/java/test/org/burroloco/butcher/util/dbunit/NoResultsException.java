package org.burroloco.butcher.util.dbunit;

public class NoResultsException extends RuntimeException {
    public NoResultsException(String sql) {
        super("Query returned no results: '" + sql + "'");
    }
}
