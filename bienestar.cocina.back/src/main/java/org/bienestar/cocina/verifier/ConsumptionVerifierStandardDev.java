package org.bienestar.cocina.verifier;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.bienestar.cocina.domain.Consumption;
import org.bienestar.cocina.domain.Preparation;
import org.bienestar.cocina.domain.PreparationRegistry;
import org.bienestar.cocina.exceptions.ConsumptionOutOfRangeException;
import org.bienestar.cocina.preparationRegistry.PreparationRegistryRepository;
import org.bienestar.cocina.repository.RepositoryStore;
import org.bienestar.cocina.specifications.validations.IsGreaterThanDouble;
import org.bienestar.cocina.specifications.validations.IsLesserThanDouble;

public class ConsumptionVerifierStandardDev {

	private PreparationRegistryRepository preparationRegistryRepository;

	public ConsumptionVerifierStandardDev(PreparationRegistryRepository preparationRegistryRepository) {
		this.preparationRegistryRepository = preparationRegistryRepository;
	}

	public void registerConsumption(Consumption consumption, Preparation preparation, Integer diners)
			throws ConsumptionOutOfRangeException {
		List<PreparationRegistry> filteredPreps = preparationRegistryRepository.getPreparationRegistries().stream()
				.filter(prepReg -> prepReg.getPreparation().equals(preparation)
						&& prepReg.getPreparation().getConsumptions().stream()
								.anyMatch(cons -> cons.getIngredient().equals(consumption.getIngredient())))
				.collect(Collectors.toList());

		if (filteredPreps.size() < 10) {
			new ConsumptionVerifier(RepositoryStore.getInstance().getConsumptionRepository())
					.registerConsumption(consumption, diners);
			return;
		}

		Double[] quantitiesList = filteredPreps.stream()
				.map(prep -> prep.getPreparation().getConsumptions().stream().mapToDouble(cons -> {
					if (cons.getIngredient().equals(consumption.getIngredient()))
						return cons.getQuantity() / prep.getDiners();
					else
						return 0;
				}).sum()).toArray(Double[]::new);

		double sum = 0;
		for (Double quantity : quantitiesList) {
			sum += quantity;
		}
		double quantitiesAverage = sum / quantitiesList.length;

		StandardDeviation sd = new StandardDeviation(false);
		double stdDev = sd.evaluate(Stream.of(quantitiesList).mapToDouble(Double::doubleValue).toArray());
		double inputValue = consumption.getQuantity() / diners;

		if (!new IsGreaterThanDouble(quantitiesAverage - stdDev).and(new IsLesserThanDouble(quantitiesAverage + stdDev))
				.isSatisfiedBy(inputValue))
			throw new ConsumptionOutOfRangeException();

	}

}
