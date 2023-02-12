package recursion;

import java.util.stream.IntStream;

public class Code2_4_PowerSet { // ex in 양갈래 무한루프 K == n까지
    // S의 멱집합을 구한 후 ,각각의 집합 p를 합집합하여 출력.
    // 원소가 N개라면 ox퀴즈 N번하는 상태공간트리를 연상해보자. (N = depth)
    private static char[] data = {'a', 'b', 'c'};
    private static boolean[] include = new boolean[data.length];

    public static void main(String[] args) {
        powerSet(0);
    }

    static void powerSet(int k) { // k는 트리의 depth
        if (k == data.length) { // 배열초과, 현재위치가 리프노드라면 basecase
            IntStream.rangeClosed(0, data.length - 1).forEach(i -> {
                if (include[i] == true) {
                    System.out.print(data[i] + " "); // 원소가 3개일경우 여기로 오는 경우는 8갈래겠네.
                }
            });
            System.out.println();
            return;
        }
        // 리프노드(k==data.length)까지 2갈래 4갈래 8갈래.. 계속해서 재귀호출
        include[k] = false; // 왼쪽갈래로 내려갔다가
        powerSet(k + 1);
        include[k] = true; // 왼쪽갈래로 오른쪽 갈래로도 내려가보고
        powerSet(k + 1); // 내려갔으니 depth + 1


    }
}









