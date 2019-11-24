package com.dogma.doko4ever.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Event {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;

	@Column
	@NotNull
	private String location;

	@Column(name = "event_date")
	@NotNull
	private LocalDateTime eventDate;

	@OneToMany(mappedBy = "event", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<EventResult> eventResults = new ArrayList<EventResult>();

	public void initEventResults(Iterable<Player> players) {
		for (Player player : players) {
			eventResults.add(new EventResult(this, player));
		}
	}

	public List<EventResult> getEventResultsSort() {
		// Collections.sort(eventResults, new EventResultComp());
		Comparator<EventResult> eventResultsPointsComparator = Comparator.comparingInt(EventResult::getPoints)
				.reversed();
		Collections.sort(eventResults, eventResultsPointsComparator);
		return eventResults;
	}

	public void calcAmount(int centPerPoint, long maxAmount) {
		Comparator<EventResult> eventResultsPointsComparator = Comparator.comparingInt(EventResult::getPoints);
		EventResult r = Collections.max(this.eventResults, eventResultsPointsComparator);

		for (EventResult eventResult : eventResults) {
			BigDecimal diff = new BigDecimal(r.getPoints() - eventResult.getPoints());

			BigDecimal amount = diff.multiply(new BigDecimal(centPerPoint));
			// amount.setScale(2);
			amount.abs();
			amount = amount.divide(new BigDecimal(100), 2, RoundingMode.CEILING); //scale = 2 

			if (amount.compareTo(BigDecimal.valueOf(maxAmount)) >= 0) {
				eventResult.setAmount(BigDecimal.valueOf(maxAmount).setScale(2));
			} else {
				eventResult.setAmount(amount);
			}
			//			if (r.getPoints() > 0 && eventResult.getPoints() >= 0) {
			//				
			//			} else if (r.getPoints() > 0 && eventResult.getPoints() < 0) {
			//				
			//			}
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDateTime getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDateTime eventDate) {
		this.eventDate = eventDate;
	}

	public void setEventResults(List<EventResult> eventResults) {
		this.eventResults = eventResults;
	}

	public List<EventResult> getEventResults() {
		return eventResults;
	}

}

class EventResultComp implements Comparator<EventResult> {

	@Override
	public int compare(EventResult arg0, EventResult arg1) {
		if (arg0.getPoints() < arg1.getPoints())
			return 1;
		else
			return -1;
	}

}
