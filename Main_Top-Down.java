import java.util.*;

public class Main {
    static int[] A; // 해당 인덱스 개수의 카드를 구매하는 최대 금액
    static int[] P; // 인덱스 개수의 카드를 포함하는 카드팩의 가격
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cardNum = sc.nextInt();
        P = new int[cardNum+1];
        A = new int[cardNum+1];
        for (int i=1;i<cardNum+1;i++) {
            P[i] = sc.nextInt(); // 각 카드 팩의 가격 받아오기
        }
        System.out.println(maxPrice(cardNum));
    }

    static int maxPrice(int num) {
        // Top-Down 방식
        // A[n] = n개의 카드를 구매하는 최대 금액, P[i] = i개의 카드를 포함하는 카드팩의 가격
        // 점화식 : A[n] = max(A[n-1] + p[i])
        if (num < 1) {
            return A[num];
        }
        if (A[num-1] == 0) {
            A[num-1] = maxPrice(num-1);
        }
        for (int i=1;i<num+1;i++) {
            if (A[num] < A[num-i] + P[i]) {
                A[num] = A[num-i] + P[i];
            }
        }
        return A[num];
    }
}
