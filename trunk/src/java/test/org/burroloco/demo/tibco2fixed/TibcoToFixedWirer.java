package org.burroloco.demo.tibco2fixed;

import au.net.netstorm.boost.spider.api.config.wire.Wire;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import org.burroloco.config.core.Config;
import org.burroloco.config.wire.ConfigRegistrar;
import org.burroloco.donkey.config.Subject;
import org.burroloco.donkey.job.Job;
import org.burroloco.donkey.job.SafeJob;
import org.burroloco.donkey.job.TibcoListenerJob;
import org.burroloco.donkey.output.core.Spitter;
import org.burroloco.donkey.output.csv.CsvSpitter;
import org.burroloco.donkey.transformation.transform.PassThroughTransform;
import org.burroloco.donkey.transformation.transform.Transform;
import org.burroloco.donkey.trebuchet.Wirer;
import org.burroloco.donkey.input.tibco.DonkeyMessageHandler;
import org.burroloco.tibco.config.TibcoWirer;
import org.burroloco.tibco.handler.core.MessageHandler;
import org.burroloco.util.wire.Dna;

public class TibcoToFixedWirer implements Wirer {
    ConfigRegistrar registrar;
    Impl impl;
    Wire wire;
    Dna dna;

    public void wire(Config config) {
        wire.cls(PassThroughTransform.class).to(Transform.class);
        wire.cls(CsvSpitter.class).to(Spitter.class);
        tibby(config);
    }

    private void tibby(Config config) {
        Wirer tibby = impl.impl(TibcoWirer.class);
        tibby.wire(config);
        registrar.register(config, Subject.class);
        dna.strand(Job.class, SafeJob.class, TibcoListenerJob.class);
        wire.impl(DonkeyMessageHandler.class, config).to(MessageHandler.class);
    }
}