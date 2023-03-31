package structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class BasicList {
    public static void main(String[] args) {
        // 그러나 linkedList에서 arraylist로 요구사항이 바뀌었을때
        // 도형이라는 인터페이스로 사각형이나 삼각형으로 우연하게 변경가능, 제너릭의 개념? SOLID원칙?
        List<String> myList = new LinkedList<>();
        myList = new ArrayList<>(100); // 유연하게 대처가능하다.

        // ArrayList의 경우 초기 용량은 10이고, 초기에 지정한 용량(또는 기본 용량)을 초과할 경우 배열의 크기를 1.5배로 증가시킵니다.

        // 추가 : 마지막위치라면 O(1), 배열을 늘려야한다면 O(n)
        myList.add("날 찾아서 없애봐");
        myList.add("1");
        myList.add("2개다.");

        // 수정 : O(1)
        myList.set(1,"1개다."); // index,E

        // 꺼내기 : index접근이라면 O(1)
        System.out.print(myList.get(0));
        System.out.print(myList.get(1));
        System.out.println(myList.get(2));

        // 삭제(index or object) : index라면 O(1) 후 모든요소를 한칸씩 옮겨야하니 O(n) 추가.
        myList.remove("날 찾아서 없애봐");

        // 길이 : 순차탐색이니까 O(n)
        System.out.println(myList.size()); //2 = 2개

        // 순회 : 마찬가지로 O(n)
        for (String e:myList) {
            System.out.print(e);
        }
        System.out.println();

        // 확인 : 최악의 경우 O(n)
        boolean contains = myList.contains("2개다.");
        System.out.println(contains); // true

        // List를 배열로 변환
        String [] myArray = myList.toArray(new String[myList.size()]);
        // 배열을 List로 변환
        List<String> list = Arrays.asList(myArray);



    }
}
