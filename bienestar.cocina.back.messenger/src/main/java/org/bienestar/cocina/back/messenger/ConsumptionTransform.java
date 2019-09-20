package org.bienestar.cocina.back.messenger;

import java.util.HashMap;
import java.util.Map;

import org.bienestar.cocina.back.transformer.Transformer;
import org.bienestar.cocina.domain.Consumption;

public class ConsumptionTransform implements Transformer<Consumption, HttpMessage>{

	@Override
	public HttpMessage transform(Consumption origin) {
		Map<String, String> parameters = new HashMap<>();
		parameters.put("ingredient", origin.getIngredient().toString());
		parameters.put("quantity", origin.getQuantity().toString());
		return new HttpMessage(parameters);
	}

}
