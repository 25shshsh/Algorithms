import java.util.Arrays;
import java.util.stream.IntStream;

public class asd {
    private static int[] data = {7,6,3,2,1,8,4,5};

    public static void main(String[] args) {
        int n = 4;
        while(n > 0) {
            if(n > 4) {
                // 무한..
            }else {
                System.out.println(n--);
            }
        }

    }

    static void printArr (int [] array) {
        IntStream.rangeClosed(0,array.length-1).forEach(i -> {
            System.out.print(array[i] + " ");
        });
        System.out.println();
    }
}
