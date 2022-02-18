package ro.ubb.ui;

import ro.ubb.domain.Book;
import ro.ubb.service.Service;

import java.util.Scanner;

public class Console {
    private final Service service;

    private Scanner scanner = new Scanner(System.in);

    public Console(Service service) {
        this.service = service;
    }


    public void meniu() {
        System.out.println("1. Arata tot");
        System.out.println("x. Iesire program");
    }

    public void runConsole() throws Exception {
        boolean isExit = false;

        while (!isExit) {
            this.meniu();

            System.out.println("Alege o optiune");
            String optiune = scanner.next();

            switch (optiune) {
                case "1":
                    this.handleShowAll();
                    break;
                case "x":
                    scanner.close();
                    isExit = true;
                    break;
                default:
                    System.out.println("Nu exista optiunea introdusa");
                    break;
            }
        }
        System.out.println("Exit");
    }

    private void handleShowAll() {
        for (Book book : this.service.getAll()) {
            System.out.println("Print" + book);
        }
    }

}
