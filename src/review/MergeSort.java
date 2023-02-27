package review;

import java.util.stream.IntStream;

public class MergeSort {
    private static int [] data = {1,8,6,5,3,4,2,7};

    public static void main(String[] args) {
        printArr(mergeSort(data,0, data.length-1));
    }

    static int [] mergeSort (int [] array, int start, int end) {
        int middle = (start+end)/2;

        if(start < end) { //basecase  // if start = 0 middle = 0 end = 1
            mergeSort(array,start,middle);
            mergeSort(array,middle+1,end);
            // 마지막으로 쪼개놓은 것부터 하나의 배열이 될 때까지 봉합들어간다.
            merge(array,start,middle,end); // 한 단위 봉합. 재귀호출 횟수만큼 봉합 반복.
        }

        return array;
    }

    static void merge (int[] array, int start, int middle, int end) {
        int [] tmp = new int[array.length]; // 복붙할 임시배열
        int i = start, j = middle+1, k = start; // i j는 양 배열의 시작점, k는 임시배열의 시작점

        // 최소단위로 쪼개진 배열을 하나로 합칠건데 배열의 원소가 홀수인 경우도 의식하자.
        // 크기를 비교하여 양 배열 중 한쪽이 다 채워진 경우 동작정지.
        while(i <= middle && j <= end) {

            if(array[i] <= array[j]) {
                tmp[k++] = array[i++];
            }else{
                tmp[k++] = array[j++];
            }
        }
        // 아직 데이터복사가 되지않은 한쪽 정렬을 그대로 복사해서 붙여넣으면 된다.
        // >> 왜 가능할까? 각각의 배열의 내부는 이미 정렬이 되어있다는 전제조건이 있다.
        while (i <= middle) {
            tmp[k++] = array[i++];
        }

        while (j <= end) {
            tmp[k++] = array[j++];
        }

        // 배열자체를 같은 값이라고 해버리면 같은 주소값을 공유해버린다.
        // 배열의 각 값을 같은 값으로 해줘야함.
        for (int l = start; l <= end; l++) { // l = 0이 아니고, 현재 합병정렬 중인 인덱스 내에서 시작과 끝을 입력해야함 ********
            array[l] = tmp[l];
        }

    }

    static void printArr (int [] array) {
        IntStream.rangeClosed(0,array.length-1).forEach(i -> {
            System.out.print(array[i]+" ");
        });
        System.out.println();
    }
}
