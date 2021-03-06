package com.dogma.doko4ever.repository;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dogma.doko4ever.model.Player;

@RunWith(SpringRunner.class)
@SpringBootTest
class PlayerRepositoryTest {

	@Autowired
	private PlayerRepository rep;

	@Test
	void testSave() {
		Player p = new Player();
		p.setFirstname("dummy");
		p.setLastname("dummy");
		// p.setPassword("dummy");
		p.setEmail("dummy@vodafone.com");

		rep.save(p);

	}

	@Test
	void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	void testFindAll() {
		fail("Not yet implemented");
	}

}
