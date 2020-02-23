/*
 * HibernateUtil.java
 *
 * Project: Bomberman
 *
 * Team: Application Highscore
 *
 * Copyright (C) Team Application Highscore
 */

package ch.gibb.bomberman.component.highscore.persistence.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * {@link HibernateUtil} dient als Unterstützung für den Umgang mit Hibernate.
 *
 * @author Thomas Pauli, www.thomaspauli.ch
 * @since 0.0.1
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }

    public static void closeSession(Session session) {
        session.close();
    }
}

