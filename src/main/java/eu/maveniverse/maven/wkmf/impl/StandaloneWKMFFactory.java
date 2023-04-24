package eu.maveniverse.maven.wkmf.impl;

import eu.maveniverse.maven.wkmf.WKMF;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class StandaloneWKMFFactory extends WKMFFactorySupport {
    protected static class StandaloneWKMFSpec extends WKMFSpecImpl {
        public StandaloneWKMFSpec(Path userHome, Path cwd) {
            super(userHome, cwd);
        }

        @Override
        public WKMF create() {
            if (mavenHome == DEFAULT) {
                mavenHome = mavenHomeDiscovery();
            }
            if (mavenHome != null) {
                mavenHomeDirectory = new MavenHomeDirectoryImpl(mavenHome);
            }
            if (mavenHomeDirectory != null) {
                if (globalToolchainsXml == DEFAULT) {
                    globalToolchainsXml = mavenHomeDirectory.toolchainsXml();
                }
                if (globalSettingsXml == DEFAULT) {
                    globalSettingsXml = mavenHomeDirectory.settingsXml();
                }
            }

            if (mavenUser == DEFAULT) {
                mavenUser = userHome.resolve(".m2");
            }
            if (mavenUser != null) {
                mavenUserDirectory = new MavenUserDirectoryImpl(mavenUser);
            }
            if (mavenUserDirectory != null) {
                if (userToolchainsXml == DEFAULT) {
                    userToolchainsXml = mavenUserDirectory.toolchainsXml();
                }
                if (userSettingsXml == DEFAULT) {
                    userSettingsXml = mavenUserDirectory.settingsXml();
                }
                if (userSettingsSecurityXml == DEFAULT) {
                    userSettingsSecurityXml = mavenUserDirectory.settingsSecurityXml();
                }
            }

            // get rid of possible DEFAULT path instances
            globalToolchainsXml = globalToolchainsXml == DEFAULT ? null : globalToolchainsXml;
            userToolchainsXml = userToolchainsXml == DEFAULT ? null : userToolchainsXml;
            globalSettingsXml = globalSettingsXml == DEFAULT ? null : globalSettingsXml;
            userSettingsXml = userSettingsXml == DEFAULT ? null : userSettingsXml;
            userSettingsSecurityXml = userSettingsSecurityXml == DEFAULT ? null : userSettingsSecurityXml;
            return new WKMFImpl(this);
        }

        private Path mavenHomeDiscovery() {
            String mavenHomePath = System.getenv("MAVEN_HOME");
            if (mavenHomePath != null) {
                return Paths.get(mavenHomePath);
            }
            return null;
        }
    }

    @Override
    public WKMFSpec createSpec(Path userHome, Path cwd) {
        return new StandaloneWKMFSpec(userHome, cwd);
    }
}
