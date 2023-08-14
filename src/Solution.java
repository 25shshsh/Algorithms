import java.util.stream.IntStream;

public class Solution {

    private static char [] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
    // 4를 반환하고 입력 배열의 처음 4자는 ["a","b","1","2"]여야 합니다.
    public static void main(String[] args) {
        System.out.println(compress(chars));
        printArr(chars);

    }
    // 배열을 한번 서칭하는데 필요한 레버인 index 그리고 배열내부를 새로 뜯어고칠 indexAns
    // index가 처음부터 배열 끝까지 서칭하는동안 0번째 문자열을 저장하고 currentChar라고 한다.

    // 최근문자열과 서칭중인 배열의 index의 문자열이 같고, 그리고 index는 배열 내부에서만 도는 경우
    // 다음 index로의 탐색 그리고 최근문자열의 cnt를 하나 늘려준다.

    // index가 배열을 벗어나거나 최근문자열과 지금 탐색중인 배열의 인덱스의 문자열이 같지않다면
    // 이하 알아서 이해해라 ( 포인터가 돌면서 탐색범위를 기억하고, 탐색범위 앞부분은 공사해나간다. 지저분하게 남은 뒷부분은 indexAns범위 밖이다.)
    public static int compress(char[] chars) {
        int indexAns = 0, index = 0;
        while(index < chars.length){
            char currentChar = chars[index];
            int count = 0;
            while(index < chars.length && chars[index] == currentChar){
                index++;
                count++;
            }
            chars[indexAns++] = currentChar;
            // Integer.toString(count) 정수를 문자열로.
            // toCharArray() : str을 char로 배열에 저장 count = 12일때 배열에 문자열 1,2로 넣기 위함.
            if(count != 1)
                for(char c : Integer.toString(count).toCharArray())
                    chars[indexAns++] = c;
        }
        return indexAns;
    }

    static void printArr (char [] array) {
        IntStream.rangeClosed(0,array.length-1).forEach(i -> {
            System.out.print(array[i]+" ");
        });
        System.out.println();
    }
}
