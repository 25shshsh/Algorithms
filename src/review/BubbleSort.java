package review;

import java.util.stream.IntStream;

public class BubbleSort {
    // 1. 정렬할 배열이 주어진다.
    // 2. 왼쪽부터 이웃한 쌍들을 비교해나간다.
    // 3. 왼쪽인덱스가 오른쪽인덱스보다 크다면? >> 스왑한다.
    // 4. 배열의 끝까지 도달하였다면 맨 오른쪽 수를 제외하고 반복
    // >> 왼쪽부터 한 쌍씩 비교해나가면서 큰 값을 오른쪽으로 오게끔. 결국 인덱스의 끝에는 배열의 가장 큰 값이 오고, n-1 배열반복.

    // 배열의 원소개수가 n개라면, n-1번 비교한다. (0 ~ n-1)
    // >> 즉 한 쌍씩 비교하면 둘 중 큰 놈을 계속 오른쪽으로 보내면 된다.

    private static int [] data = {1,8,6,5,3,4,2,7};

    public static void main(String[] args) {
        printArr(bubbleSort(data));
    }

    static int [] bubbleSort (int [] array) {
        int n = array.length;
        int tmp = 0;

        while(n > 1) {
            for(int i = 0; i < n-1; i++) { // length-2번 비교
                if(array[i] > array[i+1]) {
                    swap(array,i,i+1);
                }
            }
            n--;
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
