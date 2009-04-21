package org.burroloco.test.util.string;

import java.util.List;
import java.util.regex.Pattern;

public interface StringGroupFinder {
    List<String> find(String s, Pattern pattern, int groupNumber);
}
