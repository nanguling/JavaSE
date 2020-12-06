package operation;

import book.Book;
import book.BookList;

//显示所有图书
public class DisplayOperation implements IOoperation {
    @Override
    public void work(BookList bookList) {
        int newSize = bookList.getUsedSize();
        for (int i = 0; i < newSize; i++) {
            Book book = bookList.getBook(i);
            System.out.println(book);
        }
    }
}
