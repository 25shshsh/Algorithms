import java.util.Scanner;

public class 제비뽑기 {
    public static void main(String[] args) {


        int sum = 0;
        int value = 0;
        System.out.println("N개의 제비를 뽑고, 뒤집는다. 그리고 제비를 4번 확인하여. k가 될 수 있는 확률이 있다면 승리.");

        Scanner sc = new Scanner(System.in);
        System.out.print("제비를 N개 뽑으시겠습니까? >> ");
        int n = sc.nextInt(); // 제비갯수이자 배열이 되야겠지
        int[] array = new int[n];

        System.out.print("제비를 4번 확인하여 뽑고싶은 숫자는 ? >> ");
        int k = sc.nextInt(); //


        System.out.print("\n당신이 가지고 있는 제비의 숫자는 ");
        for (int i = 0; i < n; i++) {
            do{
                value = (int)((Math.random() * 9 + 1)); // 0~8 +1 >> 1~9 제비갯수를 9개 이상 쓰면 무한루프다.
            }
            //array[i] =  randomInt;// 배열의 크기
            while (exists(array, value));
            array[i] = value;
            if (i == n - 1) {
                System.out.println(array[i] + " 입니다.");
            } else {
                System.out.print(array[i] + ", ");
            }
        }

        System.out.println("그리고 뽑고 싶은 숫자는 " + k + " 입니다.");


        for (int i = 0; i < 4; i++) {
            int temp = (int) ((Math.random() * (n))); // 배열의 인덱스
            sum += array[temp];
            System.out.print(temp);
        }

        System.out.println("\n" + sum);
        if (sum == k) {
            System.out.println("승리");
            System.out.println("뽑고싶은 숫자는 " + k + "이며, 뽑은 숫자는 " + sum + "입니다.");
        } else {
            System.out.println("패배");
            System.out.println("뽑고싶은 숫자는 " + k + "이며, 뽑은 숫자는 " + sum + "입니다.");
        }


    }

    // 랜덤 value를 넣을 때마다 배열의 크기만큼 기존 배열 값과 value를 비교한다.
    // 같을 경우 true는 while문을 활용하여 중복을 다 없애버리라는 말임.
    private static boolean exists(int[] array, int value) { // 배열, 검사용
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value)
                return true;
        }
        return false;
    }

}