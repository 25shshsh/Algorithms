package sort_algorithm;

import java.util.stream.IntStream;

public class RadixSort { // d가 상수, k < n일때, O(n) 리니어다.
    // 사전조건 : k자리 정수들로 이루어진 배열
    private static int [] array = {322,121,122,321,112,111};

    public static void main(String[] args) {

        System.out.println(322%990);
    }

    static void radixSort(int [] array, int n, int k) {
        // n : array.length-1 (원소의 개수), k : 각 원소의 자릿수(1부터 k까지)

        while(k >= 1) {
            int j = (int) Math.pow(10, (k-1));

            for(int i = 0; i < n; i++) {

            }

           k--;
        }

    }
    // 배열의 두 인덱스의 값을 바꾸는 기능.
    public static void swap(int [] array, int firstIdx, int secondIdx) {
        int tmp = array[firstIdx];
        array[firstIdx] = array[secondIdx];
        array[secondIdx] = tmp;
    }

    // 배열을 출력하는 기능.
    public static void printArr(int[] array) {
        IntStream.rangeClosed(0, array.length - 1).forEach(i -> {
            System.out.print(array[i] + " ");
        });
        System.out.println();
    }
}
