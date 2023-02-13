package sort_algorithm;

import java.util.stream.IntStream;

public class MergeSort {

    private static int[] data = {7,6,3,2,1,8,4,5};
    private static int[] tmp;


    public static void main(String[] args) {
        printArr(mergeSort(data,0, data.length-1));
    }

    static int [] mergeSort(int[] array, int p, int r) {
        if(p < r) { //만약 p >= r 이라면 정렬할 데이터는 없다. basecase
            int q = (p+r)/2; // middle
            mergeSort(array,p,q); //recursive case
            mergeSort(array,q+1,r);
            merge(array,p,q,r); // 최대분할시키고 각각 합병정렬실시
        }
        return array;
    }

    static void merge (int [] array, int p, int q, int r) { // 각각의 포인터로 비교진행도 체크

        int i = p, j = q+1, k = p; // k=0으로하면 망함 recursion 돌면서 pqr값이 유동적으로 변하기 때문에
        tmp = new int[data.length]; // 같은 크기의 임시배열생성.


        while(i <= q && j <= r) { // 쪼개진 양쪽배열 둘 중 하나라도 데이터복사가 끝나면 동작정지.
            if(array[i] <= array[j]) {
                //tmp[k++] = array[i++];
                tmp[k] = array[i];
                i++;
                k++;
            } else {
                tmp[k++] = array[j++];
            }
        }


        while(i <= q){ // 데이터복사가 끝나지 않은 나머지 하나의 배열 데이터를 그대로 복사해서 tmp에 붙여넣으면 된다.
            tmp[k++] = array[i++];
        }
        while(j <= r){
            tmp[k++] = array[j++];
        }


        for (i = p; i <= r; i++) {
            array[i] = tmp[i]; // 반복문 대신 data=tmp; 이런식으로 표현하면 같은 주소를 가져서 앞으로 수정할때마다 둘이 같이 바뀐다.
        }


    }

    static void printArr (int [] array) {
        IntStream.rangeClosed(0,array.length-1).forEach(i -> {
            System.out.print(array[i] + " ");
        });
        System.out.println();
    }


}
