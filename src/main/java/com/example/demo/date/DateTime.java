package com.example.demo.date;


import com.ibm.icu.text.DateFormat;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.TimeZone;
import com.ibm.icu.util.ULocale;

public class DateTime {

	public String webTime() {
		ULocale locale = new ULocale("fa_IR@calendar=persian");
		Calendar calendar = Calendar.getInstance(locale);
		DateFormat dc = DateFormat.getTimeInstance(DateFormat.MEDIUM,locale);	

		return dc.format(calendar);
	}
	
	public String webDate() {
		
		ULocale locale = new ULocale("fa_IR@calendar=persian");
		Calendar calendar = Calendar.getInstance(locale);
		DateFormat df = DateFormat.getDateInstance(DateFormat.ERA_FIELD , locale);	

		return df.format(calendar);
	}


}
