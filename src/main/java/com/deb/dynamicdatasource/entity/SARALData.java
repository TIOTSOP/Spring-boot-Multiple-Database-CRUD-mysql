package com.deb.dynamicdatasource.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="saral_data")
@Table(name = "saral_data")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SARALData {

	@Id
	@GeneratedValue
	private Long id;
	
	private String ftpPath;
	
}
