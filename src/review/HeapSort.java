package review;

import java.util.stream.IntStream;

public class HeapSort {
    // FBT, CBT일 때 이진트리를 배열로 표현할 수 있다.
    // 1. 이진트리의 가장 작은 부모인덱스는 ((array.length-1)-1) / 2이다.
    // 2. 가장 작은 부모인덱스부터 루트노드까지 heapify를 한다면 트리 전체가 heafify가 된 것.
    // 3. 이 힙정렬 상태를 기본으로 가장 큰 값인 루트노드를 배열의 마지막 인덱스와 교환한 후, 배열의 길이를 -1하면서 이진트리를 또 heapify한다. (반복)
    //    배열의 길이가 1이 될때까지 반복한다.
    private static int [] data = {1,8,6,5,3,4,2,7};
    private static int n = data.length;

    public static void main(String[] args) {
        printArr(heapSort(data,0,n-1));
        //maxheap(data);
        //printArr(data);
    }
    static int [] heapSort(int [] array, int firstIdx, int lastIdx) {
        // 정렬하기 이전 기본적으로 힙 상태가 되어야한다.
        maxheap(array);

        while(lastIdx > 0) {
            swap(array,firstIdx,lastIdx--);
            heapify(array,firstIdx,lastIdx);
        }
        return array;
    }
    static int getParent(int childIdx) { // 1.
        int parentIdx = (childIdx-1)/2;
        return parentIdx;
    }

    static void maxheap(int [] array) { // 2.
        for(int i = getParent(n-1); i >= 0 ; i--) {
            heapify(array,i,n-1);
        }
    }

    static void heapify (int [] array, int parentIdx, int lastIdx) { // 정렬할 최소단위에 포함되 매개변수들
        int leftChildIdx = (parentIdx*2)+1;
        int rightChildIdx = (parentIdx*2)+2;
        int largestIdx = parentIdx;

        // childIdx의 범위는 lastIdx내에 있어야한다.
        if(leftChildIdx <= lastIdx && array[largestIdx] < array[leftChildIdx]) { //** 2번 연속 틀림 ㅋㅋ
            largestIdx = leftChildIdx;
        }
        // array[largestIdx] 말고 array[parentIdx]로 해버린다면? 자식노드 2개가 부모노드보다 큰데
        // 왼쪽노드가 또 오른쪽노드보다 값이 큰 경우 꼬여버린다. >> 부모노드보다 크지만 자식노드 중 작은 쪽이랑 치환되기 때문
        if(rightChildIdx <= lastIdx && array[largestIdx] < array[rightChildIdx]) {
            largestIdx = rightChildIdx;
        }

        // 만약 largetIdx가 parentIdx가 아니라면 두 자식노드 중 하나보다 부모노드가 작다는 이야기
        if (parentIdx != largestIdx) {
            swap(array,parentIdx,largestIdx); // 더 큰 값을 어떤 자식노드가 가지고있는지 모르지만 값을 치환했다.
            heapify(array, largestIdx, lastIdx); // 여기서의 largetstIdx는 스왑하고 내려온 parentIdx의 값이다. 이 값을 다시 부모노드로 지정 **
        }


    }
    static void swap (int [] array, int firstIdx, int secondIdx) {
        int tmp = 0;
        tmp = array[firstIdx];
        array[firstIdx] = array[secondIdx];
        array[secondIdx] = tmp;
    }

    static void printArr (int [] array) {
        IntStream.rangeClosed(0,data.length-1).forEach(i -> {
            System.out.print(array[i]+" ");
        });
        System.out.println();
    }
}
