package com.klh.sscms.interfaces;

/**
 * Generic interface for searching objects in the system.
 * @param <T> The type of object being searched.
 */
public interface Searchable<T> {

    /**
     * Finds an object by ID.
     * @param id Unique identifier
     * @return Object of type T or null
     */
    T findById(String id);

    /**
     * Finds objects by matching name.
     * @param name Full or partial name
     * @return Array of matching objects
     */
    T[] findByName(String name);
}
