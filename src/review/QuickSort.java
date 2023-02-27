package review;

import java.util.Random;
import java.util.stream.IntStream;

public class QuickSort {
    // 평균적인 성능이 좋아 실전에서 가장 많이 쓴다.
    // 1. 기준원소(pivot)을 삼는다.
    // 2. 기준원소를 배열의 끝에 있는 원소와 위치를 바꾼다.
    // 3. 오직 기준원소보다 작은원소들, 큰 원소들로 나눈다. (각각의 원소들의 크기는 정렬하지 않는다.)
    // 4. 정렬이 끝난 후 기준원소는 적절한 자리를 찾아들어간다.

    private static int [] data = {1,8,6,5,3,4,2,7};

    public static void main(String[] args) {
        printArr(quickSort(data,0,data.length-1));
    }

    // 피봇 기준 정렬 후 >> 피봇의 인덱스를 리턴한다.
    static int partition(int [] array, int start, int end) {

        Random random = new Random();
        int pivotIdx = random.nextInt(end+1); // bound 8는 0~7

        swap(array,pivotIdx,end); // pivotIdx의 값은 이제 end가 가지고있다. ** swap시 값이 어디로 이동되는지 잘 확인해라. **
        int pivot = end; // pivot 정해짐.

        int i = start-1;
        int j = start;

        while(j < end) {
            if(array[pivot] < array[j]) { // 이 조건의 부등호로 오름차순 내림차순 바뀐다.
                j++;
            }else{ // pivot이 array[j]보다 작을때
                i++;
                swap(array,i,j);
                j++;
            }
        }
        // 정렬 후 pivot을 올바른 위치로 치환. 105p 참고.
        swap(array,i+1,pivot);

        return pivot;
    }

    static int [] quickSort(int [] array, int start, int end) {
        if(start < end) { // basecase
            int pivot = partition(array, start, end); // 기준원소보다 큰지 작은지에 따라 기준원소 양쪽으로 옮김 그리고 기준원소 리턴.
            quickSort(array, start, pivot-1); // 기준원소 기준 전반부에 partition 메서드 실행
            quickSort(array, pivot+1, end); // 기준원소 기준 후반부에 partition 메서드 실행
            // start < end 조건에 부합하는 경우 계속 recursive
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
