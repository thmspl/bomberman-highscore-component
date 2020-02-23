/*
 * HighscoreServiceTest.java
 *
 * Project: Bomberman
 *
 * Team: Application Highscore
 *
 * Copyright (C) Team Application Highscore
 */
package ch.gibb.bomberman.component.highscore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * TestClass for the {@link HighscoreService} class.
 *
 * @author Thomas Pauli, www.thomaspauli.ch
 * @author Remo Sieber, www.remosieber.ch
 * @since 0.0.2
 */
public class HighscoreServiceTest {

	private static HighscoreService highscoreService;

	private static final String TEST_USER1_USERNAME = "thmspl";
	private static final int TEST_USER1_HIGHSCORE = 55;
	
	private static final String TEST_USER2_USERNAME = "taylor";
	private static final int TEST_USER2_HIGHSCORE = 23;
	
	private static final int TEST_HIGHSCORE_UPDATED = 11;

	@Before
	public void setUp(){
		highscoreService = new HighscoreService();
	}

    @After
    public void tearDown() {
        // Remove the test User for the next JUnit Test
		if(highscoreService.userExists(TEST_USER1_USERNAME)){
			highscoreService.deleteUserByUsername(TEST_USER1_USERNAME);
		}

		if(highscoreService.userExists(TEST_USER2_USERNAME)){
			highscoreService.deleteUserByUsername(TEST_USER2_USERNAME);
		}
    }

	@Test
	public void testCreateUser() {
        // Create the test User
        highscoreService.createUser(TEST_USER1_USERNAME);
        highscoreService.increaseHighscore(TEST_USER1_USERNAME, TEST_USER1_HIGHSCORE);

        // Assertion's
        assertTrue(highscoreService.userExists(TEST_USER1_USERNAME));
	}

	@Test
	public void testUpdateHighscore() {
        // Create the test User
        highscoreService.createUser(TEST_USER1_USERNAME);
        highscoreService.increaseHighscore(TEST_USER1_USERNAME, TEST_USER1_HIGHSCORE);

        // Assertion's
		assertEquals(TEST_USER1_HIGHSCORE, highscoreService.getHighscoreByUsername(TEST_USER1_USERNAME));
		highscoreService.increaseHighscore(TEST_USER1_USERNAME, TEST_HIGHSCORE_UPDATED);
		assertEquals(TEST_HIGHSCORE_UPDATED + TEST_USER1_HIGHSCORE, highscoreService.getHighscoreByUsername(TEST_USER1_USERNAME));
	}

	@Test
	public void testGetHighscoreByUsername() {
        // Create the test User
        highscoreService.createUser(TEST_USER1_USERNAME);
        highscoreService.increaseHighscore(TEST_USER1_USERNAME, TEST_USER1_HIGHSCORE);
		int highscore = highscoreService.getHighscoreByUsername(TEST_USER1_USERNAME);

        // Assertion's
		assertEquals(TEST_USER1_HIGHSCORE, highscore);
	}
}
