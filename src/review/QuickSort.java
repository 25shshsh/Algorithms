package review;

import java.util.Random;
import java.util.stream.IntStream;

public class QuickSort {
    // 1. 기준원소(pivot)을 삼는다.
    // 2. 기준원소를 배열의 끝에 있는 원소와 위치를 바꾼다.
    // 3. 오직 기준원소보다 작은원소들, 큰 원소들로 나눈다. (각각의 원소들의 크기는 정렬하지 않는다.)
    // 4. 정렬이 끝난 후 기준원소는 적절한 자리를 찾아들어간다. (partition 메서드 마무리)
    // 5. 순환함수로 정렬한다.

    private static int [] data = {1,8,6,5,3,4,2,7};

    public static void main(String[] args) {
        printArr(quickSort(data,0, data.length-1));
    }

    public static int [] quickSort(int [] array, int firstIdx, int lastIdx) {
        if(firstIdx < lastIdx) { // basecase
            int pivotIdx = partition(array, firstIdx, lastIdx);
            quickSort(array, firstIdx, pivotIdx-1);
            quickSort(array, pivotIdx+1, lastIdx);
        }
        return array;
    }

    public static int partition(int [] array, int firstIdx, int lastIdx) {

        Random random = new Random();
        int pivotIdx = random.nextInt(lastIdx - firstIdx + 1) + firstIdx;; // 1. 기준원소(pivot)을 랜덤으로 선택한다.

        swap(array, pivotIdx, lastIdx); // 2. 기준원소를 배열의 끝에 있는 원소와 '실제 값'을 바꾼다.
        pivotIdx = lastIdx; // pivotIdx는 배열의 끝으로 이동되었다.

        // 인덱스 0~i 까지는 pivot보다 작은 수들, j에는 pivot보다 큰 수가 오게끔 하면된다.
        // 마지막으로 i와 j 사이의 i+1의 인덱스와 pivot을 스왑해주면 끝
        // 1 3 2 4 8 7 6 5
        int i = firstIdx-1;
        int j = firstIdx;

        while(j < lastIdx) {
            if(array[pivotIdx] >= array[j]) {
                i++;
                swap(array, i, j);
            }
            j++;
        }

        swap(array,i+1,pivotIdx);

        return i+1; // i+1의 위치에 기준원소가 들어가있으므로 i+1 리턴
    }

    // 배열의 두 인덱스의 값을 바꾸는 기능.
    public static void swap(int [] array, int firstIdx, int secondIdx) {
        int tmp = array[firstIdx];
        array[firstIdx] = array[secondIdx];
        array[secondIdx] = tmp;
    }

    // 배열을 출력하는 기능.
    public static void printArr (int [] array) {
        IntStream.rangeClosed(0,array.length-1).forEach(i -> {
            System.out.print(array[i]+" ");
        });
        System.out.println();
    }
}
