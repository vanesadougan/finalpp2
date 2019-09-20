package org.bienestar.cocina.back.messenger;

public class FailedMessageEntry {

	private int quantity;
	private Message message;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	
}
