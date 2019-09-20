package org.bienestar.cocina.autocorrect;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResourceReader {

	private final Map<Character, List<String>> nWords = new HashMap<Character, List<String>>();

	public ResourceReader(String path) throws IOException {
		super();
		BufferedReader in = new BufferedReader(new FileReader(path));
		for (String temp = ""; temp != null; temp = in.readLine()) {
			String[] words = temp.split(", ");
			for (String item : words) {
				String word = Normalizer.normalize(item, Form.NFD);
				for (Character c : word.toLowerCase().toCharArray()) {
					List<String> lista;
					if (getWords().containsKey(c)) {
						lista = getWords().get(c);
					} else {
						lista = new ArrayList<String>();
					}
					lista.add(item);
					getWords().put(c, lista);
				}
			}
		}
		in.close();
	}

	public Map<Character, List<String>> getWords() {
		return nWords;
	}

}
