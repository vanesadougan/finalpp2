package org.bienestar.cocina.view.base;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public abstract class SimpleDocumentListener implements DocumentListener {

	public void changedUpdate(DocumentEvent e) {
		change(e);
	}

	public void insertUpdate(DocumentEvent e) {
		change(e);
	}

	public void removeUpdate(DocumentEvent e) {
		change(e);
	}
	
	public abstract void change(DocumentEvent e);
	
}
