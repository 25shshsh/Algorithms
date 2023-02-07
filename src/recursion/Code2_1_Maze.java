package recursion;

public class Code2_1_Maze {
    // 미로찾기 (decision problem ox문제)
    private static int N=8; // 미로의 크기
    private static int [][] maze = {
            {0, 0, 0, 0, 0, 0, 0, 1},
            {0, 1, 1, 0, 1, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 1, 0, 0, 1, 1, 0, 0},
            {0, 1, 1, 1, 0, 0, 1, 1},
            {0, 1, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0, 1, 0, 0},
    };
    private static final int PATHWAY_COLOR = 0; // white 이동가능한 셀
    private static final int WALL_COLOR = 1; // blue 벽
    private static final int BLOCKED_COLOR = 2; // red 막혀있다고 밝혀진 셀 (이미 실패했던 경로)
    private static final int PATH_COLOR = 3; // green 출구로 가는 경로가 될 가능성이 아직 있는 셀
    public static void main(String[] args) {
        printMaze();
        findMazePath(0,0);
        printMaze();
    }


    /*  1. 범위 내의 좌표만 유효하다.
        2. 방문하지 않은 좌표(0)만 유효하며 1,2,3일 경우 유효하지 않다.
        3. 출구라면 현재위치를 3으로 바꾼 후 종료
        4. 범위 내 좌표, 방문하지 않은 PATHWAY_COLOR(0) 그리고 출구가 아닌 경우 일단 0을 3으로 칠한다.

           현재 좌표에서 동서남북방향으로 위의 로직을 반복실행...
           결국 막혔다면? >> 막힌 부분부터 3을 2로 칠하면서 처음으로 돌아온다. (인접 0이 없고 사방에 1,2,3만 있다면 2를 칠하면서 돌아오면 됌)
           왜? func(2) = func(1)+A, func(1)= func(0)+B라면 func(2) = func(0) + B + A 이기 때문이다.
           (땅을 깊이 팠다가 땅을 메우면서 다시 지상으로 올라오는 느낌)
    */
    public static boolean findMazePath(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N) { // x,y좌표의 유효한 범위 설정
            return false;
        } else if (maze[x][y] != PATHWAY_COLOR) { // 방문했다면(red,green), 벽인경우(blue)
            return false;
        } else if (x == N - 1 && y == N - 1) { // 만약 출구라면 (maze[7][7]이 출구)
            maze[x][y] = PATH_COLOR; // 3
            return true;
        } else { //
            maze[x][y] = PATH_COLOR;  // 3
            if(findMazePath(x-1,y) || findMazePath(x,y+1) // 현재위치에서 4방향에 인접하고 유효한 셀이 하나라도 있을 경우 (땅을 파러 간다.)
                    || findMazePath(x+1, y) || findMazePath(x,y-1)) {
                return true;
            }else {
                maze[x][y] = BLOCKED_COLOR;
                return false;
            }
            // 인접한 셀이 없거나 인접한 셀이 출구가 아닐 모든 경우 (땅을 메우면서 다시 돌아와야한다.)
            // 수없이 위의 if문 반복 후 결국 인접한 셀이 없게 되는경우 전부 누적되서 0 -> 2로 바뀐다. (뒤에 쌓이는 조건 fun(1) + A >> func(0) + B + A 이런식)

        }
    }

    public static void printMaze() {
        System.out.print("\n===============");
        for (int i = 0; i < N; i++) {
            System.out.println();
            for (int j = 0; j < N; j++) {
                System.out.print(maze[i][j] + " ");
            }
        }
        System.out.println("\n===============");
    }
}
