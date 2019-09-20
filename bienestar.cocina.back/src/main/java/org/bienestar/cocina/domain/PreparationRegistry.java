package org.bienestar.cocina.domain;

import java.time.LocalDate;

public class PreparationRegistry {

	private LocalDate date;
	private int diners;
	private Preparation preparation;

	public PreparationRegistry() {
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public int getDiners() {
		return diners;
	}

	public void setDiners(int diners) {
		this.diners = diners;
	}

	public Preparation getPreparation() {
		return preparation;
	}

	public void setPreparation(Preparation preparation) {
		this.preparation = preparation;
	}
}
