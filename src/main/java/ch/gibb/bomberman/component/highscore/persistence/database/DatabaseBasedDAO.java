/*
 * HibernateBasedDatabaseAccessObject.java
 *
 * Project: Bomberman
 *
 * Team: Application Highscore
 *
 * Copyright (C) Team Application Highscore
 */
package ch.gibb.bomberman.component.highscore.persistence.database;

import ch.gibb.bomberman.component.highscore.models.User;
import ch.gibb.bomberman.component.highscore.persistence.IDataAccessObject;
import ch.gibb.bomberman.component.highscore.persistence.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * Die {@link DatabaseBasedDAO} Klasse dient dazu, Objekte vom Typ {@link User} in die Datenbank zu speichern, zu bearbeiten und aus der Datebank zu entfernen.
 *
 * @author Thomas Pauli, www.thomaspauli.ch
 * @author Giuliano Campaniello
 * @since 0.0.1
 */
public class DatabaseBasedDAO implements IDataAccessObject<User> {

    /**
     * Speichert eine Entität in die Datenbank.
     *
     * @param entity Die zu speichernde Entität.
     * @return Die gespeicherte Entität.
     */
    public User create(User entity) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        HibernateUtil.closeSession(session);
        return entity;
    }

    /**
     * Aktualisiert die übergebene Entität in der Datenbank.
     *
     * @param entity Die zu aktualisierende Entität.
     * @return Die aktualisierte Entität.
     */
    public User update(User entity) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        HibernateUtil.closeSession(session);
        return entity;
    }

    /**
     * Entfernt die übergebene Entität aus der Datenbank.
     *
     * @param entity Die zu entfernende Entität.
     */
    public void remove(User entity) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove(entity);
        session.getTransaction().commit();
        HibernateUtil.closeSession(session);
    }

    /**
     * Holt vom übergebenen {@link Query} das daraus resultierende {@link User} Objekt.
     *
     * @param query Das {@link Query}, von welchem der {@link User} zurückgegeben werden soll.
     * @return Gibt das vom {@link Query} resultierende {@link User} Objekt zurück. Gibt null zurück, falls kein {@link User} Objekt gefunden werden konnte.
     */
    private User getSingleResult(Query<User> query) {
        User user = null;
        try {
            user = query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
        return user;
    }

    /**
     * Gibt das entsprechende {@link User} Objekt zurück, welches die übergebene ID hat.
     *
     * @param id Die ID, von welcher der entsprechende {@link User} zurückgegeben werden soll.
     * @return Das {@link User) Objekt, welche die übergebene ID hat. Gibt <code>null</code> zurück, falls kein {@link User} gefunden wurde.
     */
    public User getById(int id) {
        Session currentSession = HibernateUtil.getSession();
        currentSession.beginTransaction();

        Query<User> query = currentSession.getNamedQuery(User.FIND_BY_ID);
        query.setParameter("id", id);
        User user = this.getSingleResult(query);

        currentSession.getTransaction().commit();
        HibernateUtil.closeSession(currentSession);
        return user;
    }

    /**
     * Gibt das entsprechende {@link User} Objekt zurück, welches den übergebenen Benutzernamen hat.
     *
     * @param username Der Benutzername, von welcher der entsprechende {@link User} zurückgegeben werden soll.
     * @return Das {@link User) Objekt, welche den übergebenen Benutzernamen hat. Gibt <code>null</code> zurück, falls kein {@link User} gefunden wurde.
     */
    public User getByUsername(String username) {
        Session currentSession = HibernateUtil.getSession();
        currentSession.beginTransaction();

        Query<User> query = currentSession.getNamedQuery(User.FIND_BY_USERNAME);
        query.setParameter("username", username);
        User user = this.getSingleResult(query);

        currentSession.getTransaction().commit();
        HibernateUtil.closeSession(currentSession);
        return user;
    }

    /**
     * Gibt alle user aus der Datenbank als {@link List <User>} zurück.
     *
     * @return Gibt alle User aus der Datenbank.
     */
    public List<User> getAll() {
        Session currentSession = HibernateUtil.getSession();
        currentSession.beginTransaction();

        Query<User> query = currentSession.getNamedQuery(User.GELL_ALL);
        List<User> users = query.getResultList();

        currentSession.getTransaction().commit();
        HibernateUtil.closeSession(currentSession);
        return users;
    }
}

