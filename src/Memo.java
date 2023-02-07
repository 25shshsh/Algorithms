public class Memo {
    public static void main(String[] args) {
        perm(0);
    }
    static char [] data = {'a', 'b', 'c', 'd'};
    static int n = 4; // n은 배열의 길이
    static void perm(int depth) { // k는 시작깊이
        if(depth == n) {
            for(int i = 0; i < n; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }else {
            for(int i = depth; i < n; i++) {
                swap(data,depth,i);
                perm(depth+1);
                swap(data,depth,i);
            }

        }
    }

    static void swap (char [] data, int depth, int i) {
        char temp;
        temp = data[i];
        data[i] = data[depth];
        data[depth] = temp;
    }


}
