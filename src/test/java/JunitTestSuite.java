/*
 * JunitTestSuite.java
 *
 * Project: Bomberman
 *
 * Team: Application Highscore
 *
 * Copyright (C) Team Application Highscore
 */

import ch.gibb.bomberman.component.highscore.HighscoreServiceTest;
import ch.gibb.bomberman.component.highscore.persistence.database.DatabaseBasedDAOTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * TestSuite for all JUnit Test classes
 *
 * @author Thomas Pauli, www.thomaspauli.ch
 * @since 1.0.0
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        HighscoreServiceTest.class,
        DatabaseBasedDAOTest.class
})
public class JunitTestSuite {
}
