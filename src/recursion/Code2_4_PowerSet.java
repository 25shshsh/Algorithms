package recursion;

public class Code2_4_PowerSet { // ex in 양갈래 무한루프 K == n까지
    // 멱집합 : 주어진 집합의 모든 부분집합의 집합.
    // 집합의 원소가 N개일때 부분집합은 2^N개이다. (공집합 포함)
    // 상태공간트리 : 해를 찾기 위해 탐색할 필요가 있는 모든 후보들을 포함하는 트리(2-3에도 나옴)


/*  집합 {1,2,3,4}의 멱집합은 >> {2,3,4}의 멱집합 그리고, {2,3,4}의 멱집합에 {1}을 각각더한 멱집합의 합이다.
    {2,3,4}의 멱집합에 {1}을 각각더한 멱집합의 합은 >> {3,4}의 멱집합에 [{1}, {1,2}]을 각각더한 멱집합의 합이다.*/


    // data[k] ~ data[n-1]의 멱집합을 구한 후, 각각의 include[i]=true, i=0, ... ,k-1, 인 원소를 추가하여 출력하라.
    // 처음 이 함수를 호출할 때 powerSet(0)으로 호출한다. p는 공집합이고, S는 전체집합이다.
    private static char data[] = {'a', 'b', 'c'}; //, 'd', 'e', 'f'
    private static int n = data.length;
    private  static boolean [] include = new boolean[n];

    // data에서 처음 ~ k-1번째까지 원소. and include[E] = true인 경우 P집합에 속한다.
    // data에서 k번째 ~ 끝(n-1)까지가 집합 S에 속한다.
    public static void powerSet(int k) {
        if(k==n) { // k == n이 되었을때
            for (int i= 0; i<n; i++) {
                if(include[i] == true) { // p집합 중 true인 친구들 모두 출력.
                    System.out.print(data[i] + " ");
                }
            }
            System.out.println();
            return;
        }
        // 상태공간트리 노드를 ex in으로 반복하여 쪼개는 작업. (동시에 분화)
        include[k] = false; // data[k]를 포함하지 않는 부분집합들을 출력
        powerSet(k+1);
        include[k] = true;  // data[k]를 포함하는 부분집합들을 출력
        powerSet(k+1);
        // ex) ex a > ex b > ex c = {}, ex a > in b > ex c = {b} ㅋㅋㅋ
        // 원소가 N개라면 k==n일때 2^N개의 for문이 동작...
    }
    // ** basecase가 될 때까지 상태공간트리를 탐색가능한 노드로 쪼개고, 위 basebase가 될 시 배열에 지금까지 저장되어 있던 친구들을 출력.

    public static void main(String[] args) {
        powerSet(0);
    }





}
