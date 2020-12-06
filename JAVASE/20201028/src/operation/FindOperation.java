package operation;

import book.Book;
import book.BookList;

//查找图书
public class FindOperation implements IOoperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入要查找的书名:");
        String name = s.next();
        int newSize = bookList.getUsedSize();
        for (int i = 0; i < newSize; i++) {
            if (name.equals(bookList.getBook(i).getName())) {
                Book book = bookList.getBook(i);
                System.out.println(book);
            }
        }
    }
}
