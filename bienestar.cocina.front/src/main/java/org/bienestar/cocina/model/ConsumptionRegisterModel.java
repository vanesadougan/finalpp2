package org.bienestar.cocina.model;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bienestar.cocina.autocorrect.IngredientAdviser;
import org.bienestar.cocina.domain.Preparation;
import org.bienestar.cocina.interpreters.DateInterpreter;
import org.bienestar.cocina.model.base.Model;
import org.bienestar.cocina.repository.RepositoryStore;
import org.bienestar.cocina.validations.ValidationFactory;

public class ConsumptionRegisterModel extends Model {

	public List<String> getSuggestions(Preparation preparation, String txtIngrediente) {
		String filePath = new File("").getAbsolutePath();
		String file = filePath.concat(File.separator + "big.txt");
		try {
			final IngredientAdviser adviser = new IngredientAdviser(file,
					RepositoryStore.getInstance().getPreparationRepository());
			return adviser.getBestFit(preparation, txtIngrediente);
		} catch (IOException e) {
			e.printStackTrace();
			notifyObservers(e);
		}
		return null;
	}

	public void validateDate(String date) {
		DateInterpreter dateInterpreter = new DateInterpreter();
		String interpretedDate = dateInterpreter.interpret(date);
		ValidationFactory valBuilder = new ValidationFactory();
		try {
			valBuilder.isValidDayOfMonth().validate(interpretedDate);
		} catch (Exception e) {
			this.notifyObservers(e);
		}

	}

}
