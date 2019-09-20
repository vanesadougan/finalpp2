package org.bienestar.cocina.back.messenger.breaker;

public enum CircuitBreakerName {

	TEST_BREAKER("breaker");
	private String nombre;
	
	private CircuitBreakerName(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return nombre;
	}
}
