package org.burroloco.donkey.output.file;

import java.io.File;

public interface FileWizard {
    File file(String dirname, String filename, String ext);
}
