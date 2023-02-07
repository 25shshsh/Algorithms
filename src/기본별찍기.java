public class 기본별찍기 {
    public static void main(String[] args) {

        int n = 5;
        String [] arr = {"*", "*", "*", "*", "*"};


        for(int i = n; i > 0; i--) { // 54321 (i의값 변화)
            for (int j = 0; j < n-i+1 ; j++) { // 5-5+1 = 1번 반복, 5-4+1 = 2번 반복 ... (j의 반복횟수 변화)
                System.out.print(arr[j]);
            }
            System.out.println();
        }
    }
}
