package recursion;

public class Code2_3_N_Queens {
    // backtracking 기법: 가장 최근에 내렸던 결정을 번복하고 다른선택을 하는 것, 깊이 우선 탐색 방식 O(2^N)
    // recursion or stack으로 구현한다.
    // 상태공간트리 : 찾는 해를 포함하는 트리 (모든 노드를 탐색할 필요x)

    public static int N = 5; // 필요한 퀸의 갯수, N = cols.length -1
    public static int[] cols = new int[N+1];  // cols[0]은 사용하지 않을 것. N =5 일때 1,2,3,4,5사용
    // 1차원 배열로 받아도 된다. 무슨말이냐면 각 원소의 index를 '열'이라 생각하고, 원소 값을 '행'이라 생각하는 것이다.


    public static void main(String[] args) {
        queens(0);
    }
    public static boolean queens(int level) { // 처음에는 queens(0)을 호출한다.
        if (!promising(level)) {
            return false; // 백트래킹을 위함.
        }
        else if (level == N) { // 꽝이 아닌 위치에 퀸을 N개 전부 놓았다면 정답 리턴. (basecase)
            for (int i = 1; i <= N; i++) { // i=1부터인 이유 >> 단순히 0부터가 아닌 1부터 시작하고 싶어서 ( 0은 안씀)
                System.out.println("(" + i + "," + cols[i] + ")");
            }
            return true; // 현재노드가 꽝이 아닐 경우 or 퀸을 다 채운 경우
        }

        for (int i = 1; i<= N; i++) { // 조건을 뚫고 퀸을 놓았지만 level == n 을 만족하지 못한 경우 >> 1 ~ n까지 순차탐색해보자.
            cols[level+1] = i; // 한 level마다 1~n까지의 수를 넣고 조건에 부합되는지 promising함수 반복 (이중for문과 동일함)

            if(queens(level+1)) { // (recursion)
                return true; // queens(level+1) 가 true라면 level+1번째의 퀸의 위치도 true가 되는 것.
            }
        }
            return false; // 완전 불가능이면 false;
    }

    static boolean promising(int level) { // 백트래킹을 위한 조건.
        // 0. 1~level-1은 이미 충돌하지 않는다는 보장이 되어있다. 따라서 1~level-1 과 level을 비교.
        // 1. 1~level-1까지와 level을 비교하여 같은 값이 아니여야한다. (가로세로가 같은축)
        // 2. 1~level-1과 level의 깊이차이와 값 차이가 같으면 안된다. (대각선이 같은축)
        for(int i = 1; i < level; i++) {
            if(cols[i] == cols[level]) {
                return false;
            } else if (level-i == Math.abs(cols[level] - cols[i])) {
                return false;
                // 2-1 (level, 위치) 일때, (1,1) (3,3) level은 2칸차이 그리고 위치도 3-1 2칸차이 => 기존1의 대각선 유효범위 내에 3이 존재
                // 2-2 (level, 위치) 일때, (1,2) (3,3) level은 2칸차이 그리고 위치는 3-2 1칸차이 => 기존1의 대각선 유효범위 내에 3이 없음
            }
        }
        return true; // 중복되지 않는 위치라면 조건부합완료
    }
}
