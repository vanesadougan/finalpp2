package org.bienestar.cocina.service.loader;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class IntegrationServiceLoader {

	public static <T> ServiceLoader<T> loadIntegrations(Path path, Class<T> clazz) throws IOException {
        List<URL> fileNames = new ArrayList<>();
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
            for (Path each : directoryStream) {
                fileNames.add(each.toUri().toURL());
            }
        }
        URL[] array = fileNames.stream().toArray(size -> new URL[size]);
        ClassLoader cl = new URLClassLoader(array, IntegrationServiceLoader.class.getClassLoader());
        return ServiceLoader.load(clazz, cl);
    }
}
