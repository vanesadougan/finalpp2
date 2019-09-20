package org.bienestar.cocina.back.messenger.breaker;

import java.util.HashMap;
import java.util.Map;

public class CircuitBreakerRegistry {

	private static CircuitBreakerRegistry instance;
	private Map<String, CircuitBreaker> registry = new HashMap<String, CircuitBreaker>();

	private CircuitBreakerRegistry() {
	}

	public static synchronized CircuitBreakerRegistry getInstance() {
		if (instance == null) {
			instance = new CircuitBreakerRegistry();
		}
		return instance;
	}

	public synchronized CircuitBreaker getCircuitBreaker(String name) {
		return registry.get(name);
	}

	public synchronized void register(String name, CircuitBreaker breaker) {
		if (!isRegistered(name)) {
			registry.put(name, breaker);
		}
	}

	private boolean isRegistered(final String name) {
		return registry.containsKey(name);
	}
}
