package com.senior.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cidade implements Serializable
{
	
	private Long ibge_id;
	private String uf;
	private String name;
	private String capital;
	private Double lon ;
	private Double lat ;
	private String no_accents;
	private String altermative_names;
	private String microregion;
	private String mesoregion;

	private static final long serialVersionUID = 1L;
	
	@Id
	public Long getIbge_id() {
		return ibge_id;
	}
	public void setIbge_id(Long ibge_id) {
		this.ibge_id = ibge_id;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String  getCapital() {
		return capital;
	}
	public void setCapital(String  capital) {
		this.capital = capital;
	}
	public Double getLon() {
		return lon;
	}
	public void setLon(Double lon) {
		this.lon = lon;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public String getNo_accents() {
		return no_accents;
	}
	public void setNo_accents(String no_accents) {
		this.no_accents = no_accents;
	}
	public String getAltermative_names() {
		return altermative_names;
	}
	public void setAltermative_names(String altermative_names) {
		this.altermative_names = altermative_names;
	}
	public String getMicroregion() {
		return microregion;
	}
	public void setMicroregion(String microregion) {
		this.microregion = microregion;
	}
	public String getMesoregion() {
		return mesoregion;
	}
	public void setMesoregion(String mesoregion) {
		this.mesoregion = mesoregion;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
		

}
