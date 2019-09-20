package org.bienestar.cocina.consumption;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;

import org.bienestar.cocina.domain.Consumption;
import org.bienestar.cocina.domain.Ingredient;
import org.bienestar.cocina.domain.MeasureType;
import org.bienestar.cocina.exceptions.InvalidIngredientQuantityException;
import org.bienestar.cocina.specifications.validations.IsValueAnInteger;

public class ConsumptionBuilder {

	public static Consumption build(Ingredient ingredient, Double quantity) throws InvalidIngredientQuantityException {
		if (quantity <= 0)
			throw new InvalidIngredientQuantityException();

		if (ingredient.getMeasureType().equals(MeasureType.GRAM)
				|| ingredient.getMeasureType().equals(MeasureType.UNIT)) {
			if (!new IsValueAnInteger().isSatisfiedBy(quantity))
				throw new InvalidIngredientQuantityException();
		}

		Consumption cons = new Consumption();
		cons.setIngredient(ingredient);
		cons.setQuantity(quantity);
		return cons;
	}

	public static Consumption build(Ingredient ingredient, String quantity) throws InvalidIngredientQuantityException {
		try {
			DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getInstance();
			DecimalFormatSymbols symbols = decimalFormat.getDecimalFormatSymbols();
			char sep = symbols.getDecimalSeparator();
			if (quantity.split(Character.toString(sep)).length > 2)
				throw new NumberFormatException();

			NumberFormat format = NumberFormat.getInstance();
			Number number = format.parse(quantity);
			return build(ingredient, number.doubleValue());
		} catch (ParseException | NumberFormatException e) {
			throw new InvalidIngredientQuantityException();
		}
	}

}
