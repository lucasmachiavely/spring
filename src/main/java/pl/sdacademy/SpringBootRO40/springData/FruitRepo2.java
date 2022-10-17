package pl.sdacademy.SpringBootRO40.springData;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FruitRepo2 extends CrudRepository<Fruit, Long> {
    Optional<Fruit> findByWeight(Double weight); // SELECT TOP 1 * FROM fruits WHERE weight = ?
    Optional<Fruit> findByName(String fruits); // SELECT TOP 1 * FROM fruits WHERE name = ?
    Optional<Fruit> findByWeightAndName(Double weight, String name); // SELECT TOP 1 * fruits WHERE weight = ? AND name = ?
    Optional<Fruit> findByNameOrWeight(String name, Double weight); // SELECT TOP 1 * fruits WHERE name = ? OR weight = ?
}
