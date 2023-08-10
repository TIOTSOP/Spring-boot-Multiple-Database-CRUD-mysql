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
@Table(name = "task")
public class Task implements Serializable{

		@Id
		//@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "idtask")
		private long id;
		@Column(name = "idtick")
		private long idtick;
	
		
		@Column(name = "datetask")
		private String datetask;
		@Column(name = "acteurtask")
		private String acteurtask;
		@Column(name = "donetask")
		private String donetask;
		@Column(name = "obstask")
		private String obstask; 

		@Column(name = "statustask")
		private long statustask; 
		@Column(name = "starttask")
		private String starttask; 
		@Column(name = "endtask")
		private String endtask; 
}
