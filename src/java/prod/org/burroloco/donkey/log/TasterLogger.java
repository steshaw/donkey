package org.burroloco.donkey.log;

import au.net.netstorm.boost.bullet.log.Log;
import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import au.net.netstorm.boost.gunge.layer.Layer;
import au.net.netstorm.boost.gunge.layer.Method;
import org.burroloco.donkey.error.core.HandledException;

public class TasterLogger implements Layer {
    private static final String THINGY = "Process";
    private Object ref;
    ThrowableMaster chuckie;
    Log log;

    public TasterLogger(Object ref) {
        this.ref = ref;
    }

    public Object invoke(Method method, Object[] args) {
        try {
            log.info(THINGY + " started");
            Object result = method.invoke(ref, args);
            log.info(THINGY + " completed successfully");
            return result;
        } catch (RuntimeException e) {
            log.error(THINGY + " internal error: ", chuckie.rootCause(e));
            log.info(THINGY + " terminated with an error");
            throw new HandledException(e);
        }
    }
}