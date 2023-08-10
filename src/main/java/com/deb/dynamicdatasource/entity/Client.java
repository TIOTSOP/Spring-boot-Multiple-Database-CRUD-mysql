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
@Table(name = "client")
public class Client implements Serializable{

		@Id
		//@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "idclient")
		private long id;	
		@Column(name = "clientname")
		private String clientname;
		@Column(name = "clienttel")
		private String clienttel;
		@Column(name = "clientresp")
		private String clientresp;
		@Column(name = "clientloc")
		private String clientloc;
		@Column(name = "clientnbposte")
		private long clientnbposte; 
		@Column(name = "clientobs")
		private String clientobs; 
		@Column(name = "statusclient")
		private long statusclient; 
}
