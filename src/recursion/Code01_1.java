package recursion;

public class Code01_1 {
    public static void main(String[] args) {
        int result = func(4);
        System.out.println(result);
        System.out.println(factorial(4));

        for(int i = 0; i <= 5; i++){
            System.out.print(fibonacci(i) + " ");
            if (i == 5) {
                System.out.println();
            }
        }
        System.out.println(gcd(3,12));
        System.out.println(gcd(13,7));
        System.out.println(gcd2(3,12));
        System.out.println(gcd2(18,6));
        System.out.println(gcd2(18,0)); // 18과 0의 최대공약수 18₩
    }
    public static int func(int n) {
        if(n <= 0) {
            return 0;
        }else {
            System.out.println("recursion");
            return n+func(n-1);
        }
    }

    // n! = n*(n-1)!
    // 4! = 4*3! = 4*3*2! = 4*3*2*1! = 4*3*2*1*0!
    // 0! = 1.
    public static int factorial(int n) {
        if(n == 0) {
            return 1;
        }else {
            return n * factorial(n-1);
        }
    }

    public static int fibonacci(int n) {
        if (n < 2) {
            return n;
        }else{
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

    // m>=n인 두 양의 정수가 존재, m이 n의 배수라 gcd(m, n) = n이고,
    // 그렇지 않으면 gcd(m,n) = gcd(n, m%n)이다.
    public static int gcd(int m, int n) { // Greatest Common Divisor. 최대공약수.
        if(m < n) { // 치환
            int temp = m; m = n; n = temp; // swap m and n
        }
        if(m % n == 0) {
            return n;
        }else {
            return gcd(n, m%n);
        }
    }
    public static int gcd2(int p, int q) { // gcd 단순한버전.
        if(q == 0) {
            return p;
            // 0에는 어떤수를 곱해도 0이기 때문에 100과 0 * 100의 최대공약수는 100이다.
        }
        else{
            return gcd2(q, p%q);
        }
    }

}
