import java.util.Scanner;

public class DP_P1463_정수연산 {
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        int N = sc.nextInt();
        /*
//        int count = 0;
//        while (N >1){
//            if( N % 3 == 0){
//                N = N/3;
//                count++;
//            } else if ( N % 2 == 0) {
//                N = N/2;
//                count++;
//            }else{
//                N = N-1;
//                count++;
//            }
//        }
//        System.out.println(count);
         */
        int D [] = new int[N+1];                            //1로 만드는 데 걸리는 최소 연산 횟수
        D[1] = 0;                                           //1일 때 연산 불필요
        for (int i = 2; i<= N;i++){
            D[i] = D[i-1] +1;                               //-1 연산 표현
            if( i % 2 == 0)
                D[i] = Math.min(D[i], D[i/2] +1);           //나누기 2 연산
            if( i % 3 == 0)
                D[i] = Math.min(D[i], D[i/3] +1);           //나누기 3 연산
        }
        System.out.println(D[N]);
    }
}
