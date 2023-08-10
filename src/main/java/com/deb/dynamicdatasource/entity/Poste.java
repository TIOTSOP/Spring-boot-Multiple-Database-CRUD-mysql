package com.deb.dynamicdatasource.entity;

import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;
import java.math.BigInteger;
/* @Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Immutable */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "poste")
public class Poste implements Serializable{

		@Id
		//@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "numpos")
		private String id;
		@Column(name = "cpunam")
		private String cpunam;
		@Column(name = "sysutil")
		private String sysutil;
		@Column(name = "nbrsec")
		private long nbrsec;
		@Column(name = "essai")
		private String essai; 
		@Column(name = "temps")
		private String temps; 
		@Column(name = "utilmch")
		private String utilmch; 
		@Column(name = "obscpu")
		private String obscpu; 
		
}
