public class 보이드함수_빠져나오기 {

    private static int a = 5;

    public static void main(String[] args) {
        recursion(5);
    }

    static void recursion(int a) {
        if(a < 3) {
            return;
        }
        System.out.println(a);
        recursion(a-1);

    }
}
