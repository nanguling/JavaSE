package operation;

import book.Book;
import book.BookList;

//添加图书
public class BorrowOperation implements IOoperation {

    @Override
    public void work(BookList bookList) {
        System.out.println("请输入要借阅的书名:");
        String name = s.next();
        int newSize = bookList.getUsedSize();
        for (int i = 0; i < newSize; i++) {
            if (name.equals(bookList.getBook(i).getName())) {
                bookList.getBook(i).setBorrowed(true);
                System.out.println("借阅成功");
            }
        }
    }
}
