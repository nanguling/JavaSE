package user;

import book.Book;
import book.BookList;
import operation.IOoperation;

import java.util.Scanner;

public abstract class User {
    Scanner scanner = new Scanner(System.in);
    protected String name;

    protected IOoperation[] iOoperations;

    abstract public int menu();

    public User(String name) {
        this.name = name;
    }
    public IOoperation doOperation(int choice) {
        return iOoperations[choice];
    }
}
