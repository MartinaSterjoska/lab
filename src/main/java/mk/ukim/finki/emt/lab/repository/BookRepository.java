package mk.ukim.finki.emt.lab.repository;

import mk.ukim.finki.emt.lab.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByName(String name);

    void deleteById(Long id);
    void deleteByName(String name);
}
