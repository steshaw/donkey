package org.burroloco.butcher.fixture.checker.string;

public class DefaultNormaliser implements Normaliser {
    public String normalise(String raw) {
        return raw.replaceAll("\\r\\n", "\n");
    }
}
