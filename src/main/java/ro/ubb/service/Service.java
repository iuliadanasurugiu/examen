package ro.ubb.service;

import ro.ubb.domain.Book;
import ro.ubb.repository.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Service {
    private final Repository<Integer, Book> repository;

    public Service(Repository<Integer, Book> repository) {
        this.repository = repository;
    }

    public Iterable<Book> getAll() {
        return this.repository.findAll();
    }

    public List<Book> getAll2() {
        Iterable<Book> books = this.repository.findAll();
        return StreamSupport.stream(books.spliterator(), false).collect(Collectors.toList());
    }


}
