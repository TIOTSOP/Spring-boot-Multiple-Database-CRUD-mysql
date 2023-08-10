package com.deb.dynamicdatasource.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="aryabhat_data")
@Table(name = "aryabhat_data")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AryabhataData {

	@Id
	@GeneratedValue
	private Long id;
	
	private String ftpPath;
	
}
