package com.dogma.doko4ever.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "cashboxes")
public class Cashbox {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;

	@Column
	@NotNull
	private BigDecimal amount;

	@Column
	@NotNull
	private LocalDate inventoryDate;

	@Column
	@NotNull
	private String comment;

	public Cashbox() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDate getInventoryDate() {
		return inventoryDate;
	}

	public void setInventoryDate(LocalDate inventoryDate) {
		this.inventoryDate = inventoryDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
