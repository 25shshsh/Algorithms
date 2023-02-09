package sort_algorithm;

import java.util.stream.IntStream;

public class HeapSort {

    static int [] data = {2,8,6,1,10,15,3,12,11}; // 9

    public static void main(String[] args) {
        sort(data);
        IntStream.rangeClosed(0,data.length-1).forEach(i -> {
            System.out.print(data[i]+" ");
        });
    }

    private static int getParent(int child) { // 부모 인덱스를 얻는 함수
        return (child - 1) / 2;
    }

    private static void swap(int [] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public static void sort(int[] a) {
        sort(a, a.length);
    }

    private static void sort(int[] a, int size) { // size란 배열의 크기

        /*
         * 부모노드와 heaify과정에서 음수가 발생하면 잘못 된 참조가 발생하기 때문에
         * 원소가 1개이거나 0개일 경우는 정렬 할 필요가 없으므로 바로 함수를 종료한다.
         */
        if(size < 2) {
            return;
        }

        /*
         * left child node = index * 2 + 1
         * right child node = index * 2 + 2
         * parent node = (child node - 1) / 2
         */

        // 가장 마지막 요소의 부모 인덱스
        int parentIdx = getParent(size - 1); // size-1은 트리의 마지막 원소.

        // max heap 구성 : heapify가 반복하여 재귀하여 구성한다.
        for(int i = parentIdx; i >= 0; i--) {
            heapify(a, i, size - 1);
        }

        // 1번째 max heap 구성 후.
        for(int i = size - 1; i > 0; i--) {

            /*
             *  root인 0번째 인덱스와 (size-1)번째 인덱스의 값을 교환해준 뒤 마지막 인덱스를 제외
             *  0 ~ (i-1) 까지의 부분트리에 대해 max heap을 만족하도록 재구성한다.
             *  size < 2 까지 반복하여.
             */
            swap(a, 0, i);
            heapify(a, 0, i - 1);
        }

    }

    private static void heapify(int[] a, int parentIdx, int lastIdx) {
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
         *  자식노드 인덱스가 끝의 원소 인덱스를 넘어가지 않으면서, 현재 가장 큰 인덱스보다 왼쪽 자식노드의 값이 더 클경우
         *  가장 큰 인덱스를 가리키는 largestIdx를 왼쪽 자식노드인덱스로 바꿔준다.
         */
        if(leftChildIdx <= lastIdx && a[largestIdx] < a[leftChildIdx]) {
            largestIdx = leftChildIdx;
        }

        /*
         *  left right node와 비교
         *
         *  자식노드 인덱스가 끝의 원소 인덱스를 넘어가지 않으면서, 현재 가장 큰 인덱스보다 오른쪽 자식노드의 값이 더 클경우
         *  가장 큰 인덱스를 가리키는 largestIdx를 오른쪽 자식노드인덱스로 바꿔준다.
         *
         */
        if(rightChildIdx <= lastIdx && a[largestIdx] < a[rightChildIdx]) {
            largestIdx = rightChildIdx;
        }

        /*
         * largestIdx 와 부모노드가 같지 않다는 것은, 위 자식노드 비교 과정에서 현재 부모노드보다 큰 노드가 존재한다는 뜻이다.
         * 그럴 경우 해당 자식 노드와 부모노드를 교환해주고,
         * 교환 된 자식노드를 부모노드로 삼은 서브트리를 검사하도록 재귀 호출 한다.
         */
        if(parentIdx != largestIdx) { // <= basecase
            swap(a, largestIdx, parentIdx);
            heapify(a, largestIdx, lastIdx);
            // 부모와 자식을 가르키는 인덱스를 바꿨다.(=값을 서로바꿨다.) -> 이제 여기서 가르키는 largestIdx는 기존의 parentIdx이다.
            // 내가 100인데 1과 치환되면 나 = 1이잖아.
        }
    }


}
