package org.burroloco.donkey.job;

import au.net.netstorm.boost.bullet.log.Log;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.input.core.Slurper;
import org.burroloco.donkey.transformation.gargler.Gargler;

public class SlurpingJob implements Job {
    Slurper slurper;
    Gargler gargler;
    Log log;

    public void go(Config config) {
        log.info("Process started");
        Cake slurped = slurper.slurp(config);
        gargler.slosh(config, slurped);
        log.info("Process completed successfully");
    }
}
