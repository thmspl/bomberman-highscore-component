/*
 * DatabaseBasedDAOImplTest.java
 *
 * Project: Bomberman
 *
 * Team: Application Highscore
 *
 * Copyright (C) Team Application Highscore
 */
package ch.gibb.bomberman.component.highscore.persistence.database;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ch.gibb.bomberman.component.highscore.models.User;
import ch.gibb.bomberman.component.highscore.persistence.IDataAccessObject;

/**
 * TestClass for the {@link DatabaseBasedDAO} class.
 *
 * @author Thomas Pauli, www.thomaspauli.ch
 * @since 1.0.0
 */
public class DatabaseBasedDAOTest {

    private IDataAccessObject<User> accessObject;

    private static final int TEST_USER1_ID = 1;
    private static final String TEST_USER1_USERNAME = "thmspl";
    private static final int TEST_USER1_HIGHSCORE = 100;

    private static final int TEST_USER2_ID = 2;
    private static final String TEST_USER2_USERNAME = "taylor";
    private static final int TEST_USER2_HIGHSCORE = 200;

    private static final User TEST_USER1 = new User(TEST_USER1_ID, TEST_USER1_USERNAME, TEST_USER1_HIGHSCORE);
    private static final User TEST_USER2 = new User(TEST_USER2_ID, TEST_USER2_USERNAME, TEST_USER2_HIGHSCORE);

    @Before
    public void setUp() {
        accessObject = new DatabaseBasedDAO();
    }

    @After
    public void tearDown(){
        // Remove the test Users for the next JUnit Test
        if(accessObject.getByUsername(TEST_USER1_USERNAME) != null){
            accessObject.remove(TEST_USER1);
        }

        if(accessObject.getByUsername(TEST_USER2_USERNAME) != null){
            accessObject.remove(TEST_USER2);
        }
    }

    @Test
    public void testGetById() throws Exception {
        // Create the test User
        accessObject.create(TEST_USER1);

        // Get the test User from the Database
        final User user = accessObject.getById(TEST_USER1.getId());

        // Assertion's
        assertNotNull(TEST_USER1);
        assertEquals(TEST_USER1_USERNAME, user.getUsername());
        assertEquals(TEST_USER1_HIGHSCORE, user.getHighScore());
    }

    @Test
    public void testGetByUsername() throws Exception {
        // Create the test User
        accessObject.create(TEST_USER1);

        // Get the test User from the Database
        final User user = accessObject.getByUsername(TEST_USER1.getUsername());

        // Assertion's
        assertNotNull(TEST_USER1);
        assertEquals(TEST_USER1_HIGHSCORE, user.getHighScore());
    }

    @Test
    public void testGetByUsername_Null() throws Exception {
        // Create the test User
        accessObject.create(TEST_USER1);

        // Get the test User from the Database
        final User user = accessObject.getByUsername(null);

        assertTrue(user == null);
    }

    @Test
    public void testGetAll() throws Exception {
        // Create the test User
        accessObject.create(TEST_USER1);
        accessObject.create(TEST_USER2);

        // Get all test Users from the Database
        final List<User> users = accessObject.getAll();

        // Assertion's
        assertNotNull(users);
        assertEquals(2, users.size());

        // -> User 1
        User user1 = users.get(0);
        assertEquals(TEST_USER1_USERNAME, user1.getUsername());
        assertEquals(TEST_USER1_HIGHSCORE, user1.getHighScore());

        // -> User 2
        User user2 = users.get(1);
        assertEquals(TEST_USER2_USERNAME, user2.getUsername());
        assertEquals(TEST_USER2_HIGHSCORE, user2.getHighScore());
    }


    @Test
    public void testUpdate() throws Exception {
        // Create the test User
        accessObject.create(TEST_USER1);

        // Get the test User from the Database
        final User userBeforeUpdate = accessObject.getByUsername(TEST_USER1.getUsername());
        assertEquals(TEST_USER1_HIGHSCORE, userBeforeUpdate.getHighScore());

        // Update the test User
        userBeforeUpdate.setHighScore(500);
        accessObject.update(userBeforeUpdate);

        // Get the test User from the Database
        final User userAfterUpdate = accessObject.getByUsername(TEST_USER1.getUsername());

        // Assertion's
        assertNotNull(userAfterUpdate);
        assertEquals(500, userAfterUpdate.getHighScore());
    }
}