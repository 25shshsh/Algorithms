package recursion;

// 백트래킹 기법과 깊이 우선 탐색
public class Code2_5_Permutation { // f(1)이 참이고, f(1+1)이 참이라면 자연수n f(n)은 참이다.(믿어야한다.)
    // 순열 : 모든 경우의 수를 카운트, 원소가 4개라면 4!이다.

    private static char data[] = {'a', 'b', 'c'};
    private static int n = 3; // n은배열의 길이. k는 깊이

    public static void main(String[] args) {
        perm(0); // 0번째부터 순열시작.
    }

    static void perm(int depth) {
        if (depth == n) { // 리프노드에 도달할 경우 출력.
            for (int i = 0; i < n; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }
        for (int i = depth; i < n; i++){ // depth <= i <= n-1
            swap(data, depth, i);
            perm(depth+1);
            swap(data, depth, i); // 리프노드에 도달할 경우 출력 >> 깊이탐색 횟수만큼 다시 역스왑.
        }
    }
    // (depth, i) 00 11, 00 12, 01 11, 01 12, 02 11, 02 12
    // depth는 깊이에 따라 고정, i는 depth와 같은 크기에서 n-1까지

    static void swap(char [] data, int depth, int i) {
        char temp = data[depth];
        data[depth] = data[i];
        data[i] = temp;
    }



}
