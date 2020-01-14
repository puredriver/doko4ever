package com.dogma.doko4ever.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "event_results")
public class EventResult {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "fk_event_id", nullable = false)
	private Event event;

	@Column
	@NotNull
	private int points = 0;

	@Column
	private BigDecimal amount;

	@Column
	private BigDecimal donation;

	@OneToOne
	@JoinColumn(name = "fk_player_id")
	private Player player;

	public EventResult() {
		donation = BigDecimal.ZERO;
	}

	public EventResult(Event event, Player player) {
		this.event = event;
		this.player = player;
		donation = BigDecimal.ZERO;
	}

	public EventResult(Event event, int points) {
		this.points = points;
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

	public BigDecimal getDonation() {
		return donation;
	}

	public void setDonation(BigDecimal donation) {
		this.donation = donation;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

}
