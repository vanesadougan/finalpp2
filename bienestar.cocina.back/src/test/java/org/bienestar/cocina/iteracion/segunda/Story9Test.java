package org.bienestar.cocina.iteracion.segunda;

import org.bienestar.cocina.domain.Consumption;
import org.bienestar.cocina.domain.Ingredient;
import org.bienestar.cocina.domain.Preparation;
import org.bienestar.cocina.domain.PreparationRegistry;
import org.bienestar.cocina.exceptions.ConsumptionOutOfRangeException;
import org.bienestar.cocina.preparationRegistry.PreparationRegistryRepository;
import org.bienestar.cocina.verifier.ConsumptionVerifierStandardDev;
import org.junit.BeforeClass;
import org.junit.Test;

public class Story9Test {

	private static ConsumptionVerifierStandardDev verifier;

	@BeforeClass
	public static void startup() {
		PreparationRegistryRepository repo = new PreparationRegistryRepository();
		for (int i = 0; i < 5; i++) {
			repo.getPreparationRegistries().add(buildPreparationRegistry(10, 250, 200));
			repo.getPreparationRegistries().add(buildPreparationRegistry(5, 150, 100));
			repo.getPreparationRegistries().add(buildPreparationRegistry(15, 200, 150));
			repo.getPreparationRegistries().add(buildPreparationRegistry(20, 100, 50));
		}
		verifier = new ConsumptionVerifierStandardDev(repo);
	}

	private static PreparationRegistry buildPreparationRegistry(int diners, double lecheEnPolvoQuantity,
			double cacaoEnPolvoQuantity) {
		PreparationRegistry prepReg = new PreparationRegistry();
		Preparation prep = new Preparation();
		Consumption cons = new Consumption();
		Ingredient lecheEnPolvo = new Ingredient();
		lecheEnPolvo.setName("leche en polvo");
		Ingredient cacaoEnPolvo = new Ingredient();
		cacaoEnPolvo.setName("cacao en polvo");
		
		prep.setName("leche chocolatada");
		prepReg.setDiners(diners);
		cons.setIngredient(lecheEnPolvo);
		cons.setQuantity(lecheEnPolvoQuantity);
		prep.addConsumption(cons);
		cons = new Consumption();
		cons.setIngredient(cacaoEnPolvo);
		cons.setQuantity(cacaoEnPolvoQuantity);
		prep.addConsumption(cons);
		prepReg.setPreparation(prep);
		return prepReg;
	}

	private void doConsumption(String ingredientName, double quantity, int diners) throws ConsumptionOutOfRangeException {
		Consumption cons = new Consumption();
		Preparation prep = new Preparation();
		Ingredient ingr = new Ingredient();
		prep.setName("leche chocolatada");
		ingr.setName(ingredientName);
		cons.setIngredient(ingr);
		cons.setQuantity(quantity);
		verifier.registerConsumption(cons, prep, diners);
	}
	
	@Test(expected = ConsumptionOutOfRangeException.class)
	public void ca1() throws ConsumptionOutOfRangeException {
		doConsumption("leche en polvo", 572, 20);
	}
	
	@Test(expected = ConsumptionOutOfRangeException.class)
	public void ca2() throws ConsumptionOutOfRangeException {
		doConsumption("leche en polvo", 159, 20);
	}
	
	@Test()
	public void ca3() throws ConsumptionOutOfRangeException {
		doConsumption("leche en polvo", 220, 20);
	}
	
	@Test(expected = ConsumptionOutOfRangeException.class)
	public void ca4() throws ConsumptionOutOfRangeException {
		doConsumption("cacao en polvo", 100, 20);
	}
	
	@Test(expected = ConsumptionOutOfRangeException.class)
	public void ca5() throws ConsumptionOutOfRangeException {
		doConsumption("cacao en polvo", 40, 20);
	}
	
	@Test()
	public void ca6() throws ConsumptionOutOfRangeException {
		doConsumption("cacao en polvo", 200, 20);
	}
	

}
