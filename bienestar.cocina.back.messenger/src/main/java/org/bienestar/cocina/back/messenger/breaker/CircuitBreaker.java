package org.bienestar.cocina.back.messenger.breaker;

import java.util.Timer;
import java.util.TimerTask;

import org.bienestar.cocina.exceptions.OpenCircuitException;

public class CircuitBreaker {

	private CircuitBreakerCommand command;
	private Integer errorLimit;
	private Integer timeout;
	private Integer errorCount;
	private CircuitBreakerState state = CircuitBreakerState.CLOSE;

	public CircuitBreaker(Integer errorLimit, Integer timeout) {
		super();
		this.errorLimit = errorLimit;
		this.timeout = timeout;
		this.errorCount = 0;
	}

	public CircuitBreaker(CircuitBreakerCommand command, Integer errorLimit, Integer timeout) {
		this(errorLimit, timeout);
		this.command = command;
	}

	public void run() throws Exception {

		try {
			if (CircuitBreakerState.OPEN.equals(state)) {
				throw new OpenCircuitException();
			}

			command.execute();

			if (CircuitBreakerState.HALF_OPEN.equals(state)) {
				changeState(CircuitBreakerState.CLOSE);
				errorCount = 0;
			}

		} catch (OpenCircuitException e) {
			throw e;
		} catch (Exception e) {

			if (this.errorCount < this.errorLimit) {
				this.errorCount++;
			}

			if (this.errorCount == this.errorLimit) {
				trip();
				startTimer();
			}
			throw e;
		}
	}

	private void startTimer() {
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				changeState(CircuitBreakerState.HALF_OPEN);
			}
		};
		Timer timer = new Timer();
		timer.schedule(task, timeout);
	}

	private void trip() {
		changeState(CircuitBreakerState.OPEN);
	}

	private void changeState(CircuitBreakerState newState) {
		this.state = newState;
	}

	public void setCommand(CircuitBreakerCommand command) {
		this.command = command;
	}

}
