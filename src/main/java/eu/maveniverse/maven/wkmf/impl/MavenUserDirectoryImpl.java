package eu.maveniverse.maven.wkmf.impl;

import eu.maveniverse.maven.wkmf.MavenUserDirectory;
import java.nio.file.Path;

public class MavenUserDirectoryImpl extends MavenDirectorySupport implements MavenUserDirectory {
    public MavenUserDirectoryImpl(Path basedir) {
        super(basedir);
    }
}
