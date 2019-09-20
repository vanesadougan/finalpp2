package org.bienestar.cocina.back.messenger.breaker;

public interface CircuitBreakerCommand {
	void execute() throws Exception;
}
