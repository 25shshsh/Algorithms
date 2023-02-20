package sort_algorithm;

import java.util.stream.IntStream;

public class HeapSort {// 인덱스 0 기준이다.
    // https://st-lab.tistory.com/225
    static int [] data = {2,8,6,1,10,15,3,12,11}; // 9
    static int [] data2 = {2,8,6,1,10,15,3,12,11}; // 9

    public static void main(String[] args) {
        sort(data);
        IntStream.rangeClosed(0,data.length-1).forEach(i -> {
            System.out.print(data[i]+" ");
        });
    }

    private static int getParent(int child) { // 부모 인덱스를 얻는 함수
        return (child - 1) / 2; // 인덱스 0부터일때
    }

    private static void swap(int [] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
    public static void maxHeap(int[] arr, int arrLength) { // maxheap 정렬법. O(n)

        if(arrLength < 2) { //basecase 비교하려면 최소2개필요.
            return;
        }

        int parentIdx = getParent(arrLength - 1); // size-1은 트리의 마지막 원소.

        // max heap 구성 : heapify가 반복하여 재귀하여 구성한다.
        for(int i = parentIdx; i >= 0; i--) { // 가장 작은 크기의 CBT부터 힙으로 >> 전체를 힙정렬상태로
            heapify(arr, i, arrLength - 1); // recursive case
        }

    }

    public static void sort(int[] arr) {
        sort(arr, arr.length); // 은닉을 위해 public메서드안에 private로 만든 실제로직 첨가. **
    }

    private static void sort(int[] arr, int arrLength) { // max-heap정렬상태에서 오름차순 정렬법.

        maxHeap(arr,arrLength);

        // 정렬하려면 (max)heap상태가 전제조건이다. **
        for(int i = arrLength - 1; i > 0; i--) {

            /*
             *  root인 0번째 인덱스와 (size-1)번째 인덱스의 값을 교환해준 뒤 마지막 인덱스를 제외
             *  0 ~ (i-1) 까지의 부분트리에 대해 max heap을 만족하도록 재구성한다.
             *  size < 2 까지 반복하여.
             */
            swap(arr, 0, i);
            heapify(arr, 0, i - 1); //0번째인덱스가 힙을 깨니까 0번째인덱스를 리프까지 옮긴다.
        }

    }

    static void heapify(int[] arr, int parentIdx, int lastIdx) {
        /*
         * 현재 트리에서 부모 노드의 자식노드 인덱스를 각각 구해준다.
         * 현재 부모 인덱스를 가장 큰 값을 갖고있다고 가정한다.
         */
        int leftChildIdx = 2 * parentIdx + 1;
        int rightChildIdx = 2 * parentIdx + 2;
        int largestIdx = parentIdx; // 임시로 지정.

        /*
         *  left child node와 비교
         *
         *  자식노드 인덱스가 끝의 원소 인덱스를 넘어가지 않으면서, 현재 가장 큰 인덱스(초기는 부모)보다 왼쪽 자식노드의 값이 더 클경우
         *  가장 큰 인덱스를 가리키는 largestIdx를 왼쪽 자식노드인덱스로 바꿔준다.
         */
        if(leftChildIdx <= lastIdx && arr[largestIdx] < arr[leftChildIdx]) {
            largestIdx = leftChildIdx;
        }

        /*
         *  left right node와 비교
         *
         *  자식노드 인덱스가 끝의 원소 인덱스를 넘어가지 않으면서, 현재 가장 큰 인덱스보다 오른쪽 자식노드의 값이 더 클경우
         *  가장 큰 인덱스를 가리키는 largestIdx를 오른쪽 자식노드인덱스로 바꿔준다.
         *
         */
        if(rightChildIdx <= lastIdx && arr[largestIdx] < arr[rightChildIdx]) {
            largestIdx = rightChildIdx;
        }

        /*
         * largestIdx 와 부모노드가 같지 않다는 것은, 위 자식노드 비교 과정에서 현재 부모노드보다 큰 노드가 존재한다는 뜻이다.
         * 그럴 경우 해당 자식 노드와 부모노드를 교환해주고,
         * 교환 된 자식노드를 부모노드로 삼은 서브트리를 검사하도록 재귀 호출 한다.
         */
        if(parentIdx != largestIdx) { // largestIdx가 자식노드로 바뀌었다면? (basecase 조건)
            swap(arr, largestIdx, parentIdx); // largetstIdx = left OR rightChildIdx를 부모노드의 인덱스와 바꿔주고 (왜? 자식노드가 더 크니까)
            heapify(arr, largestIdx, lastIdx); // 나보다 컸던 자식의 위치로 내려와서 recursion
            // 내가 100인데 1과 치환되면 나 = 1이잖아.
        }
    }


}
