package org.burroloco.donkey.trebuchet;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import junit.framework.AssertionFailedError;
import org.burroloco.config.core.Config;

public class DummyPayload extends Primordial implements Payload {
    public Config config() {
        throw new AssertionFailedError();
    }

    public Class<? extends Wirer> wirer() {
        throw new AssertionFailedError();
    }

    public Class<? extends Donkey> donkey() {
        throw new AssertionFailedError();
    }
}
