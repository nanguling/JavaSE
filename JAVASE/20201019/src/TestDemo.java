public class TestDemo {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0,6);
        myArrayList.add(0,5);
        myArrayList.add(0,4);
        //myArrayList.add(0,2);
        myArrayList.add(0,2);
        //myArrayList.add(0,2);
        myArrayList.add(0,1);
        myArrayList.display();
        myArrayList.add(2,132);
        myArrayList.display();
    }
}
