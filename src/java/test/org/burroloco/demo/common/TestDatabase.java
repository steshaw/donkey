package org.burroloco.demo.common;

public interface TestDatabase {
    void create();

    void drop();

    Integer count(String table);

}
