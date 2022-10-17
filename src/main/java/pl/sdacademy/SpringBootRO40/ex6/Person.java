package pl.sdacademy.SpringBootRO40.ex6;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
@Component
@Data
@Validated
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "pl.sdacademy.zad6")
public class Person {
    @Email(message = "email cannot be valid")
    @NotNull(message = "email is mandatory")
    private String email;
    private String firstName;
    @NotNull(message = "last name is mandatory")
    @Length(min=3, max=20)
    private String lastName;
    @NotNull(message = "address is mandatory")
    private String address;

    @NotNull(message = "age is mandatory")
    @Min(value = 18)
    private int age;
    @NotEmpty(message = "list must be not empty")
    private List<String> personList;
    @NotEmpty(message = "map must be not empty")
    private Map <String, String> personMap;
    @AssertTrue(message = "addres is not valid")
    public boolean isAddressVallid() {
        return  address != null && address.split(" ").length == 2;
    }


}
