/*package org.bienestar.cocina.export;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileSaver {

	public String save(String path, List<String> content) throws IOException  {
		Path file = Paths.get(path);
		Files.write(file, content, Charset.forName("UTF-8"));
		return file.toAbsolutePath().toString();
	}
}
*/