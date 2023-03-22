package mk.ukim.finki.emt.lab.model.dto;

import jakarta.persistence.ManyToOne;
import lombok.Data;
import mk.ukim.finki.emt.lab.model.Author;
import mk.ukim.finki.emt.lab.model.enumerations.Category;

@Data
public class BookDto {
    private String name;
    private Category category;
    private Author author;
    private Integer availableCopies;
}
