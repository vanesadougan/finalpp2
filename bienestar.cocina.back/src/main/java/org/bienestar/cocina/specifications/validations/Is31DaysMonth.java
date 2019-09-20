package org.bienestar.cocina.specifications.validations;

import java.util.ArrayList;
import java.util.List;

import org.bienestar.cocina.specifications.generic.AbstractSpecification;

public class Is31DaysMonth extends AbstractSpecification<String>{
	
	private String separator;

	private List<Integer> meses = new ArrayList<Integer>();
	
	public Is31DaysMonth(String separator) {
		this.separator = separator;
		meses.add(1);
		meses.add(3);
		meses.add(5);
		meses.add(7);
		meses.add(8);
		meses.add(10);
		meses.add(12);
	}
	
	public boolean isSatisfiedBy(String string) {
		String[] split = string.split(separator);
		return meses.contains(Integer.valueOf(split[1]));
	}

}
