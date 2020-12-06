public class TestDemo {
    public static void main(String[] args) {
        HomeWork homeWork = new HomeWork();
        homeWork.addFirst(1);
        homeWork.addFirst(2);
        homeWork.addFirst(3);
        homeWork.addFirst(4);
        homeWork.addFirst(5);
        homeWork.display();
        /*homeWork.removeAllKey(2);
        homeWork.display();*/
        //homeWork.clear();
        //homeWork.display2(homeWork.reverse());
        //System.out.println(homeWork.middleNode().data);
        //System.out.println(homeWork.findKthToTail(3).data);
        homeWork.display2(homeWork.head);
    }
}
