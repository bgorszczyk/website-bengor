package com.bengor.website.fullcalendar;

import java.io.Serializable;

public enum Priority implements Serializable {

	
	HIGH("HIGH","High priority"),
	MEDIUM("MEDIUM","Medium priority"),
	LOW("LOW","Low priority");
	/**
	 * 
	 */
	private static final long serialVersionUID = 343014291616279094L;
	
	private String libelle;
	private String code;

	private Priority(String libelle, String code) {
		this.libelle = libelle;
		this.code = code;
	}

	private Priority() {
	}
	
	public String getLibelle() {
		return libelle;
	}

	public String getCode() {
		return code;
	}
	
}
