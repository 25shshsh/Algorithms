package sort_algorithm;

import java.util.stream.IntStream;

public class CountingSort {

    private static int [] data = {2,5,3,0,2,3,0,3};
    private static int [] sortData = new int [data.length];
    private static int k = 5; // 정렬 할 정수의 크기는 0~k이다. // 매개변수로도 사용.
    private static int [] countArr = new int [k+1];

    public static void main(String[] args) {
        countingSort(data,sortData); // return sortData
        printArr(sortData);
    }

    static int [] counting (int [] data, int [] emptyArr) { // O(N^2)인거 같은데 선형시간이 왜 될까 확인해봐야할듯.
        int cnt = 0;

        IntStream.rangeClosed(0,data.length-1).forEach(i -> {
            emptyArr[data[i]]++;  // 기본 카운팅
        });

        for(int i = 0; i < emptyArr.length; i ++) { // cnt에 누적시킨 값을 배열에 다시 붙여넣어서 누적합이 만들어짐.
            cnt += emptyArr[i];
            emptyArr[i] = cnt;
        }

        return emptyArr;
    }

    static int [] countingSort(int [] data, int [] sortData) {
        counting(data,countArr);

        IntStream.rangeClosed(0, data.length-1).forEach(i -> { // A[2] = 5, C[5] = 8, B[8-1] = 5
            sortData[countArr[data[i]]-1] = data[i];
            countArr[data[i]]--; // 중복값은 sortData의 인덱스를 한 칸 앞으로 옮김 (저장되는 값은 동일)
        });

        return sortData;
    }


    static void printArr(int [] array) {
        IntStream.rangeClosed(0, array.length-1).forEach(i -> {
            System.out.print(array[i]+ " ");
        });
        System.out.println();
    }
}
