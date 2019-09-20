package org.bienestar.cocina.interpreters;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.bienestar.cocina.configuration.Configuration;

public class MonthExpression implements Expression {

	private Map<String, String> monthDictionary;
	
	public MonthExpression() {
		monthDictionary = new HashMap<>();
		monthDictionary.put("enero", "01");
		monthDictionary.put("febrero", "02");
		monthDictionary.put("marzo", "03");
		monthDictionary.put("abril", "04");
		monthDictionary.put("mayo", "05");
		monthDictionary.put("junio", "06");
		monthDictionary.put("julio", "07");
		monthDictionary.put("agosto", "08");
		monthDictionary.put("septiembre", "09");
		monthDictionary.put("octubre", "10");
		monthDictionary.put("noviembre", "11");
		monthDictionary.put("diciembre", "12");
		monthDictionary.put("ene", "01");
		monthDictionary.put("feb", "02");
		monthDictionary.put("mar", "03");
		monthDictionary.put("abr", "04");
		monthDictionary.put("may", "05");
		monthDictionary.put("jun", "06");
		monthDictionary.put("jul", "07");
		monthDictionary.put("ago", "08");
		monthDictionary.put("sep", "09");
		monthDictionary.put("oct", "10");
		monthDictionary.put("nov", "11");
		monthDictionary.put("dic", "12");
	}
	
	@Override
	public void interpret(DateContext contexto) {
		if (contexto.getMonth() == null) {
			try {
				Configuration config = new Configuration("config/config.properties");
				String fechaDefault = config.getProperty("fechaDefault");
				if(fechaDefault != null){
					contexto.setMonth(this.getMonth(contexto.getDay(), fechaDefault));
				} else {
					this.getCurrentMonth();
				}
			} catch (IOException e) {
				this.getCurrentMonth();
			}
		} else if (!StringUtils.isNumeric(contexto.getMonth())) {
			contexto.setMonth(this.convertToMonth(contexto.getMonth()));
		}
	}

	private String getCurrentMonth(){
		Integer currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
		return this.formattedMonth(currentMonth);
	}
	
	private String convertToMonth(String month) {
		String lowerCaseMonth = month.toLowerCase();
		return monthDictionary.get(lowerCaseMonth);
	}

	private String getMonth(String givenDay, String dateDefault) {
		String[] splitted = dateDefault.split("/");
		Integer monthDefault = Integer.valueOf(splitted[1]);
		Integer monthBefore = monthDefault - 1;
		
		if(this.isDayDefaultBefore(givenDay, splitted[0])){
			return this.formattedMonth(monthBefore);
		} else {
			return this.formattedMonth(monthDefault);
		}
	}
	
	private String formattedMonth (Integer month){
		return StringUtils.leftPad(month.toString(), 2, "0");
	}
	
	private boolean isDayDefaultBefore(String givenDay, String dayDefault){
		Integer intGivenDay = Integer.valueOf(givenDay);
		Integer intDayDefault = Integer.valueOf(dayDefault);
		return intGivenDay > intDayDefault;
	}
}
