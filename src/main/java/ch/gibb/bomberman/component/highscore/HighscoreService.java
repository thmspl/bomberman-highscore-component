/*
 * HighscoreService.java
 *
 * Project: Bomberman
 *
 * Team: Application Highscore
 *
 * Copyright (C) Team Application Highscore
 */
package ch.gibb.bomberman.component.highscore;

import ch.gibb.bomberman.component.highscore.models.User;
import ch.gibb.bomberman.component.highscore.persistence.IDataAccessObject;
import ch.gibb.bomberman.component.highscore.persistence.database.DatabaseBasedDAO;

/**
 * {@link IHighscoreService} implementation.
 *
 * @author Thomas Pauli, www.thomaspauli.ch
 * @author Remo Sieber, www.remosieber.ch
 * @author Giuliano Campaniello
 * @since 0.0.1
 */
public class HighscoreService implements IHighscoreService {

    // DAO
    private IDataAccessObject<User> accessObject;

    public HighscoreService() {
        accessObject = new DatabaseBasedDAO();
    }

    /**
     * Prüft ob ein Benutzer mit dem angegebenen Benutzernamen in der Datenbank vorhanden ist.
     *
     * @param username Der Benutzername mit welchem überprüft werden soll, ob der Benutzer existiert.
     * @return Gibt <code>true</code> zurück, wenn der Benutzer mit dem übergebenen Benutzernamen vorhanden ist.
     */
    public boolean userExists(String username) {
        return ((accessObject.getByUsername(username)) != null);
    }

    /**
     * Erstellt einen neuen Benutzer mit dem übergebenen Benutzernamen.
     *
     * @param username Der Benutzername, mit welchem ein neuer Benutzer erstellt werden soll.
     */
    public void createUser(String username) {
        accessObject.create(new User(username, 0));
    }

    /**
     * Erhöht den Highscorewert des Benutzers, mit dem übergebenen Benutzernamen, um den angegebenen Highscorewert.
     *
     * @param username Der Benutzername des Benutzers, welchem die Highscore Punkte zugeschrieben werden sollen.
     * @param score    Die Highscore Punkte welche dem Benutzer zugeschrieben werden sollen.
     */
    public void increaseHighscore(String username, int score) {
        if (this.userExists(username)) {
            User user = accessObject.getByUsername(username);
            user.setHighScore((user.getHighScore()) + score);
            accessObject.update(user);
        } else {
            System.err.println("The user " + username + " doesn't exist!");
        }
    }

    /**
     * Gibt den aktuellen Highscorewert des Benutzers mit dem angegebenen Benutzernamen zurück.
     *
     * @param username Der Benutzername des Benutzers, dessen Highscore Punkte zurück gegeben werden sollen.
     * @return Die Highscore Punkte des angegebenen Benutzers.
     */
    public int getHighscoreByUsername(String username) {
        User user = accessObject.getByUsername(username);
        return user.getHighScore();
    }

    /**
     * Entfernt den Benutzer mit dem angegebenen Benutzernamen.
     *
     * @param username Der Benutzername des Benutzers, welcher entfernt werden soll.
     */
    public void deleteUserByUsername(String username) {
        accessObject.remove(accessObject.getByUsername(username));
    }
}
