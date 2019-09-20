package org.bienestar.cocina.iteracion.segunda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bienestar.cocina.autocorrect.IngredientAdviser;
import org.bienestar.cocina.domain.Consumption;
import org.bienestar.cocina.domain.Ingredient;
import org.bienestar.cocina.domain.Preparation;
import org.bienestar.cocina.preparation.PreparationRepository;
import org.junit.Before;
import org.junit.Test;

public class Story8Test {

	private IngredientAdviser adviser;

	// input inteligente 2.0
	@Test
	public void inputa20() {// te con leche
		Preparation prep = new Preparation();
		prep.setName("Té con leche");
		List<String> result = adviser.getBestFit(prep, "a");
		assertEquals(0, result.indexOf("Agua"));
		assertEquals(1, result.indexOf("Azúcar"));
		assertEquals(2, result.indexOf("Arroz"));
		assertEquals(3, result.indexOf("Carne Picada"));
	}

	@Test
	public void inputz20Te() {// te con leche
		Preparation prep = new Preparation();
		prep.setName("Té con leche");
		List<String> result = adviser.getBestFit(prep, "z");
		assertEquals(0, result.indexOf("Azúcar"));
		assertEquals(1, result.indexOf("Arroz"));
	}

	@Test
	public void inputz20Albondiga() {// Albondiga
		Preparation prep = new Preparation();
		prep.setName("Albóndigas con arroz");
		List<String> result = adviser.getBestFit(prep, "z");
		assertEquals(0, result.indexOf("Arroz"));
		assertEquals(1, result.indexOf("Azúcar"));
	}

	@Test
	public void input20Clbondiga() {// Albondiga
		Preparation prep = new Preparation();
		prep.setName("Albóndigas con arroz");
		List<String> result = adviser.getBestFit(prep, "c");
		assertEquals(0, result.indexOf("Carne Picada"));
		assertEquals(1, result.indexOf("Azúcar"));
		assertEquals(2, result.indexOf("Leche en Polvo"));// Agregado
	}

	@Test
	public void input20CTe() {// Te con leche
		Preparation prep = new Preparation();
		prep.setName("Té con leche");
		List<String> result = adviser.getBestFit(prep, "c");
		assertEquals(0, result.indexOf("Azúcar"));
		assertEquals(1, result.indexOf("Leche en Polvo"));
		assertEquals(2, result.indexOf("Carne Picada"));

	}

	@Test
	public void input20rTe() {// Te con leche
		Preparation prep = new Preparation();
		prep.setName("Té con leche");
		List<String> result = adviser.getBestFit(prep, "r");
		assertEquals(0, result.indexOf("Azúcar"));
		assertEquals(1, result.indexOf("Arroz"));
		assertEquals(2, result.indexOf("Carne Picada"));
	}

	@Test
	public void input20rAlbondiga() {// Albondiga
		Preparation prep = new Preparation();
		prep.setName("Albóndigas con arroz");
		List<String> result = adviser.getBestFit(prep, "r");
		assertEquals(0, result.indexOf("Arroz"));
		assertEquals(1, result.indexOf("Carne Picada"));
		assertEquals(2, result.indexOf("Azúcar"));
	}

	@Test
	public void input20pAlbondiga() {// Albondiga
		Preparation prep = new Preparation();
		prep.setName("Albóndigas con arroz");
		List<String> result = adviser.getBestFit(prep, "p");
		assertEquals(0, result.indexOf("Carne Picada"));
		assertEquals(1, result.indexOf("Leche en Polvo"));
	}

	@Test
	public void input20pTe() {// Te con leche
		Preparation prep = new Preparation();
		prep.setName("Té con leche");
		List<String> result = adviser.getBestFit(prep, "p");
		assertEquals(0, result.indexOf("Leche en Polvo"));
		assertEquals(1, result.indexOf("Carne Picada"));
	}

	@Test
	public void input20AzuTe() {// te con leche
		Preparation prep = new Preparation();
		prep.setName("Té con leche");
		List<String> result = adviser.getBestFit(prep, "Azu");
		assertTrue(result.contains("Azúcar"));
		assertEquals(1, result.size());
	}

	@Test
	public void input20AzuAlbondiga() {// Albondiga
		Preparation prep = new Preparation();
		prep.setName("Albóndigas con arroz");
		List<String> result = adviser.getBestFit(prep, "Azu");
		assertTrue(result.contains("Azúcar"));
		assertEquals(1, result.size());
	}

	@Before
	public void setContext() throws IOException {
		String filePath = new File("").getAbsolutePath();
		String file = filePath.concat(File.separator + "big.txt");
		PreparationRepository repository = new PreparationRepository();
		List<Consumption> teConsumptions = new ArrayList<Consumption>();
		List<Consumption> albondigasConsumptions = new ArrayList<Consumption>();
		Preparation te = new Preparation();
		te.setName("Té con leche");
		Preparation albondigas = new Preparation();
		albondigas.setName("Albóndigas con arroz");
		repository.getPreparations().add(te);
		Consumption azucarC = new Consumption();
		Ingredient azucar = new Ingredient();
		azucar.setName("Azúcar");
		azucarC.setIngredient(azucar);
		azucarC.setQuantity(300d);
		Ingredient saquito = new Ingredient();
		saquito.setName("Saquito de te");
		Consumption saquitoC = new Consumption();
		saquitoC.setIngredient(saquito);
		saquitoC.setQuantity(20d);
		Ingredient lecheEnPolvo = new Ingredient();
		lecheEnPolvo.setName("Leche en Polvo");
		Consumption lechenEnPolvoC = new Consumption();
		lechenEnPolvoC.setIngredient(lecheEnPolvo);
		lechenEnPolvoC.setQuantity(100d);
		Ingredient agua = new Ingredient();
		agua.setName("Agua");
		Consumption aguaC = new Consumption();
		aguaC.setIngredient(agua);
		aguaC.setQuantity(10d);
		teConsumptions.add(azucarC);
		teConsumptions.add(saquitoC);
		teConsumptions.add(lechenEnPolvoC);
		teConsumptions.add(aguaC);
		te.setConsumptions(teConsumptions);
		Ingredient arroz = new Ingredient();
		arroz.setName("Arroz");
		Consumption arrozC = new Consumption();
		arrozC.setIngredient(arroz);
		arrozC.setQuantity(1d);
		Ingredient carnePicada = new Ingredient();
		carnePicada.setName("Carne Picada");
		Consumption carnePicadaC = new Consumption();
		carnePicadaC.setIngredient(carnePicada);
		carnePicadaC.setQuantity(300d);
		albondigasConsumptions.add(arrozC);
		albondigasConsumptions.add(carnePicadaC);
		albondigas.setConsumptions(albondigasConsumptions);
		repository.getPreparations().add(albondigas);
		adviser = new IngredientAdviser(file, repository);
	}
}
