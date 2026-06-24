package org.example.libraryapp;
import org.example.libraryapp.entity.Book;
import org.example.libraryapp.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final BookRepository repository;

    public DataLoader(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {

        repository.save(new Book("Java Basics", "Kunal"));

        repository.save(new Book("Spring Boot", "Bro Code"));

        repository.save(new Book("Clean Code", "Robert Martin"));

        System.out.println("Books inserted into H2 Database");
    }
}