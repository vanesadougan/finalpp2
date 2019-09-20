package org.bienestar.cocina.back.senders;

import java.util.List;

import org.apache.http.NameValuePair;
import org.bienestar.cocina.back.messenger.Message;
import org.bienestar.cocina.exceptions.InvalidMessageException;
import org.bienestar.cocina.exceptions.SendingException;
import org.bienestar.cocina.exceptions.TimeOutException;

public class HttpSender implements Sender<Message<List<NameValuePair>>> {

	private String urlService;

	public HttpSender(String urlService) {
		this.urlService = urlService;
	}

	@Override
	public void send(Message<List<NameValuePair>> message) throws SendingException {
		switch (urlService) {
		case "generic":
			throw new SendingException();
		case "timeout":
			throw new TimeOutException();
		case "invalid":
			throw new InvalidMessageException();
		case "ok":
			break;
		}
		return;

	}

}
