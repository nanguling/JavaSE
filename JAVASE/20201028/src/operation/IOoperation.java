package operation;

import book.BookList;

import java.util.Scanner;

public interface IOoperation {
    Scanner s = new Scanner(System.in);
    void work(BookList bookList);
}
