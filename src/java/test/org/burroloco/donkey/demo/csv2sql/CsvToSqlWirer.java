package org.burroloco.donkey.demo.csv2sql;

import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.input.core.Slurper;
import org.burroloco.donkey.input.csv.CsvSlurper;
import org.burroloco.donkey.job.Job;
import org.burroloco.donkey.job.PukingJob;
import org.burroloco.donkey.job.SlurpingJob;
import org.burroloco.donkey.output.core.Spitter;
import org.burroloco.donkey.output.file.FileSpitter;
import org.burroloco.donkey.transformation.transform.NoOpTransform;
import org.burroloco.donkey.transformation.transform.Transform;
import org.burroloco.donkey.trebuchet.Wirer;
import org.burroloco.util.wire.Dna;

public class CsvToSqlWirer implements Wirer {
    Wire wire;
    Dna dna;

    public void wire(Config config) {
        dna.strand(Job.class, PukingJob.class, SlurpingJob.class);
        wire.cls(CsvSlurper.class).to(Slurper.class);
        wire.cls(NoOpTransform.class).to(Transform.class);
        wire.cls(FileSpitter.class).to(Spitter.class);
    }
}
