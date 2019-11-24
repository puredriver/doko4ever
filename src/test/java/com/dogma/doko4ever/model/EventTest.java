package com.dogma.doko4ever.model;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class EventTest {

	@Test
	public void testInitEventResults() {
		Player one = new Player();
		one.setFirstName("andre");

		Player two = new Player();
		two.setFirstName("isabell");

		Player three = new Player();
		three.setFirstName("henri");

		Event e = new Event();
		e.initEventResults(Arrays.asList(one, two, three));

		assertEquals("andre", e.getEventResults().get(0).getPlayer().getFirstName());
		assertEquals("isabell", e.getEventResults().get(1).getPlayer().getFirstName());
		assertEquals("henri", e.getEventResults().get(2).getPlayer().getFirstName());
	}

	@Test
	public void testGetEventResultsSort() {
		Event e = new Event();
		List<EventResult> results = new ArrayList<EventResult>();

		// max positive
		int[] points = { -40, 9, -12, -3, 50 };
		for (int i = 0; i < points.length; i++) {
			results.add(new EventResult(e, points[i]));
		}
		e.setEventResults(results);

		List<EventResult> sorted = e.getEventResultsSort();

		assertEquals(50, sorted.get(0).getPoints());
		assertEquals(9, sorted.get(1).getPoints());
		assertEquals(-3, sorted.get(2).getPoints());
		assertEquals(-12, sorted.get(3).getPoints());
		assertEquals(-40, sorted.get(4).getPoints());

	}

	@Test
	public void testCalcAmount() {

		Event e = new Event();
		List<EventResult> results = new ArrayList<EventResult>();

		// max positive
		int[] points = { -51, -40, 9, -12, -3, 50 };
		for (int i = 0; i < points.length; i++) {
			results.add(new EventResult(e, points[i]));
		}
		e.setEventResults(results);
		e.calcAmount(10, 10); // 10cent - max10 EUR

		List<EventResult> rs = e.getEventResultsSort();
		assertEquals(BigDecimal.valueOf(0.00).setScale(2), rs.get(0).getAmount());
		assertEquals(BigDecimal.valueOf(4.10).setScale(2), rs.get(1).getAmount());
		assertEquals(BigDecimal.valueOf(5.30).setScale(2), rs.get(2).getAmount());
		assertEquals(BigDecimal.valueOf(6.20).setScale(2), rs.get(3).getAmount());
		assertEquals(BigDecimal.valueOf(9.00).setScale(2), rs.get(4).getAmount());
		assertEquals(BigDecimal.valueOf(10.00).setScale(2), rs.get(5).getAmount());

	}

}
