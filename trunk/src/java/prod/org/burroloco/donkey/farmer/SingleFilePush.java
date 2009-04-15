package org.burroloco.donkey.farmer;

import au.net.netstorm.boost.bullet.farmer.Push;
import au.net.netstorm.boost.gunge.thread.Threaded;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.config.InputFileName;
import org.burroloco.donkey.job.Job;

import java.io.File;

public class SingleFilePush implements Push {
    private Config config;
    Threaded<InputFileName> name;
    Impl impl;
    Nu nu;

    public SingleFilePush(Config config) {
        this.config = config;
    }

    public void starting() {
        throw new UnsupportedOperationException();
    }

    public void push(Object obj) {
        String fileName = ((File) obj).getPath();
        set(fileName);
        try {
            go();
        } finally {
            name.remove();
        }

    }

    private void go() {
        Job job = nu.nu(Job.class);
        job.go(config);
    }

    public void fail(Throwable t) {
        throw new UnsupportedOperationException();
    }

    private void set(String fileName) {
        InputFileName input = nu.nu(InputFileName.class, fileName);
        name.set(input);
    }
}