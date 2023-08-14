package MST;

import java.util.*;

public class PrimAlgorithm {
    public static void main(String[] args) {
        int[][] graph = {{0, 2, 0, 6, 0}, // 무방향그래프, 인접행렬
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}};
        prim(graph, 0);
    }

    public static void prim(int[][] graph, int start) {
        int n = graph.length; // 정점의 개수
        boolean[] visited = new boolean[n]; // 방문한 정점을 저장하는 배열
        PriorityQueue<Edge> pq = new PriorityQueue<>(); // 간선을 저장하는 우선순위 큐

        // 시작 정점과 연결된 간선을 큐에 추가
        visited[start] = true;
        for (int i = 0; i < n; i++) {
            if (graph[start][i] != 0) {
                pq.offer(new Edge(start, i, graph[start][i]));
            }
        }

        int weight = 0; // 최소 신장 트리의 가중치 합
        while (!pq.isEmpty()) {
            Edge edge = pq.poll(); // 가장 작은 가중치를 가진 간선을 꺼냄
            int u = edge.u;
            int v = edge.v;
            int w = edge.weight;

            // u, v 중 방문하지 않은 정점을 방문하고 간선을 추가
            if (!visited[u] || !visited[v]) {
                visited[u] = true;
                visited[v] = true;
                weight += w;
                System.out.println(u + " - " + v + ": " + w);

                // u, v 중 방문하지 않은 정점과 연결된 간선을 큐에 추가
                int next = visited[u] ? v : u;
                for (int i = 0; i < n; i++) {
                    if (graph[next][i] != 0 && !visited[i]) {
                        pq.offer(new Edge(next, i, graph[next][i]));
                    }
                }
            }
        }

        System.out.println("Weight of MST: " + weight);
    }

    // 간선을 표현하는 클래스
    static class Edge implements Comparable<Edge> {
        int u;
        int v;
        int weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }
}
