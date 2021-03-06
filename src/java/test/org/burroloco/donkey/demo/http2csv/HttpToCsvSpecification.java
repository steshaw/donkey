package org.burroloco.donkey.demo.http2csv;

import org.burroloco.donkey.trebuchet.Specification;
import org.burroloco.donkey.trebuchet.Wirer;
import org.burroloco.config.core.Config;
import org.burroloco.config.loader.ConfigLoader;

public class HttpToCsvSpecification implements Specification {
    ConfigLoader loader;

    public Config config() {
        return loader.load("config/http2csv/http2csv.properties");
    }

    public Class<? extends Wirer> wirer() {
        return HttpToCsvWirer.class;
    }
}
