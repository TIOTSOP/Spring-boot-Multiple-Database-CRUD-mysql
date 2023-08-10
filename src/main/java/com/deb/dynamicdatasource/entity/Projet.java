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
@Table(name = "projet")
public class Projet implements Serializable{

		@Id
		//@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "idprojet")
		private long id;	
		@Column(name = "projetname")
		private String projetname;
		@Column(name = "projettel")
		private String projettel;
		@Column(name = "projetresp")
		private String projetresp;
		@Column(name = "projetloc")
		private String projetloc;
		@Column(name = "projetnbposte")
		private long projetnbposte; 
		@Column(name = "projetobs")
		private String projetobs; 
		@Column(name = "statusprojet")
		private long statusprojet; 
}
