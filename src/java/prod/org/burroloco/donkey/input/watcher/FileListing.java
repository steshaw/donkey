package org.burroloco.donkey.input.watcher;

import java.io.File;
import java.util.List;

public interface FileListing {
    List<File> list(File dir);
}
