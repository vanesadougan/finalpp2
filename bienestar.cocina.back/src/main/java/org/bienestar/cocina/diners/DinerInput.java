package org.bienestar.cocina.diners;

import org.bienestar.cocina.domain.Diner;
import org.bienestar.cocina.exceptions.InvalidQuantityException;
import org.bienestar.cocina.specifications.validations.IsLesserThan;
import org.bienestar.cocina.specifications.validations.IsValidInteger;

public class DinerInput {
	private DinersRepository dinersRepository;

	public DinerInput(DinersRepository dinersRepository) {
		this.dinersRepository = dinersRepository;

	}

	public void registerQuantity(String quantity) throws InvalidQuantityException {
		Diner diner = new Diner();
		if (!new IsValidInteger().isSatisfiedBy(quantity)) {
			throw new InvalidQuantityException();
		}
		Integer quantityInt = Integer.parseInt(quantity);
		if (new IsLesserThan(0).isSatisfiedBy(quantityInt)) {
			throw new InvalidQuantityException();
		}
		diner.setQuantity(quantityInt);
		dinersRepository.getDiners().add(diner);
	}

	public Integer getDinersQuantity() {
		return dinersRepository.getDiners().stream().mapToInt(x -> x.getQuantity()).sum();
	}
}
