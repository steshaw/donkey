package org.burroloco.donkey.error.listener.core;

import org.burroloco.config.core.Config;

public interface Puker {
    void error(Config config, Exception exception);
}
