package com.bengor.website.fullcalendar;

public enum PriorityEnum {
	
	HIGH(5L,"HIGH","High priority"),
	MEDIUM(10L,"MEDIUM","Medium priority"),
	LOW(15L,"LOW","Low priority");

	private final Long id;
	private final String code;
	private final String libelle;

	private PriorityEnum(Long id, String code, String libelle) {
		this.id = id;
		this.libelle = libelle;
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public Long getId() {
		return id;
	}

	public String getCode() {
		return code;
	}
	
}
