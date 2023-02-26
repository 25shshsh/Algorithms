package solve;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.IntStream;
// https://leetcode.com/problems/ipo/
public class Leetcode502 {
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
        } // 오름차순 자본으로 정렬.
        // 필요자본이 늘어날수록 이익도 비례적으로 늘어날테니까.

    }
    public static void main(String[] args) {
        System.out.println(findMaximizedCapital(k,w,capital,profits));
    }



    public static int findMaximizedCapital(int k, int w, int[] capital, int[] profits) {
        int n = profits.length; // 배열의 길이를 불러올 때마다 계산하기보다, 변수에 넣어서 시간복잡도를 줄이자.

        Project[] projects = new Project[n];

        for(int i = 0; i < n; i++) {
            projects[i] = new Project(capital[i],profits[i]);
        }
        Arrays.sort(projects);

        // PriorityQueue의 default는 min heap이다.
        // but we need a max heap, so we use Collections.reverseOrder()
        // ** 우선순위 큐는 들어간 순서에 상관없이 우선순위가 높은 데이터가 먼저 나온다. 여기서는 최댓값 우선순위큐
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(n, Collections.reverseOrder()); // (capacity,comparator)

        int ptr = 0;

        // 필요자본이 0 ~ 현재자본까지인 Project들을 중 가장 이익이 큰 프로젝트 하나만 큐에 추가. ( reverseOrder덕분)
        // 만약 수주할 수 있는 프로젝트가 없었다면 break, 있었다면 큐에서 값을 빼내고 그 값을 현재자본에 누적.
        // 그리고 프로젝트 수주횟수는 하나 감소.

        // >> 여기서의 대부분의 기능은 원하는 변수의 최댓값을 우선순위로 찾고 추가하는 PriorityQueue 덕분이다.
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
