package org.bienestar.cocina.specifications.validations;

import org.bienestar.cocina.specifications.generic.AbstractSpecification;

public class IsValidInteger extends AbstractSpecification<String> {

	public boolean isSatisfiedBy(String t) {
		 try {  
	         Integer.parseInt(t);  
	         return true;  
	      } catch (NumberFormatException e) {  
	         return false;  
	      }  
	}

}
