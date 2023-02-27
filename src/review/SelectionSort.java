package review;

import java.util.stream.IntStream;

public class SelectionSort {
    // 선택정렬
    // 1. 배열에서 가장 큰 원소를 찾는다.
    // 2. 가장 큰 원소를 배열의 끝 원소와 자리를 바꾼다.
    // 3. 배열 내 가장 큰 원소는 자기 자리를 찾았으므로 더 이상 신경쓰지 않아도 된다.

    private static int [] data = {1,8,6,5,3,4,2,7};

    public static void main(String[] args) {
        printArr(selectionSort(data));
    }

    static int [] selectionSort(int [] array) {
        int n = array.length;
        int tmp = 0;
        int largestIdx = 0;

        while(n > 0) {

            for (int i = 0; i < n; i++) {
                if(array[i] > array[largestIdx]) {
                    largestIdx = i;
                }
            }
            tmp = array[n-1];
            array[n-1] = array[largestIdx];
            array[largestIdx] = tmp;

            // 뒷정리.
            n--;
            tmp = 0;
        }
        return array;
    }

    static void printArr (int [] array) {
        IntStream.rangeClosed(0,data.length-1).forEach(i -> {
            System.out.print(array[i]+" ");
        });
        System.out.println();
    }
}
