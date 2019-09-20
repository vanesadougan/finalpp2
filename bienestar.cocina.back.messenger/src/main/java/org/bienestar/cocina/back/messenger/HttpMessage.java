package org.bienestar.cocina.back.messenger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class HttpMessage implements Message<List<NameValuePair>> {

	private Map<String, String> parameters;
	
	public HttpMessage(Map<String, String> parameters) {
		this.parameters = parameters;
	}
	
	@Override
	public List<NameValuePair> getMessage() {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		for(Entry<String, String> entry : parameters.entrySet()){
			params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
		return params;
	}

}
