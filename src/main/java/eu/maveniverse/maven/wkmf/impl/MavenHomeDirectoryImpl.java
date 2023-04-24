package eu.maveniverse.maven.wkmf.impl;

import eu.maveniverse.maven.wkmf.MavenHomeDirectory;
import java.nio.file.Path;

public class MavenHomeDirectoryImpl extends MavenDirectorySupport implements MavenHomeDirectory {
    public MavenHomeDirectoryImpl(Path basedir) {
        super(basedir);
    }
}
