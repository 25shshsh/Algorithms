package recursion;

public class Code2_2_CountingBlob {
    private static int [][] grid = {
            {1, 0, 0, 0, 0, 0, 0, 1},
            {0, 1, 1, 0, 0, 1, 0, 0},
            {1, 1, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 1, 0, 1, 0, 1, 0, 0},
            {0, 1, 0, 1, 0, 1, 0, 0},
            {1, 0, 0, 0, 1, 0, 0, 1},
            {0, 1, 1, 0, 0, 1, 1, 1},
    };
    private static int N = 8;
    private static int count = 0;
    private static int baseColor = 1; // 기존색상은 1이다.
    private static int countingColor = 2; // 인접한 1의 중복카운트를 방지하기위해

    // blob : 8방향안에 서로 인접한 픽셀들의 집합

    /* 입력 : N*N 크기의 2차원 그리드
             하나의 좌표 (x,y)
       출력 : 픽셀 (x,y)가 포함된 Blob의 크기
             (x,y)가 어떤 Blob에도 속하지 않은 경우에는 0 */
    public static void main(String[] args) {
        countCells(7,1);
        printCount();
    }

    /* 접근방법 : 입력받은 픽셀이 속한 blob의 크기를 카운트하려면?

    현재 픽셀이 image color가 아니라면? -> 0을 반환한다.
    현재 픽셀이 image color라면?
        먼저 현재 픽셀을 카운트한다. (count=1)
        현재 픽셀이 중복카운트 되는 것을 막기위해 다른 색으로 칠한다.
        현재 픽셀에 이웃 모든 픽셀에 대해서
            그 픽셀이 속한 blob의 크기를 count에 더해준다.
        count를 반환한다.
     */

    public static boolean countCells(int x, int y) { // (3,5)
        if (x >= N || y >= N || x < 0 || y < 0) {
            return false; // x,y 범위 설정
        }

        if (grid[x][y] != baseColor) { // 빈 공간을 했다면 카운팅 없음(첫 선택이든, 나중 선택이든)
            return false;
        }else {
            count += 1; // 선택한 픽셀이 1이라면 카운트+1
            grid[x][y] = countingColor; // 재귀함수 중복카운트 방지를 위해 컬러1 -> 컬러2
        }

        // 땅 파는 짓 시작. (여기서는 땅을 메꿀 필요가 있나? 없다. 미로찾기처럼 다시 표시하면서 처음 위치로 돌아올 필요가 없다.)
        if(countCells(x,y-1) || countCells(x+1,y-1)
                || countCells(x+1,y) || countCells(x+1,y+1)
                || countCells(x,y+1) || countCells(x-1,y+1)
                || countCells(x-1,y) || countCells(x-1,y-1)){
            return true;
        } else {
            return false; // 인접한 유효 셀이 없을때.
        }
    }

    public static void printCount() {
        System.out.println("size : " + count);
        System.out.println("===============");

        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("===============");
    }
}
