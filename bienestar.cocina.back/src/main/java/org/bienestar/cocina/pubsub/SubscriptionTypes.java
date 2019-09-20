package org.bienestar.cocina.pubsub;

public enum SubscriptionTypes {
	CONSUMPTION("consumption");
	private String type;
	
	private SubscriptionTypes(String type) {
		this.type = type;
	}
	
	public String getType(){
		return type;
	}
}
