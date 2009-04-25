package org.burroloco.donkey.output.database;

import au.net.netstorm.boost.gunge.goop.DefaultNvp;
import au.net.netstorm.boost.gunge.goop.Nvp;
import org.burroloco.config.core.Config;
import org.burroloco.config.core.Configs;
import org.burroloco.donkey.config.Sql;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.data.cake.Slice;
import org.burroloco.donkey.output.core.Spitter;
import org.burroloco.donkey.output.replacing.TemplateSliceExpander;

import java.util.List;

public class DatabaseSpitter implements Spitter {
    TemplateSliceExpander expander;
    Executor runner;
    Configs configs;

    public void pertuh(Config config, Cake cake) {
        List<Slice> slices = cake.slices();
        for (Slice slice : slices) {
            Config c = sql(config, slice);
            runner.execute(c);
        }
    }

    private Config sql(Config config, Slice slice) {
        String expanded = expander.expand(config, slice);
        String nice = unquoteNull(expanded);
        Nvp sql = new DefaultNvp(Sql.NAME, nice);
        return configs.moosh(config, sql);
    }

    private String unquoteNull(String expanded) {
        return expanded.replaceAll("\'null\'", "null");
    }
}
