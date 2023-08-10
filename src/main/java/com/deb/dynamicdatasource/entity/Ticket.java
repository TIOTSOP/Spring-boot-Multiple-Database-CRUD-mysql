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
@Table(name = "ticket")
public class Ticket implements Serializable{

		@Id
		//@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "idtick")
		private long id;
		@Column(name = "customertick")
		private String customertick;
		@Column(name = "projettick")
		private String projettick;
		@Column(name = "donetick")
		private String donetick;
		@Column(name = "todotick")
		private String todotick; 
		@Column(name = "acteurtick")
		private String acteurtick; 
		@Column(name = "datupdtick")
		private String datupdtick; 
		@Column(name = "voltick")
		private long voltick; 
		@Column(name = "statustick")
		private long statustick; 
}
