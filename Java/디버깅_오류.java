import java.util.Scanner;
public class 디버깅_오류 {
    public static void main(String[] args){
        //TODO 배열에서 주어진 범위의 합을 구하는 프로그램을 구하시오.
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        int answer = 0;
        int A[] = new int[100001];
        int S[] = new int[100001];
        for (int i = 1; i < 10000; i++){
            A[i] = (int)(Math.random()*Integer.MAX_VALUE); //Integer.MAX_VALUE은 정수의 최댓값
            S[i] = S[i-1]+A[i];
        }
        for (int t =1; t < testCase; t++){
            int query = sc.nextInt();
            for(int i =0; i < query; i++){
                int start = sc.nextInt();
                int end = sc.nextInt();
                answer += S[end] - S[start -1];
                System.out.println(testCase + " "+answer);
            }
        }

    }
}
