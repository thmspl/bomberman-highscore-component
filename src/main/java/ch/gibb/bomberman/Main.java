/*
 * HighscoreService.java
 *
 * Project: Bomberman
 *
 * Team: Application Highscore
 *
 * Copyright (C) Team Application Highscore
 */
package ch.gibb.bomberman;

import ch.gibb.bomberman.component.highscore.HighscoreService;

import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Test Klasse für die Demonstration der Komponente.
 *
 * @author Thomas Pauli, www.thomaspauli.ch
 * @since 1.0.1
 */
public class Main {

    private HighscoreService highscoreService;

    public static void main(String[] args) {
        new Main();
    }

    private Main() {
        Logger log = Logger.getLogger("org.hibernate");
        log.setLevel(Level.OFF);

        highscoreService = new HighscoreService();

        highscoreService.createUser("thomas.pauli");
        System.out.println(highscoreService.userExists("thomas.pauli"));
        highscoreService.increaseHighscore("thomas.pauli", 100);
        int highscore = highscoreService.getHighscoreByUsername("thomas.pauli");
        System.out.println("Highscore: " + highscore);
        highscoreService.deleteUserByUsername("thomas.pauli");
        System.out.println(highscoreService.userExists("thomas.pauli"));
    }
}
