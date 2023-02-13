package java_sort;

import java.util.Arrays;
import java.util.Comparator;

public class MyComparator implements Comparator<Fruit> { // 27분에 코드, 기본 오름차순 정렬

    public static void main(String[] args) {
        Fruit [] fruits = new Fruit[4];
        fruits[0] = new Fruit("Pineapple",70);
        fruits[1] = new Fruit("Apple",50);
        fruits[2] = new Fruit("Banana",100);
        fruits[3] = new Fruit("Orange",80);

        MyComparator myComparator = new MyComparator();
        //Arrays.sort(fruits, myComparator.nameComparator);
        Arrays.sort(fruits, quanComparator); // static으로 쓰는 것이 일반적.

        for(int i = 0 ; i < fruits.length; i++) {
            System.out.println(fruits[i].getFruitName()+", "+fruits[i].getQuantity());
        }
    }

    java.util.Comparator<Fruit> nameComparator = new java.util.Comparator<Fruit>() {
        @Override
        public int compare(Fruit o1, Fruit o2) {
            return o1.name.compareTo(o2.name);
        }
    };

    public static java.util.Comparator<Fruit> quanComparator = new java.util.Comparator<Fruit>() {
        @Override
        public int compare(Fruit o1, Fruit o2) {
            return o1.quantity - o2.quantity;
        }
    };

    @Override
    public int compare(Fruit o1, Fruit o2) {
        return 0;
    }
}
