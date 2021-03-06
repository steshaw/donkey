package org.burroloco.butcher.fixture.database;

import edge.java.sql.Statement;

public class DefaultInputDatabase implements InputDatabase {
    private static final String NAME = "input";
    MemoryDatabase database;

    public void create() {
        Statement s = database.statement(NAME);
        employee(s);
        address(s);
        s.close();
    }

    private void employee(Statement s) {
        s.execute("CREATE TABLE EMPLOYEE(ID INT, NAME VARCHAR, SALARY INT, START DATE)");
        s.execute("INSERT INTO EMPLOYEE (ID, NAME, SALARY, START) VALUES (1, 'Fred', 1000000, '2001-01-01');");
        s.execute("INSERT INTO EMPLOYEE (ID, NAME, SALARY, START) VALUES (2, 'Wilma', 2000000, '2002-01-01');");
        s.execute("INSERT INTO EMPLOYEE (ID, NAME, SALARY, START) VALUES (3, 'Barney', 3000000, '2003-01-01');");
        s.execute("INSERT INTO EMPLOYEE (ID, NAME, SALARY, START) VALUES (4, 'Betty', 4000000, null);");
        s.execute("INSERT INTO EMPLOYEE (ID, NAME, SALARY, START) VALUES (5, 'Dino', 0, null);");
    }

    private void address(Statement s) {
        s.execute("CREATE TABLE ADDRESS(ID INT, EMPLOYEE_ID INT, ADDRESS VARCHAR)");
        s.execute("INSERT INTO ADDRESS (ID, EMPLOYEE_ID, ADDRESS) VALUES (1, 1, '123 Pleasant Crescent, Rockville');");
    }

    public void drop() {
        Statement s = database.statement(NAME);
        s.execute("DROP TABLE EMPLOYEE");
        s.execute("DROP TABLE ADDRESS");
        s.close();
    }

    public Integer count(String table) {
        return database.count(NAME, table);
    }
}
