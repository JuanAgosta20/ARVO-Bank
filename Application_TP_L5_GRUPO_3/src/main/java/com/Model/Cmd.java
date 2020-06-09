package com.Model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class Cmd {

	public static Date crearFecha(int day, int month, int year) {
		LocalDate ldate = LocalDate.of(year, month, day);
		return Date.from(ldate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
	
	public static Date crearFechaHora(int day, int month, int year, int hour, int min, int seg) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, day);
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, min);
		cal.set(Calendar.SECOND, seg);
		Date date = cal.getTime();
		
		return date;
	}
}
