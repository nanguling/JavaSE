public class TestDemo {
    public static void main(String[] args) {
/*        DoubleList doubleList = new DoubleList();
        doubleList.addFirst(6);
        doubleList.addFirst(4);
        doubleList.addFirst(1);
        doubleList.addFirst(1);
        doubleList.addFirst(2);
        doubleList.removeAllKey(3);
        doubleList.display();*/
        HomeWork homeWork = new HomeWork();
        homeWork.addLast(2);
        homeWork.addLast(2);
        homeWork.addLast(2);
        homeWork.addLast(2);
        homeWork.addLast(2);
        homeWork.display();
        homeWork.removeAllKey(2);
        homeWork.display();
    }
}
