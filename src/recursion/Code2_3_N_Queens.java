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
            return false; // 현재노드가 꽝인 위치라면 되돌아가기 위해 false.
        }
        else if (level == N) { // 꽝이 아닌 위치에 퀸을 N개 전부 놓았다면 정답 리턴.
            for (int i = 1; i <= N; i++) { // i=1부터인 이유 >> 단순히 0부터가 아닌 1부터 시작하고 싶어서 ( 0은 안씀)
                System.out.println("(" + i + "," + cols[i] + ")");
            }
            return true; // 현재노드가 꽝이 아닐 경우 or 퀸을 다 채운 경우
        }

        for (int i = 1; i<= N; i++) { // 현재노드가 꽝의 위치도 아니고, 정답의 조건도 만족하지 못한다면. 현재노드의 하위노드(1~N까지의)를 순차적으로 탐색해봐야한다.
            cols[level+1] = i;
            // level+1의 깊이 노드에서 1번째부터 N번째까지 -> queens() 함수 호출하여 -> 1~N번째까지 꽝인지 아닌지 순차탐색.
            if(queens(level+1)) { // queens(level+1) 가 true라면 level+1번째의 퀸의 위치도 true가 되는 것.
                return true;
            }
        }
            return false; // 완전 불가능이면 false;
    }

    public static boolean promising(int level) { // 꽝인지 아닌지 판별
        for (int i = 1; i < level; i++) { // 1 ~ level-1까지와 level을 비교해주면 된다. (1 ~ level-1은 충돌없음이 보장되어 있음)
            if (cols[i] ==cols[level]) { // 체스판을 2차원배열이라고 생각했을때, 같은y선상에 위치되면 안된다. ex) [0,3] [1,3] [2,3]
                return false;
            }
            else if (level-i == Math.abs(cols[level] - cols[i])) { // *** 각 퀸의 대각선 유효범위 안에 새로운 친구(level)가 위치되어있는지?
                return false; // 기존 퀸들의 대각선이동범위에 새로운 level이 포함된다면 꽝.
            }
        }
        return true; // 퀸의 영역을 벗어난 위치에(조건을 만족하는) 새로운 퀸이 들어왔다.
    }


/*    public static void gridPrint() {

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid.length; j++) {
                System.out.print(grid[i][j] + "");
            }
            System.out.println();
        }
    }*/
}
