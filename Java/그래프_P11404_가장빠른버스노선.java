//슈도코드//
/*
N(도시 개수)    M(노선개수)
A( 버스 비용 정보 저장 배열 )
start(시작 도시)
end(도착도시)
price(비용)
K( 경유 도시 )
 */
import java.io.*;
import java.util.*;
public class 그래프_P11404_가장빠른버스노선 {
    public static int N,M;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main( String[] args) throws IOException{

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        int [][]A = new int[N+1][N+1];
        for( int i = 1; i<=N; i++){
            for( int j =1; j<=N; j++){
                if( i==j)
                    A[i][j] = 0;
                else
                    A[i][j] = M+100;
            }
        }
        for( int i = 1; i<=M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            if(A[start][end] > price){
                A[start][end] = price;
            }
        }
        for( int k = 1 ; k <=N ; k++){
            for( int i = 1 ; i<=N; i++){
                for( int j=1;j<=N;j++){
                    if(A[i][j] > A[i][k] + A[k][j])
                        A[i][j] = A[i][k]+A[k][j];
                }
            }
        }
        for( int i= 1; i<=N;i++){
            for( int j =1; j<=N;j++){
                if(A[i][j] == M+100)
                    System.out.println("0");
                else
                    System.out.print(A[i][j] +" ");
            }
        }
        System.out.println();
    }
}
