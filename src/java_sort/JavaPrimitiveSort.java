package java_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;


public class JavaPrimitiveSort {
    private static int[] data = {7,6,3,2,1,8,4,5};
    private static int[] data2 = {7,6,3,2,1,8,4,5,0,0,0,0,0};
    private static int[] data3 = new int[data.length];

    private static String [] data4 = {"banana", "orange","apple"};

    // Arrays 클래스가 원시타입 정렬메서드 제공.
    // double, char 등 다른 primitive type도 사용가능.
    public static void main(String[] args) {
        Arrays.sort(data); // Arrays.sort()로 정렬된다.
        printArr(data);

        Arrays.sort(data2,0,7+1); // data[0] ~ data[size-1]
        printArr(data2);

        // String 타입 정렬도 가능, 대소문자 우선순위도 해줌.
        Arrays.sort(data4);
        System.out.print(data4[0]+" ");
        System.out.print(data4[1]+" ");
        System.out.println(data4[2]);

        // ArrayList 문자열 정렬
        List<String> fruits = new ArrayList<String>();
        fruits.add("Pineapple");
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Banana");
        Collections.sort(fruits); // Collections.sort(ArrayList)로 정렬된다.

        for(String str: fruits) {
            System.out.print(str+ " ");
        }
        System.out.println();



    }

    static void printArr (int [] array) {
        IntStream.rangeClosed(0,array.length-1).forEach(i -> {
            System.out.print(array[i] + " ");
        });
        System.out.println();
    }
}
