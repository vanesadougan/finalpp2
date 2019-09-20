/*package org.bienestar.cocina.export;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.bienestar.cocina.domain.PreparationRegistry;
import org.bienestar.cocina.exceptions.InvalidRange;
import org.bienestar.cocina.exceptions.NoItemFoundException;
import org.bienestar.cocina.preparation.PreparationFilter;
import org.bienestar.cocina.repository.RepositoryStore;

public class CSVExporterFacade {

	public void export(LocalDate from, LocalDate to) throws IOException, NoItemFoundException, InvalidRange {
		PreparationFilter filter = new PreparationFilter();
		List<PreparationRegistry> data = filter.getPreparationFilter(
				RepositoryStore.getInstance().getPreparationRegistryRepository().getPreparationRegistries(), from, to);
		CSVExporter exporter = new CSVExporter(new FilenameAssigner(), new FileSaver(),
				new PreparationRegistryTransformer());

		exporter.export(data, from, to);
	}

}*/
