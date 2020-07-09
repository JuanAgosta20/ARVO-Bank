package com.Model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Cmd {

	public static LocalDate crearFecha(Date date) {
	    return date.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}
	
	public static Date crearFecha(LocalDate ldate) {
		return Date.from(ldate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
	
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
	
	public static String getLoanNameState(int state) {
		
		String[] states = new String[] {
				"Denegado",
				"Pendiente",
				"Activo",
				"Finalizado"
		};
		
		return states[state];
		
	}
	
	public static Date crearFecha(String sDate) throws ParseException {
		sDate = sDate.replace("-", "/");
		Date date = new SimpleDateFormat("yyyy/MM/dd").parse(sDate);
		return date;
	}
	
	public static int countPayments(List<FeePayment> list) {
		int count = 0;
		for (FeePayment fee : list) {
			if(fee.getState().equals(1))
				count++;
		}
		return count;
	}
	
	public static String crearCBU(String dni) {
		StringBuilder strbuild = new StringBuilder("4507223");
		Random rng = new Random(System.nanoTime());
		for (int i = 0; i < 8; i++) {
			int num = rng.nextInt(10);
			strbuild.append(num);
		}
		
		rng = new Random(Integer.parseInt(dni));
		for (int i = 0; i < 7; i++) {
			int num = rng.nextInt(10);
			strbuild.append(num);
		}
		return strbuild.toString();
	}
	
}
