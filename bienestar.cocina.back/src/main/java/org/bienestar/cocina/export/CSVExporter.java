/*package org.bienestar.cocina.export;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.bienestar.cocina.domain.PreparationRegistry;
import org.bienestar.cocina.exceptions.NoItemFoundException;

public class CSVExporter {

	private final FilenameAssigner filenameAssigner;
	private final FileSaver fileSaver;
	private final CSVTransformer<PreparationRegistry> transformer;
	
	public CSVExporter(FilenameAssigner filenameAssigner, FileSaver fileSaver,
			CSVTransformer<PreparationRegistry> transformer) {
		this.filenameAssigner = filenameAssigner;
		this.fileSaver = fileSaver;
		this.transformer = transformer;
	}

	public String export(List<PreparationRegistry> data, LocalDate from, LocalDate to) throws IOException, NoItemFoundException {
		String fileName = filenameAssigner.getName(from, to);
		List<String> content = data.stream()
				.map(x -> transformer.transform(x))
				.collect(Collectors.toList());
		if(content == null || content.isEmpty()){
			throw new NoItemFoundException();
		}
		
		return fileSaver.save(fileName, content);
	}
	
	public String export(List<PreparationRegistry> data, LocalDate day) throws IOException, NoItemFoundException {
		return this.export(data, day, day);
	}
	
}*/
