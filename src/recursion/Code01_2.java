package recursion;

import java.util.Scanner;

public class Code01_2 {
    public static void main(String[] args) {
        System.out.println(length("asdsd"));
        printChars("ABC");
        printCharReverse("ABCD");
        printInBinary(8);

        System.out.println();
        int[] array = { 5, 4, 3, 2, 1 };
        System.out.println(sum(5, array));

        int n = 3;
        int [] data = new int[n];
        Scanner in = new Scanner(System.in);
        readFrom(n, data, in);


    }

    public static int length(String str) { // 문자열의 길이 계산
        if(str.equals("")) {
            return 0;
        }
        else {
            return 1+ length(str.substring(1));
        }
    }

    // String.charAt(i) : 문자열의 i번째를 char타입으로 반환.
    public static void printChars(String str) {
        if (str.length() == 0) {
            return;
        }
        else {
            System.out.println(str.charAt(0));
            printChars(str.substring(1)); // str의 길이만큼 함수순환.
        }
    }

    public static void printCharReverse(String str) {
        if (str.equals("")) {
            return;
        }else {
            printCharReverse(str.substring(1));
            System.out.print(str.charAt(0));
        }
    }
    // func(3) >> func(2)+A >> func(1)+B + A >> func(0)+C + B + A
    // func(0) == null(공백)
    // (재귀함수 + 값)의 형태로 값을 역출력할수있다. ㄷㄷ (값 + 재귀함수) 는 정방향

    public static void printInBinary(int n) {
        if (n<2) {
            System.out.print(n); // 몫도 나누다가 n<2가 될 때 이진법의 마지막 값으로..
        }else {
            printInBinary(n/2);
            System.out.print(n%2);

        }
    }

    // 배열의 합.
    public static int sum(int n, int [] data) { // data[0] ~ data[n-1]까지의 합을 구하여 반환.
        if (n<=0) {
            return 0;
        }else{
            return data[n-1] + sum(n-1, data);
        }
    }

    // Scanner in이 참조하는 파일로부터 n개의 정수를 입력받아 배열 data의 data[0] ~ data[n-1]로 저장한다.
    public static void readFrom(int n, int [] data, Scanner in) {
        if(n == 0)
            return;
        else {
            readFrom(n-1, data, in);
            data[n-1] = in.nextInt(); // 가장 마지막에 저장되어야 하니까. 재귀함수를 앞쪽에.
        }
    }
    // recursion이 iteration보다 실행속도면에서 손해를 보지만,
    // 복잡하고 지저분하게 표현되는 알고리즘도 알기쉽게 표현하는 것을 가능하게 한다.

}
