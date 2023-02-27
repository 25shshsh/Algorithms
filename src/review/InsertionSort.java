package review;

import java.util.stream.IntStream;

public class InsertionSort {
    // 이미 정렬이 되어있는 배열 + 원소를 더하여 정렬이 되어있는 부분을 넓혀간다.
    // 정렬이 되어있는 배열의 시작은 처음부터겠고, 종료시점은 array.length-1 까지
    // 정렬이 되어있는 배열의 끝 인덱스가 i라면 i+1까지 범위를 늘리고 내부에서 정렬하겠네
    private static int [] data = {1,8,6,5,3,4,2,7};

    public static void main(String[] args) {
        printArr(insertionSort(data));
    }

    static int [] insertionSort (int [] array) {
        int n = array.length;
        int smallestIdx = 0; // i ~ n-1
        int tmp = 0;
        int cnt = 0;
        // 1. 배열에서 가장 작은 값을 찾아 인덱스 맨 왼쪽과 스왑한다. (0 ~ n-1)
        // 2. 이제 배열의 맨 왼쪽의 값은 가장 작은 값이므로 무시하고 나머지 값 중에서 최솟값을 찾아 반복(1 ~ n-1)
        // 3. 언제까지? 나머지 값이 1개가 될 때까지 (비교는 원소가 2개이상일때 가능하니까)
        while(cnt < n-1) { // n 대신 n-1로 비교가능 원소가 0개가 아닌, 1개만 있어도 종료가능
            for (int i = cnt; i < n; i++) {
                if (array[smallestIdx] > array[i]) {
                    smallestIdx = i;
                }
            }
            swap(array,smallestIdx,cnt);
            smallestIdx = ++cnt;
        }
        return array;
    }

    static void swap (int [] array, int firstIdx, int secondIdx) {
        int tmp = 0;
        tmp = array[firstIdx];
        array[firstIdx] = array[secondIdx];
        array[secondIdx] = tmp;
    }

    static void printArr (int [] array) {
        IntStream.rangeClosed(0,array.length-1).forEach(i -> {
            System.out.print(array[i]+" ");
        });
        System.out.println();
    }

}
