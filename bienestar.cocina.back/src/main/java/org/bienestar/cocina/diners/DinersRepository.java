package org.bienestar.cocina.diners;

import java.util.ArrayList;
import java.util.List;

import org.bienestar.cocina.domain.Diner;

public class DinersRepository {
	private List<Diner> diners;

	public DinersRepository() {
		diners = new ArrayList<Diner>();
	}

	public List<Diner> getDiners() {
		return diners;
	}
}
