package org.bienestar.cocina.back.messenger.iteracion.segunda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.bienestar.cocina.back.messenger.ConsumptionMessage;
import org.bienestar.cocina.back.messenger.Message;
import org.bienestar.cocina.back.messenger.MessageQueue;
import org.bienestar.cocina.domain.Consumption;
import org.bienestar.cocina.domain.Ingredient;
import org.junit.Test;

public class Story2Test {

	@Test
	public void envio10Saquitos() {
		MessageQueue queue = MessageQueue.getInstance();
		Ingredient te = new Ingredient();
		te.setName("Saquito de te");
		Consumption teConsumption = new Consumption();
		teConsumption.setIngredient(te);
		teConsumption.setQuantity(10d);
		ConsumptionMessage msgTe = new ConsumptionMessage(teConsumption);
		queue.add(msgTe);
		ConsumptionMessage poll = (ConsumptionMessage)queue.poll();
		assertEquals("Saquito de te", poll.getMessage().getIngredient().getName());
		assertTrue(queue.isEmpty());
	}
	
	@Test
	public void envio10Saquitos100Azucar() {
		MessageQueue queue = MessageQueue.getInstance();
		Ingredient te = new Ingredient();
		te.setName("Saquito de te");
		Consumption teConsumption = new Consumption();
		teConsumption.setIngredient(te);
		teConsumption.setQuantity(10d);
		ConsumptionMessage msgTe = new ConsumptionMessage(teConsumption);
		Ingredient azucar = new Ingredient();
		azucar.setName("Azúcar");
		Consumption azucarConsumption = new Consumption();
		azucarConsumption.setIngredient(azucar);
		azucarConsumption.setQuantity(100d);
		ConsumptionMessage msgAzucar = new ConsumptionMessage(azucarConsumption);
		queue.add(msgTe);
		queue.add(msgAzucar);
		ConsumptionMessage poll = (ConsumptionMessage)queue.poll();
		assertEquals("Saquito de te", poll.getMessage().getIngredient().getName());
		ConsumptionMessage poll2 = (ConsumptionMessage)queue.poll();
		assertEquals("Azúcar", poll2.getMessage().getIngredient().getName());
		assertTrue(queue.isEmpty());
	}
}
