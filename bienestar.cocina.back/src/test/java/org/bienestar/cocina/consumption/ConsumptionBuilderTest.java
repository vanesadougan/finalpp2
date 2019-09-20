package org.bienestar.cocina.consumption;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.bienestar.cocina.domain.Consumption;
import org.bienestar.cocina.domain.Ingredient;
import org.bienestar.cocina.domain.MeasureType;
import org.bienestar.cocina.exceptions.InvalidIngredientQuantityException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConsumptionBuilderTest {

	private static Locale previousLocale;
	
	@BeforeClass
	public static void start() {
		previousLocale = Locale.getDefault();
		Locale.setDefault(new Locale("es", "AR"));
	}
	
	@AfterClass
	public static void end() {
		Locale.setDefault(previousLocale);
	}
	
	private Ingredient buildMockIngredient() {
		Ingredient ingr = new Ingredient();
		ingr.setDescription("Test");
		ingr.setMeasureType(MeasureType.KILOGRAM);
		ingr.setName("Test");
		return ingr;
	}

	@Test(expected = InvalidIngredientQuantityException.class)
	public void doubleDecimalCharacterTest() throws InvalidIngredientQuantityException {
		Ingredient ingr = buildMockIngredient();
		ConsumptionBuilder.build(ingr, "1,,5");
	}

	@Test
	public void kilogramIngredientConsumptionTest() throws Exception {
		Ingredient ingr = buildMockIngredient();
		ingr.setMeasureType(MeasureType.KILOGRAM);
		Consumption result = ConsumptionBuilder.build(ingr, "0,5");
		assertEquals(new Double(0.5), result.getQuantity());
	}
	
	@Test
	public void litersIngredientConsumptionTest() throws Exception {
		Ingredient ingr = buildMockIngredient();
		ingr.setMeasureType(MeasureType.LITERS);
		Consumption result = ConsumptionBuilder.build(ingr, "0,5");
		assertEquals(new Double(0.5), result.getQuantity());
	}

	@Test(expected = InvalidIngredientQuantityException.class)
	public void nonNumericQuantityIngredientConsumptionTest() throws InvalidIngredientQuantityException {
		Ingredient ingr = buildMockIngredient();
		ConsumptionBuilder.build(ingr, "A");
	}
	
	@Test(expected = InvalidIngredientQuantityException.class)
	public void negativeQuantityIngredientConsumptionTest() throws InvalidIngredientQuantityException {
		Ingredient ingr = buildMockIngredient();
		ConsumptionBuilder.build(ingr, -5D);
	}
	
	@Test(expected = InvalidIngredientQuantityException.class)
	public void zeroQuantityIngredientConsumptionTest() throws InvalidIngredientQuantityException {
		Ingredient ingr = buildMockIngredient();
		ConsumptionBuilder.build(ingr, 0D);
	}
	
	@Test(expected = InvalidIngredientQuantityException.class)
	public void invalidQuantityUnitIngredientConsumptionTest() throws InvalidIngredientQuantityException {
		Ingredient ingr = buildMockIngredient();
		ingr.setMeasureType(MeasureType.UNIT);
		ConsumptionBuilder.build(ingr, 0.5D);
	}
	
	@Test(expected = InvalidIngredientQuantityException.class)
	public void invalidQuantityGramIngredientConsumptionTest() throws InvalidIngredientQuantityException {
		Ingredient ingr = buildMockIngredient();
		ingr.setMeasureType(MeasureType.GRAM);
		ConsumptionBuilder.build(ingr, 0.5D);
	}
	
}
