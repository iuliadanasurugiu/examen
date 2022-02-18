package ro.ubb;

import ro.ubb.domain.Book;
import ro.ubb.repository.InMemoryRepository;
import ro.ubb.repository.Repository;
import ro.ubb.service.Service;
import ro.ubb.ui.Console;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello");

        Repository<Integer, Book> bookRepository = new InMemoryRepository<>();
        Service service = new Service(bookRepository);

        Console console = new Console(service);

        try {
            console.runConsole();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
