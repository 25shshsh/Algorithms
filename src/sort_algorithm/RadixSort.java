package sort_algorithm;

import java.util.stream.IntStream;

public class RadixSort { // d가 상수, k < n일때, O(n) 리니어다.
    // 사전조건 : d자리 정수들로 이루어진 배열
    static int [] array = {322,121,122,321,112,111};

    static void radixSort(int [] array, int digit) {
        IntStream.rangeClosed(1,digit).forEach(i -> { // digit번 stable sort 실행.

        });
    }
}
