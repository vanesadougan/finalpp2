package org.bienestar.cocina.back.senders;

import org.bienestar.cocina.back.messenger.Message;
import org.bienestar.cocina.exceptions.SendingException;

public interface Sender<T extends Message<?>> {

	void send(T message) throws SendingException;
}
