package org.bienestar.cocina.internationalization;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;

public class ResourcesTest {

	@Test
	public void sameInstance() {
		MessageResource resource = MessageResource.getInstance();
		MessageResource resource2 = MessageResource.getInstance();
		assertEquals(resource, resource2);
	}

	@Test
	public void findKeyOK() {
		MessageResource resource = MessageResource.getInstance(new Locale("es", "AR"));
		String message = resource.getMessage("ex.invalidseparator");
		assertEquals("Separador inv\u00e1lido", message);
	}

	@Test
	public void findEnglishKeyOK() {
		MessageResource resource = MessageResource.getInstance(Locale.US);
		String message = resource.getMessage("ex.invalidseparator");
		assertEquals("Invalid separator", message);
	}
	
	@Test
	public void findKeyNOK() {
		MessageResource resource = MessageResource.getInstance(new Locale("es", "AR"));
		String message = resource.getMessage("no.exists");
		assertEquals("", message);
	}
}
