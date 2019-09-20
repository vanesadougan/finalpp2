package org.bienestar.cocina.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.bienestar.cocina.controller.base.Controller;
import org.bienestar.cocina.controller.navigation.ActionRequest;
import org.bienestar.cocina.controller.navigation.ApplicationContext;
import org.bienestar.cocina.controller.navigation.ApplicationController;
import org.bienestar.cocina.model.base.Model;
import org.bienestar.cocina.view.MainPage;

public class MainPageController extends Controller<MainPage, Model> {

	public MainPageController(MainPage view, Model model) {
		super(view, model);
		
		view.addMnExportacionListenerCSV(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ApplicationController.getInstance().navigate(new ApplicationContext(ActionRequest.EXPORT_TO_FILE_CSV));
			}
		});
		view.addMnExportacionListenerXLS(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ApplicationController.getInstance().navigate(new ApplicationContext(ActionRequest.EXPORT_TO_FILE_XLS));
			}
		});
		view.addMnRegistroListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApplicationController.getInstance().navigate(new ApplicationContext(ActionRequest.NEW_CONSUMPTION_REGISTRATION));
			}
		});
	}

}
