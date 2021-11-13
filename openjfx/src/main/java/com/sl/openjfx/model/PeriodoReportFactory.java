package com.sl.openjfx.model;

import java.util.Arrays;
import java.util.Collection;

public class PeriodoReportFactory {

	static private PeriodoReport[] data = { new PeriodoReport(1, "Nome 01"), new PeriodoReport(2, "Nome 02"),
			new PeriodoReport(3, "Nome 03"), new PeriodoReport(4, "Nome 04"), new PeriodoReport(5, "Nome 05"), };

	public static Object[] getBeanArray() {
		return data;
	}

	public static Collection<PeriodoReport> getBeanCollection() {
		return Arrays.asList(data);
	}

}
