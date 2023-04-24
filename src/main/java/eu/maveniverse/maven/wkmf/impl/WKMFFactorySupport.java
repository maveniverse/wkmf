package eu.maveniverse.maven.wkmf.impl;

import static java.util.Objects.requireNonNull;

import eu.maveniverse.maven.wkmf.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class WKMFFactorySupport implements WKMFFactory {
    protected static final class WKMFImpl implements WKMF {
        private final Path userHome;
        private final Path cwd;
        private final MavenHomeDirectory mavenHomeDirectory;
        private final MavenUserDirectory mavenUserDirectory;
        private final Path globalToolchainsXml;
        private final Path userToolchainsXml;
        private final Path globalSettingsXml;
        private final Path userSettingsXml;
        private final Path userSettingsSecurityXml;

        WKMFImpl(WKMFSpecImpl spec) {
            this.userHome = spec.userHome;
            this.cwd = spec.cwd;

            this.mavenHomeDirectory = spec.mavenHomeDirectory;
            this.mavenUserDirectory = spec.mavenUserDirectory;
            this.globalToolchainsXml = spec.globalToolchainsXml;
            this.userToolchainsXml = spec.userToolchainsXml;
            this.globalSettingsXml = spec.globalSettingsXml;
            this.userSettingsXml = spec.userSettingsXml;
            this.userSettingsSecurityXml = spec.userSettingsSecurityXml;
        }

        @Override
        public Path userHome() {
            return userHome;
        }

        @Override
        public Path cwd() {
            return cwd;
        }

        @Override
        public MavenHomeDirectory mavenHomeDirectory() {
            return mavenHomeDirectory;
        }

        @Override
        public MavenUserDirectory mavenUserDirectory() {
            return mavenUserDirectory;
        }

        @Override
        public Path globalToolchainsXml() {
            return globalToolchainsXml;
        }

        @Override
        public Path userToolchainsXml() {
            return userToolchainsXml;
        }

        @Override
        public Path globalSettingsXml() {
            return globalSettingsXml;
        }

        @Override
        public Path userSettingsXml() {
            return userSettingsXml;
        }

        @Override
        public Path userSettingsSecurityXml() {
            return userSettingsSecurityXml;
        }
    }

    protected abstract static class WKMFSpecImpl implements WKMFSpec {
        protected static final Path DEFAULT = Paths.get("default"); // not a real path, just for instance equality
        protected final Path userHome;
        protected final Path cwd;
        protected Path mavenHome = DEFAULT;
        protected MavenHomeDirectory mavenHomeDirectory = null;
        protected Path mavenUser = DEFAULT;
        protected MavenUserDirectory mavenUserDirectory = null;
        protected Path globalToolchainsXml = DEFAULT;
        protected Path userToolchainsXml = DEFAULT;
        protected Path globalSettingsXml = DEFAULT;
        protected Path userSettingsXml = DEFAULT;
        protected Path userSettingsSecurityXml = DEFAULT;

        protected WKMFSpecImpl(Path userHome, Path cwd) {
            this.userHome = requireNonNull(userHome);
            this.cwd = requireNonNull(cwd);
        }

        @Override
        public WKMFSpecImpl mavenHome(Path mavenHome) {
            this.mavenHome = mavenHome;
            return this;
        }

        @Override
        public WKMFSpecImpl mavenUser(Path mavenUser) {
            this.mavenUser = mavenUser;
            return this;
        }

        @Override
        public WKMFSpecImpl globalToolchainsXml(Path globalToolchainsXml) {
            this.globalToolchainsXml = globalToolchainsXml;
            return this;
        }

        @Override
        public WKMFSpecImpl userToolchainsXml(Path userToolchainsXml) {
            this.userToolchainsXml = userToolchainsXml;
            return this;
        }

        @Override
        public WKMFSpecImpl globalSettingsXml(Path globalSettingsXml) {
            this.globalSettingsXml = globalSettingsXml;
            return this;
        }

        @Override
        public WKMFSpecImpl userSettingsXml(Path userSettingsXml) {
            this.userSettingsXml = userSettingsXml;
            return this;
        }

        @Override
        public WKMFSpecImpl userSettingsSecurityXml(Path userSettingsSecurityXml) {
            this.userSettingsSecurityXml = userSettingsSecurityXml;
            return this;
        }
    }

    @Override
    public WKMFSpec createSpec() {
        return createSpec(Paths.get(System.getProperty("user.home")), Paths.get(System.getProperty("user.dir")));
    }
}
