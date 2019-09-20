package org.bienestar.cocina.specifications.validations;

import java.util.ArrayList;
import java.util.List;

import org.bienestar.cocina.specifications.generic.AbstractSpecification;

public class Is30DaysMonth extends AbstractSpecification<String>{

	private String separator;

	private List<Integer> meses = new ArrayList<Integer>();
	
	public Is30DaysMonth(String separator) {
		this.separator = separator;
		meses.add(4);
		meses.add(6);
		meses.add(9);
		meses.add(11);
	}
	
	public boolean isSatisfiedBy(String string) {
		String[] split = string.split(separator);
		return meses.contains(Integer.valueOf(split[1]));
	}

}
