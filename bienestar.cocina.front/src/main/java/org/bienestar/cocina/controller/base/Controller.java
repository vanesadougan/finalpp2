package org.bienestar.cocina.controller.base;

import org.bienestar.cocina.model.base.Model;
import org.bienestar.cocina.view.base.View;

public abstract class Controller<T extends View, S extends Model> {

	private T view;
	private S model;
	
	public Controller(T view, S model) {
		this.view = view;
		this.model = model;
		model.addObserver(view);
	}
	
	public S getModel() {
		return model;
	}
	
	public T getView(){
		return view;
	}
}
