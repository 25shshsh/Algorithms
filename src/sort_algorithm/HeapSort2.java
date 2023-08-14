package sort_algorithm;

import java.util.stream.IntStream;
// 이게 진짜임
public class HeapSort2 {

    private static int [] arr = {5,1,8,4,7,6,3,2};

    public static void main(String[] args) {
        heapSort(arr,0,arr.length-1);
        printArr(arr);
    }

    public static int getParent (int childIdx) {
        return (childIdx-1)/2;
    }

    public static void heapify (int [] arr, int parentIdx, int lastIdx) { // 최소단위인 heapify
        int leftChildIdx = (parentIdx * 2) + 1;
        int rightChildIdx = (parentIdx * 2) + 2;
        int largestIdx = parentIdx;

        if(leftChildIdx <= lastIdx && arr[largestIdx] < arr[leftChildIdx]) { //arr[parentIdx] < arr[leftChildIdx] 라고해서 오류났었음.
            largestIdx = leftChildIdx; // 나보다 더 큰 자식노드 중 아무나가 아닌, 둘중 더 큰 자식과 교환해야한다. **
        }
        if(rightChildIdx <= lastIdx && arr[largestIdx] < arr[rightChildIdx]) {
            largestIdx = rightChildIdx;
        }

        if(largestIdx != parentIdx) { // largestIdx가 childIdx였다면
            swap(arr, largestIdx, parentIdx);
            heapify(arr, largestIdx, lastIdx); // 새로운 largest가 parent가 되어 반복, 리프노드까지
        }
    }

    public static void maxHeap(int [] arr,int firstIdx, int lastIdx) { // 완성된 heapify의 한 단위
        // 정렬전 전제조건이므로 한번만 쓸 것임.
        int parentIdx = getParent(lastIdx); // parentIdx부터 0번째까지가 모든 부모인 인덱스임 (역방향으로 힙)

        for(int i = parentIdx; i >= 0; i--) {
            heapify(arr,i, lastIdx);
        }
        // printArr(arr); maxHeap 확인 8 7 6 4 1 5 3 2
    }

    public static void heapSort(int [] arr, int firstIdx, int lastIdx) {
        maxHeap(arr, firstIdx, lastIdx);

        while(lastIdx > 0){
            swap(arr, firstIdx, lastIdx--); // lastIdx에 최댓값을 넣고 제외시킨다.
            heapify(arr, firstIdx, lastIdx);
        }
    }

    public static void swap (int [] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    public static void printArr(int [] array) {
        IntStream.rangeClosed(0, array.length-1).forEach(i -> {
            System.out.print(arr[i]+" ");
        });
        System.out.println();
    }
}
