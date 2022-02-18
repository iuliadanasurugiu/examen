package ro.ubb.repository;

import ro.ubb.domain.Entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class InMemoryRepository<ID, T extends Entity<ID>> implements Repository<ID, T> {

    private Map<ID, T> entities;


    public InMemoryRepository() {
        entities = new HashMap<>();
    }


    @Override
    public Optional<T> findOne(ID id) throws IllegalAccessException {
        return Optional.empty();
    }

    /**
     *
     * @return all entities.
     */
    @Override
    public Iterable<T> findAll() {
        Set<T> allEntities = entities.entrySet().stream().map(entry -> entry.getValue()).collect(Collectors.toSet());
        return allEntities;
    }

    /**
     * Saves the given entity.
     *
     * @param entity
     *            must not be null.
     * @return an {@code Optional} - null if the entity was saved otherwise (e.g. id already exists) returns the entity.
     * @throws IllegalArgumentException
     *             if the given entity is null.
     */
    @Override
    public void save(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException("id must not be null");
        }
        entities.putIfAbsent(entity.getId(), entity);
    }

    /**
     * Removes the entity with the given id.
     *
     * @param id
     *            must not be null.
     * @return an {@code Optional} - null if there is no entity with the given id, otherwise the removed entity.
     * @throws IllegalArgumentException
     *             if the given id is null.
     */
    @Override
    public void delete(ID id){
        if (id == null) {
            throw new IllegalArgumentException("id must not be null");
        }
        entities.remove(id);
    }

    /**
     * Updates the given entity.
     *
     * @param entity
     *            must not be null.
     * @return an {@code Optional} - null if the entity was updated otherwise (e.g. id does not exist) returns the
     *         entity.
     * @throws IllegalArgumentException
     *             if the given entity is null.
     */
    @Override
    public void update(T entity)  {
        if (entity == null) {
            throw new IllegalArgumentException("entity must not be null");
        }
        entities.computeIfPresent(entity.getId(), (k, v) -> entity);
    }
}

