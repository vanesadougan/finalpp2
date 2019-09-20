package org.bienestar.cocina.model;

import java.time.LocalDate;

import CSV.CSVExporterFacade;
//import org.bienestar.cocina.export.CSVExporterFacade;
	import org.bienestar.cocina.model.base.Model;
    import ExporterLibrary.exportadorMain.Exportador;



public class ExportModel extends Model {

	public void export(LocalDate from, LocalDate to) {
		CSVExporterFacade exporterFacade = new CSVExporterFacade();
		try {
			exporterFacade.export(from, to);
		} catch (Exception e) {
			notifyObservers(e);
			e.printStackTrace();
		}
	}

}
