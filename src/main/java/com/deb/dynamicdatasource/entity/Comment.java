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
@Table(name = "comment")
public class Comment implements Serializable{

		@Id
		//@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "idcomment")
		private long id;	
		@Column(name = "comment")
		private String obs;
		@Column(name = "datecom")
		private String datecom;
		@Column(name = "idtask")
		private long idtask;

}
