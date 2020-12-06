package operation;

import book.BookList;

//归还图书
public class ReturnOperation implements IOoperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入要归还的书名:");
        String name = s.next();
        int newSize = bookList.getUsedSize();
        for (int i = 0; i < newSize; i++) {
            if (name.equals(bookList.getBook(i).getName())) {
                bookList.getBook(i).setBorrowed(false);
                System.out.println("归还成功！");
            }
        }
    }
}
