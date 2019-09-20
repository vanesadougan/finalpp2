package org.bienestar.cocina;

import javax.swing.SwingUtilities;

import exporter.Container;
import exporter.types.IExportable;
import org.bienestar.cocina.controller.MainPageController;
import org.bienestar.cocina.model.MainPageModel;
import org.bienestar.cocina.view.MainPage;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        Exporter exporter = new Exporter();
        Container container = Container.getInstance();
        exporter.findAll(container);
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                MainPage view = new MainPage(container);
                IExportable exportable = container.get("CSVExportable",IExportable.class);
                MainPageController controller = new MainPageController(view, new MainPageModel());
                view.setVisible(true);
            }
        });
	}
}
