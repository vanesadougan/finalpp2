package org.bienestar.cocina.iteracion.segunda;

import org.bienestar.cocina.interpreters.DateInterpreter;
import org.junit.Assert;
import org.junit.Test;

public class Story1Test {

	@Test
	public void interpreterOne() {
		DateInterpreter interpreter = new DateInterpreter();
		String dateInterpreted = interpreter.interpret("03-Mar");
		Assert.assertEquals("03/03/2018", dateInterpreted);
	}
	
	@Test
	public void interpreterTwo() {
		DateInterpreter interpreter = new DateInterpreter();
		String dateInterpreted = interpreter.interpret("3-MAR");
		Assert.assertEquals("03/03/2018", dateInterpreted);
	}
	
	@Test
	public void interpreterThree() {
		DateInterpreter interpreter = new DateInterpreter();
		String dateInterpreted = interpreter.interpret("3 marzo");
		Assert.assertEquals("03/03/2018", dateInterpreted);
	}
	
	@Test
	public void interpreterFour() {
		DateInterpreter interpreter = new DateInterpreter();
		String dateInterpreted = interpreter.interpret("3 MARZO");
		Assert.assertEquals("03/03/2018", dateInterpreted);
	}
	
	@Test
	public void interpreterFive() {
		DateInterpreter interpreter = new DateInterpreter();
		String dateInterpreted = interpreter.interpret("3 de marzo");
		Assert.assertEquals("03/03/2018", dateInterpreted);
	}
	
	@Test
	public void interpreterSix() {
		DateInterpreter interpreter = new DateInterpreter();
		String dateInterpreted = interpreter.interpret("Mar, 25");
		Assert.assertEquals("25/03/2018", dateInterpreted);
	}
	
	@Test
	public void interpreterSeven() {
		DateInterpreter interpreter = new DateInterpreter();
		String dateInterpreted = interpreter.interpret("Mar-03");
		Assert.assertEquals("03/03/2018", dateInterpreted);
	}
	
	@Test
	public void interpreterEight() {
		DateInterpreter interpreter = new DateInterpreter();
		String dateInterpreted = interpreter.interpret("10");
		Assert.assertEquals("10/10/2018", dateInterpreted);
	}
	
	@Test
	public void interpreterNine() {
		DateInterpreter interpreter = new DateInterpreter();
		String dateInterpreted = interpreter.interpret("21");
		Assert.assertEquals("21/09/2018", dateInterpreted);
	}
}
