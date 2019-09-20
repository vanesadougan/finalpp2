package org.bienestar.cocina.back.messenger.breaker;

public enum CircuitBreakerState {
	CLOSE(0), HALF_OPEN(2), OPEN(1);

	private Integer value;

	private CircuitBreakerState(Integer value) {
		this.value = value;
	}

}
