import java.util.stream.IntStream;

public class asd {

    private static int n = 5;// 상태공간트리의 깊이 (level)
    private static int [] data = new int[n+1];

    public static void main(String[] args) {
        nQueens(0);
    }

    static boolean nQueens(int level) {
        if(!promising(level)) { // 조건에 부합되지 않는다면 (backtracking)
            return false;
        } else if (level == n) { // 모든 조건을 뚫고 완료되었다면 (basecase)
            IntStream.rangeClosed(1,n).forEach(i -> {
                System.out.println(i +", "+ data[i]);
            });
            return true; // 종료조건 완료했다면 종료시켜줘라.
        }
        // 조건을 뚫고 퀸을 놓았지만 level == n 을 만족하지 못한 경우 >> 1 ~ n까지 순차탐색해보자.
        for(int i = 1; i <= n; i++) {
            data[level+1] = i; // 한 level마다 1~n까지의 수를 넣고 조건에 부합되는지 promising함수 반복 (이중for문과 동일함)
            if(nQueens(level+1)) { // recursion
                return true; // data[level+1]도 성공적으로 안착이다.
            }
        }
        return false; // 아예 불가능하면 종료.
    }

    static boolean promising(int level) {
        // 1. 1~level-1까지와 level을 비교하여 같은 값이 아니여야한다. (가로세로가 같은축)
        // 2. 1~level-1과 level의 깊이차이와 값 차이가 같으면 안된다. (대각선이 같은축)
        for(int i = 1; i < level; i++) {
            if(data[i] == data[level]) {
                return false;
            } else if (level-i == Math.abs(data[level] - data[i])) {
                return false;
                // 2-1 (level, 위치) 일때, (1,1) (3,3) level은 2칸차이 그리고 위치도 3-1 2칸차이 => 기존1의 대각선 유효범위 내에 3이 존재
                // 2-2 (level, 위치) 일때, (1,2) (3,3) level은 2칸차이 그리고 위치는 3-2 1칸차이 => 기존1의 대각선 유효범위 내에 3이 없음
            }
        }
        return true; // 중복되지 않는 위치라면 조건부합완료
    }
}
