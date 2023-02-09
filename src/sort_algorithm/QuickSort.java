package sort_algorithm;

import java.util.stream.IntStream;

public class QuickSort {

    private static int [] data = {3,7,8,2,4,6,1,5};

    public static void main(String[] args) {
        quickSort(data,0,data.length-1);
        IntStream.rangeClosed(1, data.length).forEach(i -> {
            System.out.print(data[i-1]+ " ");
        });
        System.out.println();
    }


    static int partition(int[] A, int p, int r) {
        int tmp;
        int i = p-1; // -1

        for (int j = p; j < r; j++) { // j는 pivot과 크기를 비교할 대상.
            if(A[j] <= A[r]) {
                i += 1;
                tmp = A[j];
                A[j] = A[i];
                A[i] = tmp;
                 // i가 늘어나서 j는 자연히 1칸 밀리는 것.
            }else {
                // A[j]가 A[r]보다 크다면? >> 그냥 냅두고 j+1(비교대상 위치+1)이다.
            }

        }
        // pivot을 옳바른 위치로 치환.
        tmp = A[r];
        A[r] = A[i+1];
        A[i+1] = tmp;
        return i+1;
    }

    static void quickSort (int[] arr, int begin, int end) {
        if(begin < end) { // basecase
            int pivot = partition(arr, begin, end); // pivot을 기준으로 양쪽 배열은 정렬상태
            quickSort(arr, begin, pivot-1);
            quickSort(arr, pivot+1, end); // basecase까지 recursion 2^N번 반복
        }
    }

}