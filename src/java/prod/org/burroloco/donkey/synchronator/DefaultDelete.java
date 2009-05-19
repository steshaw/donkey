package org.burroloco.donkey.synchronator;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.data.cake.Patissier;
import org.burroloco.donkey.output.core.Spitter;

public class DefaultDelete implements Delete {
    Patissier patissier;
    Spitter spitter;

    public void execute(Config c, String[] keys, Cake older, Cake newer) {
        Cake updates = patissier.minus(older, newer, keys);
        spitter.pertuh(c, updates);
    }
}
