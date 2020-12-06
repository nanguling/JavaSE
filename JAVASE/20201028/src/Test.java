import book.BookList;
import operation.IOoperation;
import user.Admin;
import user.NormalUser;
import user.User;

import java.util.Scanner;

public class Test {

    //登录
    public static User login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您的姓名");
        String name = scanner.next();
        System.out.println("请输入您的身份:1->管理员，0->普通用户");
        int choice = scanner.nextInt();
        if (choice == 1) {
            return new Admin(name);
        }
        return new  NormalUser(name);
    }

    public static void main(String[] args) {
        BookList bookList = new BookList();
        User user = login();
        while (true) {
            int choice = user.menu();
            IOoperation iOoperation = user.doOperation(choice);
            iOoperation.work(bookList);
        }
    }
}
