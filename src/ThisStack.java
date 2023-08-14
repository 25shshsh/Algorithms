
import java.util.Stack;

public class ThisStack {
    public static int solution(String s) {
        String[] strArr = s.split(""); //문자열 배열로 변환
        Stack<String> stack = new Stack<>(); // 스택선언
        for (String str : strArr) { // 배열에서 인덱스 하나씩 뽑음.
            if(stack.isEmpty()) {
                stack.push(str);
                continue;
            }
            if (stack.peek().equals(str)) { // 스택에서  현재 문자가 같다면? >> 스택에서 제거
                stack.pop();
                continue;
            }
            stack.push(str); // 스택에 배열요소 삽입
        }

        if(stack.size() == 0) {
            return 1;
        }
        return 0;
    }



    public static void main(String[] args) { // b aa baa >> bbaa >> bb aa >> aa >> ""
        String str = "baabaa";
        String str2 = "aabbcc";
        String str3 = "abccb";
        System.out.println(solution(str));

    }
}

