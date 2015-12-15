package com.lor.rentalapp.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {

	public static Date toDateFormat(String dtStr) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/mm/YYYY");		
		Date dt = null;
		try {
			dt = sdf.parse(dtStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dt;
	}
}
