package recursion;

public class Code01_3 {
    // 순환알고리즘 설계 : 암시적 매개변수 -> 명시적 매개변수로 바꾸어라. (implicit -> explicit)
    public static void main(String[] args) {
        String [] array = {"1","2","3","tmdgus","5"};
        int [] data = {5,1,8,4,5};
        int index = binarySearch(array, "tmdgus", 0, array.length - 1);
        System.out.println(array[index].equals("tmdgus"));

        System.out.println(findMax(data,0,2));
    }

    // 매개변수 명시화 : 순차탐색
    // 하지만 생략할 수 있는 부분은 생략하는 것이 좋다. 예를 들어 end같은 경우에 항상 값이 고정이므로
    // 매개변수 하나를 생략하고 end대신 data.length를 사용하는 것이 좋다.
    public static int search(int [] data, int begin, int end, int target) {
        if(begin > end) {
            return -1;
        }
        else if (data[begin] == target){
            return begin;
        } else {
            return  search(data, begin+1, end, target);
        }
    }


    // begin = 0, end = 2 일때. 쉽게 생각해보자.
    // 0 vs 1~2
    // 0 vs  1  vs 2
    // return Math.max(data[begin], Math.max(data[begin+1], Math.max(data[begin+2], data[end])));
    public static int findMax(int [] data, int begin, int end) { // 배열에서 최댓값 구하기
        if(begin == end) {
            return data[begin];
        } else {
            return Math.max(data[begin], findMax(data, begin+1, end));
        }
    }

    // Binary Search : O(logn), 전제조건 데이터가 정렬되어있다.
    public static int binarySearch(String[] item, String target, int begin, int end) {
        if(begin>end) { // basecase = recursion 종료조건
            return -1;
        }
        else {
            int middle = (begin+end)/2;
            int compResult = target.compareTo(item[middle]); // ** target이 클 경우 1, 같을경우 0, target이 작을경우 -1

            if (compResult == 0)
                return middle;
            else if (compResult < 0) // target이 middle보다 작다면
                return binarySearch(item, target, begin, middle-1); // 탐색범위는 begin부터 middle-1까지로 수정
            else
                return binarySearch(item, target, middle+1, end); // 탐색범위는 middle+1부터 end까지
        }
    }


}
