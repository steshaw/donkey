package org.burroloco.donkey.output.template;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;

public interface TemplateStringer {
    String text(Config config, Cake cake);
}
