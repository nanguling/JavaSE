package com.extendseg;

import java.util.concurrent.Callable;

class Animal {
    protected String name;
    public Animal(String name) {
        this.name = name;
    }
    public void eat() {
        System.out.println(this.name + " eat()");
    }
}

class Cat extends Animal {
    //super.代表父类对象的引用
    //super.data访问父类的数据成员
    //super.fun()调用父类方法
    //super()调用父类构造方法
    public Cat(String name) {
        super(name);//显示父类构造方法
    }

    @Override
    public void eat() {
        System.out.println(this.name + "猫猫eat()");
    }

    public void func() {
        System.out.println("func");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
    public void wangwang() {
        System.out.println(this.name + " wangwang");
    }
}

public class TestDemo {

    private int a = 10;

    public static void main5(String[] args) {
        Animal animal = new Cat("mimi");
    }
    public static void main4(String[] args) {
        Animal animal2 = new Cat("mimi");
        animal2.eat();
        Cat cat = (Cat) animal2;//向下转型
        cat.func();
        //判断一个引用是否是某个类的实例
        if (animal2 instanceof  Dog) {
            Dog dog = (Dog) animal2;
            dog.wangwang();
        }
    }
    public static void main3(String[] args) {
        Animal animal = new Animal("SADA");
        Cat cat = new Cat("mimi");
        animal.eat();
        cat.eat();
        Animal animal2 = new Cat("mimi");
        animal2.eat();
        //animal2.fun()父类引用调用的方法必须是在父类中拥有的
    }
    public static void main2(String[] args) {
        Animal animal = new Animal("ss");
        System.out.println(animal.name);
    }
    public static void main1(String[] args) {
        Cat cat = new Cat("mimi");
        cat.eat();
        Dog dog = new Dog("萝莉");
        dog.wangwang();
    }
}
