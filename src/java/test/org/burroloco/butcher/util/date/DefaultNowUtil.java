package org.burroloco.butcher.util.date;

// OK IllegalRegexp {
import java.text.SimpleDateFormat;
import java.util.Date;

public class DefaultNowUtil implements NowUtil {
    public String format(String pattern) {
        return new SimpleDateFormat(pattern).format(new Date());
    }
}
// }