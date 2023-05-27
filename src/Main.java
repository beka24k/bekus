public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        BST<Integer,Integer> temp=new BST<>();
        temp.put(5,23);
        temp.put(123,2);
        temp.put(2,3);
        temp.put(3,4);
        temp.put(14,8);
        System.out.println(temp.consist(23));
    }
}