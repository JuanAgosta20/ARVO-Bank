package com.Model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Cmd {

	public static Date crearFecha(int day, int month, int year) {
		LocalDate ldate = LocalDate.of(year, month, day);
		return Date.from(ldate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
	
	public static String getStringStateFrom(Object obj) {
		if(obj instanceof Account) {
			Account acc = (Account) obj;
			switch(acc.getState()) {
			case 1: return "Pendiente";
			}
		}
		return "error en el estado";
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
	
	public static String crearCBU(String dni, int countAcc) {
		StringBuilder strbuild = new StringBuilder("45072230");
		Random rng = new Random(Integer.parseInt(dni));
		for (int i = 0; i < 13; i++) {
			int num = rng.nextInt(10);
			System.out.println(num);
			strbuild.append(num);
		}
		strbuild.append(countAcc + 1);
		return strbuild.toString();
	}
}
