package user;

import operation.*;

//管理员类
public class Admin extends User {
    @Override
    public int menu() {
        System.out.println("hello " + this.name + ",欢迎使用图书系统");
        System.out.println("1.查找图书");
        System.out.println("2.新增图书");
        System.out.println("3.删除图书");
        System.out.println("4.显示所有图书");
        System.out.println("0.退出系统");
        int choice = scanner.nextInt();
        return choice;
    }

    public Admin(String name) {
        super(name);
        this.iOoperations = new IOoperation[] {
                new ExitOperation(),
                new FindOperation(),
                new AddOperation(),
                new DelOperation(),
                new DisplayOperation()
        };
    }
}
