package pl.sdacademy.SpringBootRO40.springData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
@Transactional
public class DbInitializer implements CommandLineRunner {

    private final FruitRepository fruitRepository;
    private final FruitRepo2 fruitRepo2;

    public DbInitializer(final FruitRepository fruitRepository, final FruitRepo2 fruitRepo2) {
        this.fruitRepository = fruitRepository;
        this.fruitRepo2 = fruitRepo2;
    }

    @Override
    public void run(final String... args) throws Exception {
        Fruit apple = fruitRepo2.save(new Fruit("apple", 23.1));
        Fruit banana = fruitRepo2.save(new Fruit("banana", 20.1));


        fruitRepo2.findAll().forEach(System.out::println); // Fruit(id=1, name=apple, weight=23.1) Fruit(id=2, name=banana, weight=20.1)
        System.out.println(fruitRepo2.count()); // 2
     //   fruitRepo2.deleteAll(List.of(apple, banana));
        System.out.println(fruitRepo2.count()); // 0
    }


   /* @Override
    public void run(final String... args) throws Exception {
        final Fruit fruitA = new Fruit("Apple", 20.0);
        final Fruit fruitB = new Fruit("Banana", 18.0);
        fruitRepository.createFruit(fruitA);
        // (x)
        fruitRepository.createFruit(fruitB);
    }*/


}