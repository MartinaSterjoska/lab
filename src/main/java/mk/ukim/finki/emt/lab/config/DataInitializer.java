package mk.ukim.finki.emt.lab.config;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import mk.ukim.finki.emt.lab.model.Author;
import mk.ukim.finki.emt.lab.model.Book;
import mk.ukim.finki.emt.lab.model.Country;
import mk.ukim.finki.emt.lab.model.enumerations.Category;
import mk.ukim.finki.emt.lab.repository.AuthorRepository;
import mk.ukim.finki.emt.lab.repository.BookRepository;
import mk.ukim.finki.emt.lab.repository.CountryRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataInitializer {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public static List<Country> countries = new ArrayList<>();
    public static List<Author> authors = new ArrayList<>();
    public static List<Book> books = new ArrayList<>();

    public DataInitializer(BookRepository bookRepository,
                           AuthorRepository authorRepository,
                           CountryRepository countryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }


    @PostConstruct
    public void init(){
        Country country1 = new Country("Macedonia", "Europe");
        Country country2 = new Country("Czech Republic", "Europe");
        Country country3 = new Country("Germany", "Europe");
        Country country4 = new Country("Serbia", "Europe");
        Country country5 = new Country("United Kingdom", "Europe");

        this.countryRepository.save(country1);
        this.countryRepository.save(country2);
        this.countryRepository.save(country3);
        this.countryRepository.save(country4);
        this.countryRepository.save(country5);

        Author author1 = new Author("Slavko", "Janevski", country1);
        Author author2 = new Author("Risto", "Krle", country1);
        Author author3 = new Author("Franz", "Kafka", country2);
        Author author4 = new Author("Leo", "Tolstoy", country3);
        Author author5 = new Author("William", "Shakespeare", country5);

        this.authorRepository.save(author1);
        this.authorRepository.save(author2);
        this.authorRepository.save(author3);
        this.authorRepository.save(author4);
        this.authorRepository.save(author5);

        Book book1 = new Book("Process", Category.NOVEL, author3, 250);
        Book book2 = new Book("Anna Karenina", Category.NOVEL, author4, 120);
        Book book3 = new Book("Ulica", Category.NOVEL, author1, 50);
        Book book4 = new Book("Parite se otepuvachka", Category.DRAMA, author2, 98);
        Book book5 = new Book("The Castle", Category.NOVEL, author3, 30);
        Book book6 = new Book("Romeo and Juliet", Category.DRAMA, author5, 40);

        this.bookRepository.save(book1);
        this.bookRepository.save(book2);
        this.bookRepository.save(book3);
        this.bookRepository.save(book4);
        this.bookRepository.save(book5);
        this.bookRepository.save(book6);
    }
}
