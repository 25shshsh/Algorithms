import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution {
// 입력: k = 3, w = 0, 이익 = [1,2,3], 자본 = [0,1,2]
// 출력: 6

    static int k = 1; // 프로젝트 선택 횟수
    static int w = 1; // 현재자본
    static int [] profits = {1,1,1,1,100}; // 프로젝트 이익
    static int [] capital = {1,1,1,1,1}; // 프로젝트 제한 자본

    static class Project implements Comparable<Project> {
        int capital, profit;

        public Project(int capital, int profit) { // 순서 잘 보자.
            this.capital = capital;
            this.profit = profit;
        }

        public int compareTo(Project project) {
            return capital - project.capital;
        }

    }
    public static void main(String[] args) {
        System.out.println(findMaximizedCapital(k,w,capital,profits));
    }



    public static int findMaximizedCapital(int k, int w, int[] capital, int[] profits) {
        int n = profits.length;

        Project[] projects = new Project[n];

        for(int i = 0; i < n; i++) {
            projects[i] = new Project(capital[i],profits[i]);
        }
        Arrays.sort(projects);

        // PriorityQueue의 default는 min heap이다.
        // but we need a max heap, so we use Collections.reverseOrder()
        // ** 우선순위 큐는 들어간 순서에 상관없이 우선순위가 높은 데이터가 먼저 나온다. 여기서는 최댓값 우선순위큐
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(n, Collections.reverseOrder());

        int ptr = 0;
        
        // 수주가능한 프로젝트가 남아있고, 내 자본보다 같거나 적은 자본을 필요로 하는 가능한 프로젝트가 있다면
        // 그 프로젝트의 이익을 우선순위 큐에 넣는다. (반복)
        // 그러나 큐가 비었다면 가능한 프로젝트가 없으므로 종료.
        for (int i = 0; i < k; i++) {
            while (ptr < n && projects[ptr].capital <= w) { //projects[ptr].capital 오름차순 정렬
                queue.add(projects[ptr++].profit);
            }
            if (queue.isEmpty()) {
                break;
            }
            // poll() : 맨 앞에 있는 요소를 반환하고 제거
            w += queue.poll();

            // >> 현재 조건에서 다 빨아먹을 수 있는 것들을 다 흡입하고 최댓값 하나뱉고 (반복)
            // 프로젝트 수주가능 횟수만큼 반복하지만, 횟수가 남아있어도 수주가능한 프로젝트가 없다면(큐가 비었다면) 종료.
        }


        return w;
    }

    static void printArr (Project [] array) {
        IntStream.rangeClosed(0,profits.length-1).forEach(i -> {
            System.out.println(array[i].capital + "," + array[i].profit + " ");
        });
    }
}
