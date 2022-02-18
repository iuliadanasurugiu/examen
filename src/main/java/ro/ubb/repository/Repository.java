package ro.ubb.repository;

import ro.ubb.domain.Entity;

import java.util.Optional;

public interface Repository<ID, T extends Entity<ID>> {
    /**
     * Find the entity with the given {@code id}.
     *
     * @param id must be not null.
     * @return an {@code Optional} encapsulating the entity with the given id.
     * @throws IllegalArgumentException if the given id is null.
     */
    Optional<T> findOne(ID id) throws IllegalAccessException;

    /**
     * @return all entities.
     */
    Iterable<T> findAll();

    /**
     * Saves the given entity.
     *
     * @param entity must not be null.
     * @return an {@code Optional} - returns the created entity.
     * @throws IllegalArgumentException if the given entity is null or if the id already exists.
     */
    void save(T entity);

    /**
     * Removes the entity with the given id.
     *
     * @param id must not be null.
     * @return an {@code Optional} - deleted entity.
     * @throws IllegalArgumentException if the given id is null or if it doesn't exist.
     */
    void delete(ID id);

    /**
     * Updates the given entity.
     *
     * @param entity must not be null.
     * @return an {@code Optional} - returns the updated entity.
     * @throws IllegalArgumentException if the given entity is null or if it doesn't exist.
     */
    void update(T entity);
}


