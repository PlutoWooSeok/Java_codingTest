import java.io.*;
import java.util.StringTokenizer;

public class 그래프_P11403_경로찾기 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;
    public static int [][] A;
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        A = new int[N+1][N+1];
        for( int i = 1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for( int j =1; j<=N; j++){
                int v = Integer.parseInt(st.nextToken());
                if( i == j)
                    A[i][j] = 0;
                else
                    A[i][j] = v;
            }
        }
        for( int k=0; k <N; k++){
            for( int i = 1; i<=N; i++){
                for( int j = 1; j<=N; j++){
                    if (A[i][k] ==1 && A[k][j] ==1)
                        A[i][j]=1;
                }
            }
        }
        for( int i = 1; i<=N; i++){
            for (int j = 1; j<=N; j++){
                System.out.print(A[i][j]  + " ");
            }
            System.out.println();
        }
    }
}
