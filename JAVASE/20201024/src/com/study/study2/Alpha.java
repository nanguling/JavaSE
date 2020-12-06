package com.study.study2;


class Base{

    public Base(String s){

        System.out.print("B");

    }

}

public class Alpha extends Base{

    public Alpha(String s) {
        super(s);
    }

    public static void main(String[] args){

        new Alpha("s");

    }

}