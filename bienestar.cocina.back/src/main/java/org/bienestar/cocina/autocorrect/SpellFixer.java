package org.bienestar.cocina.autocorrect;

import java.io.IOException;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.bienestar.cocina.domain.Preparation;

public class SpellFixer {

	private Map<Character, List<String>> repository;
	
	public SpellFixer(Map<Character, List<String>> repository)
			throws IOException {
		this.repository = repository;
	}

	public List<String> getBestFit(String keyword) {
		Map<String, Integer> candidates = new HashMap<String, Integer>();
		for (Character c : keyword.toLowerCase().toCharArray()) {
			if (repository.containsKey(c)) {
				this.fillCandidates(candidates, repository.get(c));
			}
		}
		if (!candidates.isEmpty()) {
			return candidates.entrySet().stream().map(x -> x.getKey())
					.filter(x -> Normalizer.normalize(x, Form.NFD).toLowerCase().contains(keyword.toLowerCase()))
					.collect(Collectors.toList());
		}
		return null;
	}

	private void fillCandidates(Map<String, Integer> candidates, List<String> list) {
		for (String word : list) {
			candidates.put(word, candidates.containsKey(word) ? candidates.get(word) + 1 : 1);
		}
	}

}
