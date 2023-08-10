package com.deb.dynamicdatasource.config;

import com.deb.dynamicdatasource.enums.DatabaseContext;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DataBaseContextHolder {

	private static final ThreadLocal<DatabaseContext> dbContextHolder = new ThreadLocal<>();

	public void setCurrentDb(DatabaseContext dbType) {
		dbContextHolder.set(dbType);
	}

	public DatabaseContext getCurrentDb() {
		return dbContextHolder.get();
	}

	public void clear() {
		dbContextHolder.remove();
	}
}
