package org.bienestar.cocina.validaciones;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

public class InputDateTest {

	private SimpleDateFormat sdf;
	
	@Before
	public void init(){
		sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(true);
	}
	
	@Test(expected = ParseException.class)
	public void primeroEnero() throws ParseException{
		sdf.parse("01/01");
	}
	
	@Test(expected = ParseException.class)
	public void diaNoValido() throws ParseException{
		sdf.parse("32/01");
	}
	
	@Test(expected = ParseException.class)
	public void treintaFebrero() throws ParseException{
		sdf.parse("30/02");
	}
}
