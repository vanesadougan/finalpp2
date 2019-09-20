package org.bienestar.cocina.preparationRegistry;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.bienestar.cocina.domain.Consumption;
import org.bienestar.cocina.domain.Ingredient;
import org.bienestar.cocina.domain.Preparation;
import org.bienestar.cocina.domain.PreparationRegistry;

public class PreparationRegistryRepositoryMock extends PreparationRegistryRepository {

	public PreparationRegistryRepositoryMock() {
		super();
		generateMockData();
	}

	private void generateMockData() {
		PreparationRegistry reg1 = new PreparationRegistry();
		PreparationRegistry reg2 = new PreparationRegistry();
		PreparationRegistry reg3 = new PreparationRegistry();
		PreparationRegistry reg4 = new PreparationRegistry();

		reg1.setDate(LocalDate.parse("2018-03-15"));
		reg2.setDate(LocalDate.parse("2018-03-16"));
		reg3.setDate(LocalDate.parse("2018-03-16"));
		reg4.setDate(LocalDate.parse("2018-03-18"));

		reg1.setDiners(20);
		reg2.setDiners(20);
		reg3.setDiners(20);
		reg4.setDiners(15);

		Preparation teConLeche = new Preparation();
		Preparation albondigasArroz = new Preparation();
		Preparation lecheChocolatada = new Preparation();

		List<Consumption> consumptions = new ArrayList<Consumption>();
		Ingredient azucar = new Ingredient();
		azucar.setName("Azucar");
		Consumption azucarConsumption = new Consumption();
		azucarConsumption.setIngredient(azucar);
		azucarConsumption.setQuantity(300d);

		Ingredient saquito = new Ingredient();
		saquito.setName("Saquito de Te");
		Consumption saquitoConsumption = new Consumption();
		saquitoConsumption.setIngredient(saquito);
		saquitoConsumption.setQuantity(20d);

		Ingredient lecheEnPolvo = new Ingredient();
		lecheEnPolvo.setName("Leche en Polvo");
		Consumption lecheEnPolvoConsumption = new Consumption();
		lecheEnPolvoConsumption.setIngredient(lecheEnPolvo);
		lecheEnPolvoConsumption.setQuantity(100d);

		Ingredient agua = new Ingredient();
		agua.setName("Agua");
		Consumption aguaConsumption = new Consumption();
		aguaConsumption.setIngredient(agua);
		aguaConsumption.setQuantity(10d);

		Ingredient arroz = new Ingredient();
		arroz.setName("Arroz");
		Consumption arrozConsumption = new Consumption();
		arrozConsumption.setIngredient(arroz);
		arrozConsumption.setQuantity(1d);

		Ingredient carnePicada = new Ingredient();
		carnePicada.setName("Carne Picada");
		Consumption carnePicadaConsumption = new Consumption();
		carnePicadaConsumption.setIngredient(carnePicada);
		carnePicadaConsumption.setQuantity(300d);

		Ingredient cacao = new Ingredient();
		cacao.setName("Cacao");
		Consumption cacaoConsumption = new Consumption();
		cacaoConsumption.setIngredient(cacao);
		cacaoConsumption.setQuantity(100d);

		consumptions.add(azucarConsumption);
		consumptions.add(saquitoConsumption);
		consumptions.add(lecheEnPolvoConsumption);
		consumptions.add(aguaConsumption);
		consumptions.add(arrozConsumption);
		consumptions.add(carnePicadaConsumption);
		consumptions.add(cacaoConsumption);

		teConLeche.setConsumptions(consumptions);
		albondigasArroz.setConsumptions(consumptions);
		lecheChocolatada.setConsumptions(consumptions);

		reg1.setPreparation(teConLeche);
		reg2.setPreparation(teConLeche);
		reg3.setPreparation(albondigasArroz);
		reg4.setPreparation(lecheChocolatada);

		getPreparationRegistries().add(reg1);
		getPreparationRegistries().add(reg2);
		getPreparationRegistries().add(reg3);
		getPreparationRegistries().add(reg4);
	}

}
