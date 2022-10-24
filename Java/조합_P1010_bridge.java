import java.util.Scanner;

public class 조합_P1010_bridge {
    static int T,N,M;
    static int[][]D;

    public static void main(String[] args){
        D = new int[31][31];
        for( int i =0; i<31;i++){
            D[i][i] =1;
            D[i][1] = i;
            D[i][0] = 1;
        }
        for( int i = 2; i<31;i++){
            for( int j =1; j<i;j++){
                D[i][j] = D[i-1][j] + D[i-1][j-1];
            }
        }
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int i = 0; i<T;i++){
            N = sc.nextInt();
            M = sc.nextInt();
            System.out.println(D[M][N]);
        }
    }
}
