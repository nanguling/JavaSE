package operation;

import book.Book;
import book.BookList;

//删除图书
public class DelOperation implements IOoperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入要删除的书名:");
        String name = s.next();
        int newSize = bookList.getUsedSize();
        int count = 0;
        for (int i = 0; i < newSize; i++) {
            if (name.equals(bookList.getBook(i).getName())){
                count = i;
                break;
            }
        }
        for (int i = count; i < newSize-1; i++) {
            Book book = bookList.getBook(i+1);
            bookList.setBook(i,book);
        }
        System.out.println("删除成功！");
        bookList.setUsedSize(bookList.getUsedSize()-1);
    }
}
