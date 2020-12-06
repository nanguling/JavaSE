package user;

import operation.*;

import java.util.Scanner;

//普通用户类
public class NormalUser extends User {
    @Override
    public int menu() {
        System.out.println("hello " + this.name + ",欢迎使用图书系统");
        System.out.println("1.查找图书");
        System.out.println("2.借阅图书");
        System.out.println("3.归还图书");
        System.out.println("0.退出系统");
        int choice = scanner.nextInt();
        return choice;
    }

    public NormalUser(String name) {
        super(name);
        this.iOoperations = new IOoperation[] {
                new ExitOperation(),
                new FindOperation(),
                new BorrowOperation(),
                new ReturnOperation()
        };
    }
}
