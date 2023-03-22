package mk.ukim.finki.emt.lab.model.dto;

import jakarta.persistence.ManyToOne;
import lombok.Data;
import mk.ukim.finki.emt.lab.model.Country;

@Data
public class AuthorDto {
    private String name;
    private String surname;
    private Country country;

}
