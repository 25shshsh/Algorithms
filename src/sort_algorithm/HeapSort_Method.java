package sort_algorithm;

// import static sort_algorithm.HeapSort.sort;
// import static :  메소드나 변수를 패캐지, 클래스명없이 접근가능하게 해줌

import java.util.stream.IntStream;


public class HeapSort_Method { // insert(), extractMax() 이 둘은 최대우선순위 큐에서 지원하는 연산.
    private static int [] data = {2,8,6,1,10,16,3,12,11};
    private static int size = data.length-1; // 증감연산자로 계속 변경 ㅇ?
    private static int maxsize;
    public static void main(String[] args) {
        HeapSort.sort(data);
        printArr(data);

        System.out.println(extractMax());
        printArr(data);

        insert(data, 99);
        printArr(data);

        HeapSort.sort(data);
        printArr(data);

    }
    public static void insert(int [] array, int e){
        HeapSort.maxHeap(data, size); // heap 상태가 전제조건이다. ^^

        data[++size] = e; // size의 크기를 올리고 요소 e를 추가한다.

        int current = size; // 가장 마지막 인덱스

        while (data[current] > data[getparent(current)]) { // (자식노드 - 1) /2 = 부모노드 인덱스 , 인덱스가 0부터 시작일때
            swap(data,current, getparent(current)); // max-heap을 만들기 위해 자식노드가 더 크다면 위쪽으로 옮긴다.
            current = getparent(current); // 현재 parent노드가 이제 자식노드가 되면서 위에 있는 노드와 또 비교해야한다.
        }
        // max-heap 상태에서 추가된 원소하나만 정렬하면 된다. >> 추가된 원소만 힙정렬을 깨기 때문

    }


    public static int extractMax() {
        HeapSort.maxHeap(data, size+1); // heap 상태가 전제조건이다.
        int popped = data[0]; // 최댓값 추출
        data[0] = data[size--]; // 마지막노드와 루트노드 바꾸고, size-1

        HeapSort.heapify(data,0,size); // 말썽노드가 인덱스0 1개니까 heap정렬도 1번만 해주면 된다.
        return popped;
    }

    public static void printArr(int[] intArray) {
        IntStream.rangeClosed(0, size).forEach(i -> {
            System.out.print(intArray[i]+" ");
        });
        System.out.println();
    }

    public static void swap(int [] data, int indexI, int indexJ) {
        int tmp;
        tmp = data[indexI];
        data[indexI] = data[indexJ];
        data[indexJ] = tmp;
    }

    public static int getparent(int child) {
        return (child-1)/2;
    }
}
