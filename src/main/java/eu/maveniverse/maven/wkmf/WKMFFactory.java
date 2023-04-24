package eu.maveniverse.maven.wkmf;

import java.nio.file.Path;

public interface WKMFFactory {
    interface WKMFSpec {
        WKMFSpec mavenHome(Path mavenHome);

        WKMFSpec mavenUser(Path mavenUser);

        WKMFSpec globalToolchainsXml(Path globalToolchainsXml);

        WKMFSpec userToolchainsXml(Path userToolchainsXml);

        WKMFSpec globalSettingsXml(Path globalSettingsXml);

        WKMFSpec userSettingsXml(Path userSettingsXml);

        WKMFSpec userSettingsSecurityXml(Path userSettingsSecurityXml);

        WKMF create();
    }

    WKMFSpec createSpec();

    WKMFSpec createSpec(Path userHome, Path cwd);
}
