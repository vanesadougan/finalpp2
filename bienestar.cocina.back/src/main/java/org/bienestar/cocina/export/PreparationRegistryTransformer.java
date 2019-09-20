/*package org.bienestar.cocina.export;

import org.bienestar.cocina.domain.PreparationRegistry;

public class PreparationRegistryTransformer implements CSVTransformer<PreparationRegistry> {

	public String transform(PreparationRegistry value) {
		StringBuilder sb = new StringBuilder();
		String template = value.getDate() + "," + value.getDiners() + "," + checkNull(value.getPreparation().getName()) + ",";
		value.getPreparation().getConsumptions().stream().forEach(x -> {
			sb.append(template);
			sb.append(checkNull(x.getIngredient().getName()));
			sb.append(",");
			sb.append(x.getQuantity());
			sb.append(System.lineSeparator());
		});
		return sb.toString().trim();
	}
	
	private String checkNull(String str) {
		return str == null ? "" : str;
	}

}*/
