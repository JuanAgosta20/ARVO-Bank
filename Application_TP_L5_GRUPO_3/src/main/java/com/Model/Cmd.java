package com.Model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Cmd {

	public static Date crearFecha() {
		LocalDate ldate = LocalDate.now();
		return Date.from(ldate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
	
	public static Date crearFecha(int day, int month, int year) {
		LocalDate ldate = LocalDate.of(year, month, day);
		return Date.from(ldate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
	
	public static String getFormattedDate(Date date, Boolean getHora) {
		if(date == null)
			return "error";
		SimpleDateFormat format;
		if(getHora)
			format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		else 
			format = new SimpleDateFormat("dd-MM-yyyy");
		return format.format(date);
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
	
	public static Date crearFecha(String sDate) throws ParseException {
		sDate = sDate.replace("-", "/");
		Date date = new SimpleDateFormat("yyyy/MM/dd").parse(sDate);
		return date;
	}
	
	public static String crearCBU(String dni, int countAcc) {
		StringBuilder strbuild = new StringBuilder("45072230");
		Random rng = new Random(Integer.parseInt(dni+countAcc));
		for (int i = 0; i < 13; i++) {
			int num = rng.nextInt(10);
			strbuild.append(num);
		}
		strbuild.append(countAcc + 1);
		return strbuild.toString();
	}
}
