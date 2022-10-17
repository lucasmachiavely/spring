package pl.sdacademy.SpringBootRO40.ex6;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sdacademy.SpringBootRO40.springData.Fruit;

import javax.validation.Valid;

@Controller
public class PersonController {
    @PostMapping("/createPerson")
    public String createPerson (@Valid @ModelAttribute("personForm") Person person) {

        return "person";
    }

    @GetMapping("/createPerson")
    public String showOrderForm(final ModelMap modelMap ) {
        modelMap.addAttribute("orderForm", new Person());
        return "person";
    }

}

