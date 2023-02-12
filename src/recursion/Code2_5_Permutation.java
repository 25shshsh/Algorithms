package recursion;

import java.util.stream.IntStream;

// 백트래킹 기법과 깊이 우선 탐색
public class Code2_5_Permutation { // f(1)이 참이고, f(1+1)이 참이라면 자연수n f(n)은 참이다.(믿어야한다.)
    private static char [] data = {'a','b','c','d'};
    private static final int n = data.length;
    public static void main(String[] args) {
        permutation(0);
    }
    static void swap(char [] data, int i, int j) {
        char tmp;
        tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    static void permutation(int depth) {
        if(depth == n) {
            IntStream.rangeClosed(0,n-1).forEach(i -> {
                System.out.print(data[i] + " ");
            });
            System.out.println();
        }

        // 상태공간트리를 머릿속에 그려보자. {a,b,c}일때
        IntStream.rangeClosed(depth,n-1).forEach(i ->{
            swap(data,depth,i); // depth가 0일때 i는 n-1번 반복 >> 1번째 자리에 a or b or c가 들어갈수있다. (3개의 경우로 트리가 갈라짐.)

            permutation(depth+1); // <= basecase에 수렴하는 조건
            // 1번째 자리에 각각 a,b,c가 선택되어서. 2번째 자리에는 bc, ac, ab 3개의 트리가 2개의 원소 중 1개를 각각 선택(트리가 2개의 경우로 또 갈라짐)
            // 2번째 자리에 각각 b,a,a가 선택되어서. 3번째 자리에는 c, c, b 3개의 트리가 2개의 원소 중 1개를 각각 선택
            // 3번째 자리에 각각 c,c,b가 선택되어서. aab bac cab 로 완료.

            swap(data,depth,i); // 깊이우선탐색으로 끝까지 탐색하였다면, 다시 탐색한 횟수만큼 되짚어서 돌아간다. (ab스왑 -> ab스왑 = 원상복구)
            // func(n) = func(n-1) + swap()이라면,  func함수가 n번 실행된 후 뒤이어 swap함수가 n-1번 실행된다.
        });
    }
    // 그리고, 멱집합과 다르게 반복문+재귀를 쓴 이유는 원소가 n개라면 n번만큼 재귀를 실행해야하기 때문이다.
    // 멱집합의 경우는 true false로 갈리면서 깊이탐색이라 재귀를 항상 2번 실행하기 때문에 따로 반복문을 사용할 필요는 없다.

}
