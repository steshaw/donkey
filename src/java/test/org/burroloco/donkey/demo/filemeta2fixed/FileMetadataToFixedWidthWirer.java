package org.burroloco.donkey.demo.filemeta2fixed;

import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.input.core.Slurper;
import org.burroloco.donkey.input.file.FileMetadataSlurper;
import org.burroloco.donkey.job.Job;
import org.burroloco.donkey.job.PukingJob;
import org.burroloco.donkey.job.SlurpingJob;
import org.burroloco.donkey.output.core.Spitter;
import org.burroloco.donkey.output.fixedwidth.FixedRecordDefinition;
import org.burroloco.donkey.output.fixedwidth.FixedWidthRecordSpitter;
import org.burroloco.donkey.transformation.transform.NoOpTransform;
import org.burroloco.donkey.transformation.transform.Transform;
import org.burroloco.donkey.trebuchet.Wirer;
import org.burroloco.util.wire.Dna;

public class FileMetadataToFixedWidthWirer implements Wirer {
    Wire wire;
    Dna dna;

    //SIMIAN OFF
    public void wire(Config config) {
        dna.strand(Job.class, PukingJob.class, SlurpingJob.class);
        wire.cls(FileMetadataSlurper.class).to(Slurper.class);
        wire.cls(NoOpTransform.class).to(Transform.class);
        wire.cls(FileMetadataFixedRecordDefinition.class).to(FixedRecordDefinition.class);
        wire.cls(FixedWidthRecordSpitter.class).to(Spitter.class);
    }
    //SIMIAN ON
}
