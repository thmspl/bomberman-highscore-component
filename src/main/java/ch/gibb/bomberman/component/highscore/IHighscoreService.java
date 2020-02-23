/*
 * IHighscoreService.java
 *
 * Project: Bomberman
 *
 * Team: Application Highscore
 *
 * Copyright (C) Team Application Highscore
 */
package ch.gibb.bomberman.component.highscore;

/**
 * Template for the main service class.
 *
 * @author Thomas Pauli, www.thomaspauli.ch
 * @author Remo Sieber, www.remosieber.ch
 * @since 0.0.1
 */
interface IHighscoreService {

	/**
	 * Prüft ob ein Benutzer mit dem angegebenen Benutzernamen in der Datenbank vorhanden ist.
	 *
	 * @param username Der Benutzername mit welchem überprüft werden soll, ob der Benutzer existiert.
	 * @return Gibt <code>true</code> zurück, wenn der Benutzer mit dem übergebenen Benutzernamen vorhanden ist.
	 */
	boolean userExists(String username);
	
	/**
	 * Erstellt einen neuen Benutzer mit dem übergebenen Benutzernamen.
	 *
	 * @param username Der Benutzername, mit welchem ein neuer Benutzer erstellt werden soll.
	 */
	void createUser(String username);
	
	/**
	 * Erhöht den Highscorewert des Benutzers, mit dem übergebenen Benutzernamen, um den angegebenen Highscorewert.
	 *
	 * @param username Der Benutzername des Benutzers, welchem die Highscore Punkte zugeschrieben werden sollen.
	 * @param score Die Highscore Punkte welche dem Benutzer zugeschrieben werden sollen.
	 */
	void increaseHighscore(String username, int score);
	
	/**
	 * Gibt den aktuellen Highscorewert des Benutzers mit dem angegebenen Benutzernamen zurück.
     *
	 * @param username Der Benutzername des Benutzers, dessen Highscore Punkte zurück gegeben werden sollen.
	 * @return Die Highscore Punkte des angegebenen Benutzers.
	 */
	int getHighscoreByUsername(String username);

    /**
     * Entfernt den Benutzer mit dem angegebenen Benutzernamen.
     *
     * @param username Der Benutzername des Benutzers, welcher entfernt werden soll.
     */
	void deleteUserByUsername(String username);
}