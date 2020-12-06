package operation;

import book.Book;
import book.BookList;
import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

//添加图书
public class AddOperation implements IOoperation {

    @Override
    public void work(BookList bookList) {
        System.out.println("请输入您要添加的书名:");
        String name = s.next();
        System.out.println("请输入作者:");
        String author = s.next();
        System.out.println("请输入价格:");
        double price = s.nextDouble();
        System.out.println("请输入这本书的类型:");
        String type = s.next();
        Book book = new Book(name,author,price,type);
        int newSize = bookList.getUsedSize();
        bookList.setBook(newSize,book);
        System.out.println("添加成功！");
        bookList.setUsedSize(newSize + 1);
    }
}
