package pl.sdacademy.SpringBootRO40.ex6;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PersonController {

        @GetMapping("/person")
        public Person getPerson(@Valid @RequestBody Person person ){
            return person;
        }
    }
