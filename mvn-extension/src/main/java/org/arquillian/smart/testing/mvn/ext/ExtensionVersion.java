package org.arquillian.smart.testing.mvn.ext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExtensionVersion {

    private final static String VERSION_FILE = "/extension_version";

    private static Version version;

    public static Version version() {

        synchronized (ExtensionVersion.class) {
            if (version == null) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(ExtensionVersion.class.getResourceAsStream(VERSION_FILE)))){
                    version = Version.from(reader.readLine().trim());
                } catch (IOException e) {
                    throw new RuntimeException("Couldn't read extension version", e);
                }
            }
        }

        return version;
    }
}