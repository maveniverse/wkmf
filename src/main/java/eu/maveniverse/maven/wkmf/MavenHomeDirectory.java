package eu.maveniverse.maven.wkmf;

import java.nio.file.Path;

public interface MavenHomeDirectory {
    Path basedir();

    default Path bin() {
        return basedir().resolve("bin");
    }

    default Path boot() {
        return basedir().resolve("boot");
    }

    default Path conf() {
        return basedir().resolve("conf");
    }

    default Path lib() {
        return basedir().resolve("lib");
    }

    default Path m2Conf() {
        return bin().resolve("m2.conf");
    }

    default Path mvn() {
        return bin().resolve("mvn");
    }

    default Path mvnCmd() {
        return bin().resolve("mvn.cmd");
    }

    default Path mvnDebug() {
        return bin().resolve("mvnDebug");
    }

    default Path mvnDebugCmd() {
        return bin().resolve("mvnDebug.cmd");
    }

    default Path settingsXml() {
        return conf().resolve("settings.xml");
    }

    default Path toolchainsXml() {
        return conf().resolve("toolchains.xml");
    }

    default Path confLogging() {
        return conf().resolve("logging");
    }

    default Path simpleloggerProperties() {
        return confLogging().resolve("simplelogger.properties");
    }

    default Path libExt() {
        return lib().resolve("ext");
    }
}
