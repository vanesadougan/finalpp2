package org.bienestar.cocina.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.event.DocumentEvent;

import org.bienestar.cocina.controller.base.Controller;
import org.bienestar.cocina.model.ConsumptionRegisterModel;
import org.bienestar.cocina.view.ConsumptionRegisterPage;
import org.bienestar.cocina.view.base.SimpleDocumentListener;

public class ConsumptionRegisterController extends Controller<ConsumptionRegisterPage, ConsumptionRegisterModel> {

	public ConsumptionRegisterController(final ConsumptionRegisterPage view, final ConsumptionRegisterModel model) {
		super(view, model);

		view.addBtnSaveActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});

		view.addTxtIngredienteUpdateListener(new SimpleDocumentListener() {
			@Override
			public void change(DocumentEvent e) {
				List<String> bestFit = model.getSuggestions(null, view.getTxtIngrediente());
				if (bestFit != null)
					view.setSuggestionsList(bestFit);
			}
		});
		
		view.addBtnSaveActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				model.validateDate(view.getTxtFecha());
			}
		});
	}

}
