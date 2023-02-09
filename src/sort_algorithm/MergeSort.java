package sort_algorithm;

public class MergeSort {

    private static int[] data = {7,6,3,2,1,8,4,5}; // {2, 4, 6, 8, 1, 3, 5, 7};
    private static int a = (data.length - 1) / 2;
    private static int b = (data.length - 1);
    private static int p; // begin
    private static int q; // (begin+end/2)
    private static int r; // end

    public static void main(String[] args) {
        mergeSort(data, 0,data.length - 1);
    }
    public static void mergeSort(int[] data, int start, int end) { // data[start... end]까지 정렬한다.
        if (start < end) { // basecase , 정렬할 데이터가 있다면
            int middle = (start + end) / 2;
            mergeSort(data, start, middle);
            mergeSort(data, middle + 1, end);
            merge(data, start, middle, end); // recursive case
            // **** recursion이 처음~중간, 중간~끝 2가지로 쪼개서 2번실행하니까, 처음에는 함수가 2번 다음에는 4번 종료조건까지 무한반복.
        }
    }

    // ** merge함수 : (정렬되어있는!) 전반부배열과 후반부배열을 합하여 정렬된 하나의 배열 A[p~r]을 만든다.
    static void merge(int data[], int p, int q, int r) {
        // 4 2 1 쪼갠 후 로직실행 후 1 2 4 결과부터 저장.


        int i = p, j = q + 1, k = p; // i=begin, j=middle+1, k=temp의 시작점
        int[] tmp = new int[data.length]; // 같은 크기의 배열생성.

        while (i <= q && j <= r) { // 쪼개진 양쪽배열 둘 중 하나라도 데이터복사가 끝나면 동작정지.
            if (data[i] <= data[j]) {
                tmp[k++] = data[i++]; // i가 작다면 i를 tmp배열에 복사 후, k와 i +1
            } else {
                tmp[k++] = data[j++]; // j가 작다면 j를 tmp배열에 복사 후, k와 j +1
            }
        }
        // 데이터복사가 끝나지 않은 나머지 하나의 배열 데이터를 그대로 복사해서 tmp에 붙여넣으면 된다.
        while (i <= q) {
            tmp[k++] = data[i++];
        }
        while (j <= r) {
            tmp[k++] = data[j++];
        }


        // 데이터복사가 완료된 임시배열 tmp를 data로 붙여넣기.
        for (i = p; i <= r; i++) {
            data[i] = tmp[i]; // 반복문 대신 data=tmp; 이 친구쓰면 같은 주소를 가져서 앞으로 수정할때마다 둘이 같이 바뀐다.
        }

        for (i = p; i <= r; i++) {
            System.out.print(data[i]);
        }
        System.out.println();


    }


}
