import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

생각 오류
        double D[][] = new double[51][51];
//        double sum =0;
//        for( int i = 0; i<51; i++){
//            D[i][i] = 1;
//            D[i][0] = 1;
//            D[i][1] = 1;
//        }
//
//        for (int i = 1; i<51; i++){
//            for ( int j = 2; j<i;j++){
//                D[i][j] = D[i-1][j] + D[i-1][j-1];
//            }
//        }
//
//        Scanner sc = new Scanner(System.in);
//        int M = sc.nextInt();
//        //int []A =new int[M];
//        int a = 0;
//        int N = 0;
//        for( int i = 0; i<M; i++){
//            //A[i] = sc.nextInt();
//            a =sc.nextInt();
//            //N = N + A[i];
//            N = N + a;
//            //sum = sum + D[A[i]][2];
//            sum = sum + D[a][2];
//
//        }
//        int K = sc.nextInt();
//        double P = D[N][K];
//
//        System.out.println(sum / P);
//    }
 */
public class 조합_P13251_조약돌 {
    public static void main(String[] args) throws IOException {
        int M,K,T;
        int D[] = new int[51];
        double prob[] = new double[51];
        double ans;
        T =0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for( int i = 0; i<M; i++){
            D[i] = Integer.parseInt(st.nextToken());
            T += D[i];
        }
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        ans = 0.0;
        for( int i =0; i<M; i++){
            if( D[i] >= K){
                prob[i] = 1.0;
                for (int k=0; k<K; k++)
                    prob[i] *= (double) (D[i] -k)/(T-K);
            }
            ans += prob[i];
        }
        System.out.println(ans);
    }
}
