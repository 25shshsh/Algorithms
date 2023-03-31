// https://school.programmers.co.kr/learn/courses/30/lessons/12951
public class Solution {
    public static int solution(int n) {
        int even = 0;
        int odd = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                even = (even + odd) % 1234567;
                continue;
            }
            odd = (even + odd) % 1234567;
        }
        return n % 2 == 0 ? even : odd;
    }

    public static void main(String[] args) {
        solution(5);
    }

}
