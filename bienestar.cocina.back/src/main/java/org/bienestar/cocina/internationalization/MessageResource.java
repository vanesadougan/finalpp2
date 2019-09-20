package org.bienestar.cocina.internationalization;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class MessageResource {

	private ResourceBundle bundle;

	private static Map<Locale, MessageResource> dic = new HashMap<Locale, MessageResource>();

	private MessageResource(ResourceBundle bundle) {
		this.bundle = bundle;
	}

	private static MessageResource createInstance(Locale locale) {
		return new MessageResource(ResourceBundle.getBundle("messages", locale));
	}

	public static MessageResource getInstance() {
		return getInstance(Locale.getDefault());
	}

	public static MessageResource getInstance(Locale locale) {
		if (dic.containsKey(locale)) {
			return dic.get(locale);
		} else {
			MessageResource res = createInstance(locale);
			dic.put(locale, res);
			return res;
		}
	}

	public String getMessage(String key) {
		String message;
		try {
			message = bundle.getString(key);

		} catch (MissingResourceException e) {
			message = "";
		}
		return message;
	}
}
