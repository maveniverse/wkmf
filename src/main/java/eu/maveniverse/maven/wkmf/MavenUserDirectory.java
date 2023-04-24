package eu.maveniverse.maven.wkmf;

import java.nio.file.Path;

public interface MavenUserDirectory {
    Path basedir();

    default Path settingsXml() {
        return basedir().resolve("settings.xml");
    }

    default Path settingsSecurityXml() {
        return basedir().resolve("settings-security.xml");
    }

    default Path toolchainsXml() {
        return basedir().resolve("toolchains.xml");
    }

    default Path localRepository() {
        return basedir().resolve("repository");
    }
}
