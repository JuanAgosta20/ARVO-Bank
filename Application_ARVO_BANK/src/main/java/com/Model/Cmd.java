package com.Model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Cmd {

	public static Date crearFecha(int day, int month, int year) {
		LocalDate ldate = LocalDate.of(year, month, day);
		return Date.from(ldate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
	
}
