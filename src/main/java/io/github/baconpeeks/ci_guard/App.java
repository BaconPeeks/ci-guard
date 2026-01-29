package io.github.baconpeeks.ci_guard;

import io.github.baconpeeks.ci_guard.config.Config;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Application entry point for ci-guard.
 * Responsible for loading configuration and orchestrating
 * CI validation logic.
 */
public class App {

    /**
     * Loads the configuration file and outputs parsed values
     * to verify successful deserialization.
     *
     * @param args command-line arguments (future use maybe)
     */
    public static void main(String[] args) {
        try {
            Config config = loadConfig();

            System.out.println("Loaded config:");
            System.out.println("Pattern: " + config.getCommitPattern());
            System.out.println("Max length: " + config.getMaxLength());
        } catch (Exception e) {
            System.err.println("Failed to load configuration: " + e.getMessage());
            System.exit(1);
        }
    }

    /**
     * Loads {@code ci-guard.yml} from the project root and maps it
     * to a {@link Config} instance.
     *
     * @return parsed configuration
     * @throws Exception if the file cannot be read or parsed
     */
    private static Config loadConfig() throws Exception {
        Yaml yaml = new Yaml();

        try (InputStream in = Files.newInputStream(Path.of("ci-guard.yml"))) {
            return yaml.loadAs(in, Config.class);
        }
    }
}
