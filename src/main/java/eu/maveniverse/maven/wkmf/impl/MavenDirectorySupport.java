package eu.maveniverse.maven.wkmf.impl;

import static java.util.Objects.requireNonNull;

import java.nio.file.Path;

abstract class MavenDirectorySupport {
    private final Path basedir;

    protected MavenDirectorySupport(Path basedir) {
        this.basedir = requireNonNull(basedir);
    }

    public Path basedir() {
        return basedir;
    }
}
