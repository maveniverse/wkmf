package eu.maveniverse.maven.wkmf;

import java.nio.file.Path;

/**
 * Well known Maven files.
 */
public interface WKMF {
    Path userHome();

    Path cwd();

    MavenHomeDirectory mavenHomeDirectory();

    MavenUserDirectory mavenUserDirectory();

    Path globalToolchainsXml();

    Path userToolchainsXml();

    Path globalSettingsXml();

    Path userSettingsXml();

    Path userSettingsSecurityXml();
}
