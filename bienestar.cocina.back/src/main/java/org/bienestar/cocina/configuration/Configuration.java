package org.bienestar.cocina.configuration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.bienestar.cocina.exceptions.InvalidPropertieValue;
import org.bienestar.cocina.specifications.generic.Specification;

public class Configuration {

	private Properties properties;
	
	public Configuration(String fileName) throws IOException {
		
		try (InputStream stream = ClassLoader.getSystemResourceAsStream(fileName)){
			if(stream == null) {
				throw new FileNotFoundException();
			}
			properties = new Properties();
			properties.load(stream);
		} catch (IOException e) {
			throw e;
		}
	}
	
	public String getProperty(String key) {
		return properties.getProperty(key);
	}
	
	public String getProperty(String key, Specification<String> spec) throws InvalidPropertieValue {
		String prop = properties.getProperty(key);
		if(!spec.isSatisfiedBy(prop)) {
			throw new InvalidPropertieValue(key);
		}
		return prop;
	}
	
	public String getNumericProperty(String key, Specification<Integer> spec) throws InvalidPropertieValue {
		String prop = properties.getProperty(key);
		Integer value = Integer.valueOf(prop);
		if(!spec.isSatisfiedBy(value)) {
			throw new InvalidPropertieValue(key);
		}
		return prop;
	}
}
