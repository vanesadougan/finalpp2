package org.bienestar.cocina.preparation;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.bienestar.cocina.domain.PreparationRegistry;
import org.bienestar.cocina.exceptions.InvalidRange;

public class PreparationFilter {

	public List<PreparationRegistry> getPreparationFilter(List<PreparationRegistry> preparations, LocalDate from, LocalDate to) throws InvalidRange{
		if(from.isAfter(to)){
			throw new InvalidRange();
		}
		
		return preparations.stream()
				.filter(x -> (x.getDate().isAfter(from)||x.getDate().equals(from)) && (x.getDate().isBefore(to) || x.getDate().equals(to) )).collect(Collectors.toList());
	}
	
	public List<PreparationRegistry> getPreparationFilter(List<PreparationRegistry> preparations, LocalDate day) throws InvalidRange{
		return this.getPreparationFilter(preparations,day, day);
	}
}
