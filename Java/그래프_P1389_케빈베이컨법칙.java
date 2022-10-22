import java.util.*;
import java.io.*;
public class 그래프_P1389_케빈베이컨법칙{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N,M;
    static int A[][];
    public static void main(String[] args) throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N+1][N+1];
        for( int i = 1; i<= N; i++){
            for( int j =1; j<=N; j++){
                if( i == j){
                    A[i][j] = 0;
                }else {
                    A[i][j] = 100001;
                }
            }
        }
        for ( int i = 0; i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a][b] = 1;
            A[b][a] = 1;
        }
        for( int k=1; k<=N ; k++){
            for (int i = 1; i <=N; i++){
                for (int j =1; j<=N; j++){
                    if( A[i][j] > A[i][k] +A[k][j]){
                        A[i][j] = A[i][k] + A[k][j];
                    }
                }
            }
        }

        //케빈 베이컨식 합치
        int min = Integer.MAX_VALUE;
        int Ans = -1;
        for ( int i = 1; i<=N; i++){
            int temp =0;
            for (int j = 1; j<=N; j++){
                temp = temp+ A[i][j];
            }
            if(min >temp){
                min = temp;
                Ans =i;
            }
        }
        System.out.println(Ans);
    }


}
