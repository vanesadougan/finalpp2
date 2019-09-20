package org.bienestar.cocina.back.messenger.iteracion.segunda;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.bienestar.cocina.back.messenger.HttpMessage;
import org.bienestar.cocina.back.messenger.Message;
import org.bienestar.cocina.back.messenger.TextMessage;
import org.bienestar.cocina.back.messenger.breaker.CircuitBreaker;
import org.bienestar.cocina.back.messenger.messages.MessageDispatcher;
import org.bienestar.cocina.back.senders.HttpSender;
import org.bienestar.cocina.back.senders.Sender;
import org.bienestar.cocina.exceptions.InvalidMessageException;
import org.bienestar.cocina.exceptions.SendingException;
import org.bienestar.cocina.exceptions.TimeOutException;
import org.junit.Before;
import org.junit.Test;

public class Story4Test {

	private CircuitBreaker cb;
	private Message<?> message;
	
	@Before
	public void context(){
		cb = new CircuitBreaker(2, 1000);
	    message = new HttpMessage(new HashMap<>());
	}
	
	@Test(expected = SendingException.class)
	public void genericError() throws Exception{
		Sender<Message<List<NameValuePair>>> sender = new HttpSender("generic");
		MessageDispatcher<?> dispatcher = new MessageDispatcher(cb, sender);
		dispatcher.dispatch(message);
	}
	
	@Test(expected = TimeOutException.class)
	public void timeoutError() throws Exception{
		Sender<Message<List<NameValuePair>>> sender = new HttpSender("timeout");
		MessageDispatcher<?> dispatcher = new MessageDispatcher(cb, sender);
		dispatcher.dispatch(message);
	}
	
	@Test(expected = InvalidMessageException.class)
	public void invalidMessageError() throws Exception{
		Sender<Message<List<NameValuePair>>> sender = new HttpSender("invalid");
		MessageDispatcher<?> dispatcher = new MessageDispatcher(cb, sender);
		dispatcher.dispatch(message);
	}
	
	@Test
	public void sendingOk() throws Exception{
		Sender<Message<List<NameValuePair>>> sender = new HttpSender("ok");
		MessageDispatcher<?> dispatcher = new MessageDispatcher(cb, sender);
		dispatcher.dispatch(message);
	}
}
