package eu.maveniverse.maven.wkmf.impl;

import static java.util.Objects.requireNonNull;

import eu.maveniverse.maven.wkmf.WKMF;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.inject.Provider;
import org.apache.maven.execution.MavenSession;

public final class EmbeddedWKMFFactory extends WKMFFactorySupport {
    private final Provider<MavenSession> mavenSessionProvider;

    public EmbeddedWKMFFactory(Provider<MavenSession> mavenSessionProvider) {
        this.mavenSessionProvider = requireNonNull(mavenSessionProvider);
    }

    protected static class StandaloneWKMFSpec extends WKMFSpecImpl {
        private final MavenSession mavenSession;

        public StandaloneWKMFSpec(Path userHome, Path cwd, MavenSession mavenSession) {
            super(userHome, cwd);
            this.mavenSession = requireNonNull(mavenSession);
        }

        @Override
        public WKMF create() {
            mavenHome = Paths.get(System.getProperty("maven.home"));
            mavenHomeDirectory = new MavenHomeDirectoryImpl(mavenHome);
            mavenUser = userHome.resolve(".m2");
            mavenUserDirectory = new MavenUserDirectoryImpl(mavenUser);
            globalToolchainsXml = toPath(mavenSession.getRequest().getGlobalToolchainsFile());
            userToolchainsXml = toPath(mavenSession.getRequest().getUserToolchainsFile());
            globalSettingsXml = toPath(mavenSession.getRequest().getGlobalSettingsFile());
            userSettingsXml = toPath(mavenSession.getRequest().getUserSettingsFile());
            userSettingsSecurityXml = mavenUserDirectory.settingsSecurityXml();
            return new WKMFImpl(this);
        }

        private static Path toPath(File file) {
            if (file != null) {
                return file.toPath();
            }
            return null;
        }
    }

    @Override
    public WKMFSpec createSpec(Path userHome, Path cwd) {
        return new StandaloneWKMFSpec(userHome, cwd, mavenSessionProvider.get());
    }
}
