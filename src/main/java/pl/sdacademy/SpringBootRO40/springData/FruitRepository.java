package pl.sdacademy.SpringBootRO40.springData;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class FruitRepository {

    private final EntityManager entityManager;

    public FruitRepository(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<Fruit> getById(final Long id) {
        return Optional.ofNullable(entityManager.find(Fruit.class, id));
    }

    public List<Fruit> findAll() {
        return entityManager.createQuery("SELECT f FROM fruits f", Fruit.class).getResultList();
    }

    public void delete(final Fruit fruit) {
        entityManager.remove(fruit);
    }

    public void deleteById(final Long id) {
        entityManager.createQuery("DELETE FROM fruits f WHERE f.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    public Fruit createFruit(final Fruit fruit) {
        entityManager.persist(fruit);
        return fruit;
    }
}