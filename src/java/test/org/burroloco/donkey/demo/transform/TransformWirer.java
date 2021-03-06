package org.burroloco.donkey.demo.transform;

import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.error.transform.Burper;
import org.burroloco.donkey.error.transform.SwallowingBurper;
import org.burroloco.donkey.input.core.Slurper;
import org.burroloco.donkey.input.database.DatabaseSlurper;
import org.burroloco.donkey.job.Job;
import org.burroloco.donkey.job.PukingJob;
import org.burroloco.donkey.job.SlurpingJob;
import org.burroloco.donkey.output.core.Spitter;
import org.burroloco.donkey.output.csv.CsvSpitter;
import org.burroloco.donkey.transformation.transform.Mapper;
import org.burroloco.donkey.transformation.transform.PropertyFileMapper;
import org.burroloco.donkey.transformation.transform.Transform;
import org.burroloco.donkey.trebuchet.Wirer;
import org.burroloco.util.wire.Dna;

public class TransformWirer implements Wirer {
    private static final String FULLNAME_MAPPINGS = "config/transform/fullname-mappings.properties";
     //SIMIAN OFF
    Wire wire;
    Dna dna;
    //SIMIAN ON

    public void wire(Config config) {
        slurp();
        transform();
        wire.cls(CsvSpitter.class).to(Spitter.class);
    }

    private void slurp() {
        dna.strand(Job.class, PukingJob.class, SlurpingJob.class);
        wire.cls(DatabaseSlurper.class).to(Slurper.class);
    }

    private void transform() {
        dna.strand(Burper.class, SwallowingBurper.class);
        wire.impl(PropertyFileMapper.class, FULLNAME_MAPPINGS).to(Mapper.class);
        wire.cls(FullNameTransform.class).to(Transform.class);
    }
}