/*
 * IDatabaseAccessObject.java
 *
 * Project: Bomberman
 *
 * Team: Application Highscore
 *
 * Copyright (C) Team Application Highscore
 */
package ch.gibb.bomberman.component.highscore.persistence;

import java.util.List;

/**
 * {@link IDataAccessObject} stellt sicher, dass alle DAO's die erforderlichen Methoden enthalten.
 *
 * @author Thomas Pauli, www.thomaspauli.ch
 * @since 0.0.1
 */
public interface IDataAccessObject<E> {

    E create(E entity);

    E update(E entity);

    void remove(E entity);

    E getById(int id);

    E getByUsername(String username);

    List<E> getAll();
}

