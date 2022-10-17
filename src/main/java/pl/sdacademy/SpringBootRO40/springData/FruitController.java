package pl.sdacademy.SpringBootRO40.springData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;
import java.util.Optional;


@Controller
public class FruitController {

    @Autowired
    private FruitRepository fruitRepository;

    @Autowired
   private FruitRepo2 fruitRepo2;
    @PostMapping("/createFruit")
    public String createFruit(@ModelAttribute("fruitForm") Fruit fruit) {
        fruitRepository.createFruit(fruit);
        System.out.println("Added Fruit");
        return "fruits";
    }

    @GetMapping("/createFruit")
    public  String showFruitForm(final ModelMap fruits){
        fruits.addAttribute("fruitForm", new Fruit());
        return "fruits";
    }
    @ResponseBody
    @GetMapping("/findByName/{fruitName}")
    public Optional <Fruit> findByName(@PathVariable String fruitName) {
        return fruitRepo2.findByName(fruitName);

    }
}
