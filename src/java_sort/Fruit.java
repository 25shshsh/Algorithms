package java_sort;


import java.util.Arrays;
// primitive나 String이 아닌 사용자 정의 객체를 정렬하려면?
// Comparable<> : 정렬하기 위한 기준을 '하나'만 사용가능.
    // >> 왜? 메서드의 리턴타입, 이름, 매개변수가 이미 정해져있기 때문에 1가지 기준밖에 사용할 수 없다.
public class Fruit implements Comparable<Fruit>{ // 중요

    public String name;
    public int quantity;
    public Fruit(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

/*    public int compareTo(Fruit other) { // 중요 -1 0 1로 크기비교.

    }*/


    @Override
    public int compareTo(Fruit other) { // 하나만 사용가능
        return quantity - other.quantity; // -1 0 1로 크기비교. 크기 오름차순
        //return other.quantity - quantity; // -1 0 1로 크기비교. 크기 내림차순
        //return name.compareTo(other.name);
    }
    // 2가지 이상 정렬은 Comparator 인터페이스를 사용해야함.

    public String getFruitName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public static void main(String[] args) {
        Fruit [] fruits = new Fruit[4];
        fruits[0] = new Fruit("Pineapple",70);
        fruits[1] = new Fruit("Apple",50);
        fruits[2] = new Fruit("Banana",100);
        fruits[3] = new Fruit("Orange",80);

        // 크기자체가 정의되어 있지 않기 때문에 정렬이 되면 신기한 것.
        Arrays.sort(fruits); // comparable<> 인터페이스의 compareTo의 기준에 따라 동작.

        for(int i = 0 ; i < fruits.length; i++) {
            System.out.println(fruits[i].getFruitName()+", "+fruits[i].getQuantity());
        }
    }

}

