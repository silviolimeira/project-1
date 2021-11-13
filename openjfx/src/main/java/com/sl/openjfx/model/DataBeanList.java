package com.sl.openjfx.model;

import java.util.ArrayList;

public class DataBeanList {

	public ArrayList<PeriodoReport> getDataBeanList() {
		ArrayList<PeriodoReport> dataBeanList = new ArrayList<PeriodoReport>();

		dataBeanList.add(produce(1, "Nome 1"));
		dataBeanList.add(produce(1, "Nome 2"));
		dataBeanList.add(produce(1, "Nome 3"));
		dataBeanList.add(produce(1, "Nome 4"));
		dataBeanList.add(produce(1, "Nome 5"));

		return dataBeanList;
	}

	/**
	 * This method returns a DataBean object, with name and country set in it.
	 */
	private PeriodoReport produce(Integer id, String nome) {
		PeriodoReport dataBean = new PeriodoReport(id, nome);

		return dataBean;
	}

}
