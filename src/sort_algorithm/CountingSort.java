package sort_algorithm;

import java.util.stream.IntStream;

public class CountingSort { // 최적화는 안하고 일단 기본적인 구현만 신경써서.

    private static int [] arr = {2,5,3,0,2,3,0,3}; // A
    private static int [] accum; // B
    private static int [] sortedArray = new int[arr.length]; // C

    public static void main(String[] args) {
        System.out.print("정수 0~k까지 라는 사전조건이 있는 배열A : ");
        printArr(arr);

        System.out.print("0~5인 원소의 갯수를 누적한 배열B : ");
        printArr(accumulation(arr,5)); // C

        System.out.print("배열A와 배열B의 규칙성을 이용하여 CountSort : ");
        printArr(countingSort(arr,accum,sortedArray));
    }

    static int [] accumulation(int [] array, int k) { // 0에서 k사이의 정수를 정렬해야한다. (인덱스는 k까지)
        accum = new int[k+1];
        int count = 0;

        for(int i = 0; i < array.length; i++) { // 카운팅
            accum[array[i]] += 1;
        }

        for(int i = 0; i < accum.length; i++) { // 6번누적
            count += accum[i];
            accum[i] = count;
        }
        return accum;
    }

    static int [] countingSort(int [] A, int [] B, int [] C) {
        // A[8-1] = 3 >> B[3] = 7-- >> C[7-1] = 3
        // A[7-1] = 0 >> B[0] = 2-- >> C[2-1] = 0
        for(int i = A.length-1; i >= 0; i--) {
            C[B[A[i]]-1] = A[i];
            B[A[i]]--; // 배열C 인덱스 중복방지 위함. 자세한건 강의 21분쯤 다시보셈
        }
        return C;
    }



    static void printArr(int [] array) {
        IntStream.rangeClosed(0, array.length-1).forEach(i -> {
            System.out.print(array[i]+ " ");
        });
        System.out.println();
    }
}
