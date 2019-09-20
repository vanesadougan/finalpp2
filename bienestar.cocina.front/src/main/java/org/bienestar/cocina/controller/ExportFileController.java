package org.bienestar.cocina.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.cert.X509Certificate;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

//import ExporterLibrary.exportadorMain.Exportador;
//import ExporterLibrary.exportadorMain.Exportador;
import CSV.CSVExportable;
import exporter.Container;
import exporter.domain.PreparationRegistry;
import exporter.preparation.PreparationFilter;
import exporter.repository.RepositoryStore;
import exporter.types.IExportable;
import org.bienestar.cocina.Exporter;
import org.bienestar.cocina.controller.base.Controller;
import org.bienestar.cocina.model.ExportModel;
import org.bienestar.cocina.view.ExportFilePage;
import org.bienestar.cocina.view.Exportable;
//import ExporterLibrary.exportadorMain.Exportador;
//import exporter.;
import javax.swing.JOptionPane;

public class ExportFileController extends Controller<ExportFilePage, ExportModel> {


	public ExportFileController(final ExportFilePage view, final ExportModel exportModel, final IExportable exportable) {
		super(view, exportModel);

		view.addBtnExportarActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				LocalDate dateFrom = view.getDateFrom().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				LocalDate dateTo = view.getDateTo().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();


				PreparationFilter filter = new PreparationFilter();

				try {
				List<PreparationRegistry> data = filter.getPreparationFilter(
						RepositoryStore.getInstance().getPreparationRegistryRepository().getPreparationRegistries(), dateFrom, dateTo);


				exportable.export(data, dateFrom, dateTo);
				} catch (Exception ex) {
					throw new RuntimeException(ex);
				}

                JOptionPane.showMessageDialog(null, "El Archivo fue exportado desde "+dateFrom+" hasta "+dateTo);

            }
		});
	}

}
