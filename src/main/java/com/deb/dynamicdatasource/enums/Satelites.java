package com.deb.dynamicdatasource.enums;

import lombok.Getter;

@Getter
public enum Satelites {
	
	MASTER("Master"),
	SLAVE1("Slave1"),
	SLAVE2("Slave2"),
	SLAVE3("Slave3"),
	SLAVE0("Slave0"),
	POSTE1("Poste1");
	
	private String val;

	private Satelites(String val) {
		this.val = val;
	}
	
	public  static Satelites getSatelite(String val) {
		if(MASTER.val.equalsIgnoreCase(val)) {
			return MASTER;
		}
		if(SLAVE1.val.equalsIgnoreCase(val)) {
			return SLAVE1;
		}
		if(SLAVE2.val.equalsIgnoreCase(val)) {
			return SLAVE2;
		}
		if(SLAVE3.val.equalsIgnoreCase(val)) {
			return SLAVE3;
		}
		if(SLAVE0.val.equalsIgnoreCase(val)) {
			return SLAVE0;
		}
		if(POSTE1.val.equalsIgnoreCase(val)) {
			return POSTE1;
		}
		return null;
	}
}
