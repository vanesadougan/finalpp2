package org.bienestar.cocina.back.messenger;

import java.util.List;
import java.util.stream.Collectors;

public class RetryManager {

	private RetryTable table;

	public RetryTable getTable() {
		return table;
	}

	public RetryManager() {
		table = new RetryTable();
	}

	public void onError(Message<?> m) {
		List<FailedMessageEntry> result = findMessage(m);
		if (result.isEmpty()) {
			FailedMessageEntry newEntry = new FailedMessageEntry();
			newEntry.setQuantity(1);
			newEntry.setMessage(m);
			table.add(newEntry);
		} else {
			FailedMessageEntry found = result.get(0);
			found.setQuantity(found.getQuantity() + 1);
		}
	}

	public void onSuccess(Message<?> m) {
		List<FailedMessageEntry> success = findMessage(m);
		if (success.isEmpty()) return;
		table.remove(success.get(0));
	}
	
	private List<FailedMessageEntry> findMessage(Message<?> m) {
		List<FailedMessageEntry> result = table.stream().filter(x -> x.getMessage() == m).collect(Collectors.toList());
		return result;
	}
}
