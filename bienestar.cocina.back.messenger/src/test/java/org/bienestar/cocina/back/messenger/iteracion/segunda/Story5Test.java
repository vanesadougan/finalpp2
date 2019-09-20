package org.bienestar.cocina.back.messenger.iteracion.segunda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.bienestar.cocina.back.messenger.FailedMessageEntry;
import org.bienestar.cocina.back.messenger.Message;
import org.bienestar.cocina.back.messenger.RetryManager;
import org.bienestar.cocina.back.messenger.TextMessage;
import org.junit.Test;

public class Story5Test {

	@Test
	public void FailedMessage1() {
		RetryManager retryManager = new RetryManager();
		Message msg = new TextMessage("texto");
		retryManager.onError(msg);
		FailedMessageEntry entry = retryManager.getTable().get(0);
		assertEquals(msg, entry.getMessage());
		assertEquals(1, entry.getQuantity());
	}

	@Test
	public void FailedMessage2() {
		RetryManager retryManager = new RetryManager();
		Message msg = new TextMessage("texto");
		retryManager.onError(msg);
		retryManager.onError(msg);
		FailedMessageEntry entry = retryManager.getTable().get(0);
		assertEquals(msg, entry.getMessage());
		assertEquals(2, entry.getQuantity());
	}
	
	@Test
	public void FailedMessage5() {
		RetryManager retryManager = new RetryManager();
		Message msg = new TextMessage("texto");
		retryManager.onError(msg);
		retryManager.onError(msg);
		retryManager.onError(msg);
		retryManager.onError(msg);
		retryManager.onError(msg);
		FailedMessageEntry entry = retryManager.getTable().get(0);
		assertEquals(msg, entry.getMessage());
		assertEquals(5, entry.getQuantity());
	}
	
	@Test
	public void FailedSuccess() {
		RetryManager retryManager = new RetryManager();
		Message msg = new TextMessage("texto");
		retryManager.onError(msg);
		FailedMessageEntry entry = retryManager.getTable().get(0);
		assertEquals(msg, entry.getMessage());
		assertEquals(1, entry.getQuantity());
		retryManager.onSuccess(msg);
		assertTrue(retryManager.getTable().isEmpty());
	}
	
}
