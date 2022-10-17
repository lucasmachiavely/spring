package pl.sdacademy.SpringBootRO40.springData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class FruitController {

    @Autowired
    private FruitRepository fruitRepository;

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
}
