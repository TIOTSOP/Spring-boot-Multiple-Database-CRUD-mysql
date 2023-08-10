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
@Table(name = "tickettask")
public class Tickettask implements Serializable{

		@Id
		//@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "idtickettask")
		private long id;
		
		@Column(name = "idtick")
		private long idtick;
		
		@Column(name = "idtask")
		private long idtask;
		
		@OneToOne
		@JoinColumn(name = "idtick", referencedColumnName = "idtick",insertable=false, updatable=false)
		private Ticket ticket;
		public Ticket getTicket() {
			return ticket;
		}
		public void setTicket(Ticket societe) {
			this.ticket = ticket;
		}
		
		@OneToOne
		@JoinColumn(name = "idtask", referencedColumnName = "idtask",insertable=false, updatable=false)
		private Task task;
		public Task getTask() {
			return task;
		}
		public void setTask(Task task) {
			this.task = task;
		}
		
		@Column(name = "customertick")
		private String customertick;
		
		@Column(name = "projettick")
		private String projettick;
		
		
}
