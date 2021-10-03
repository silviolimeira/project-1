package com.sl.batch.model;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TemperatureSensor {

	Long id;
	String entity;
	Float state;
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	Date date;
	
	public TemperatureSensor() { }

	public TemperatureSensor(Long id, String entity, Float state, Date date) {
		this.id = id;
		this.entity = entity;
		this.state = state;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public Float getState() {
		return state;
	}

	public void setState(Float state) {
		this.state = state;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TemperatureSensor other = (TemperatureSensor) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "TemperatureSensor [id=" + id + ", entity=" + entity + ", state=" + state + ", date=" + date + "]";
	}
	
	
}
