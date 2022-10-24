import java.util.Scanner;

public class 동적계획법_P2747_피보나치수열_BottomUp {
    static int D[];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        D = new int[N+1];
        for (int i = 0; i<=N; i++){
            D[i] =-1;
        }
        D[0] = 0;
        D[1] = 1;
        for( int  i = 2; i <=N;i++){
            D[i] = D[i-2]+ D[i-1];
        }
        System.out.println(D[N]);
    }
}
