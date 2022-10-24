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
        int M,K,T;                                              //T : 케이스 테스트 횟수     M : 색상 종류    K: 선택 조약돌 개수
        int D[] = new int[51];                              //각 색깔별 조약돌 개수 저장하기
        double prob[] = new double[51];                                 //각 색깔별 확률 저장 배열
        double ans;                                 //정답 변수
        T =0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());                           //색상 종류 저장
        st = new StringTokenizer(br.readLine());
        for( int i = 0; i<M; i++){
            D[i] = Integer.parseInt(st.nextToken());                    //D 배열에 각 조약돌 개수 저장하기
            T += D[i];                                                  // T 변수에 조약돌 개수 더하기
        }
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());                                           //K 변수 저장하기
        ans = 0.0;
        for( int i =0; i<M; i++){                   //선택 조약돌 개수보다 현재 색 조약돌 개수가 적은면 모두 같은 색으로 뽑을 확률 0
            if( D[i] >= K){                 //현재 색의 조약돌의 개수가 선택해야 할 개수보다 클 경우
                prob[i] = 1.0;
                for (int j=0; j<K; j++)
                    //i 색상을 모두 뽑을 확률 = i 색상을 모두 뽑을 확률 * 현재 색상 개수 - K/ 전체 색상 개수 - K
                    prob[i] *= (double) (D[i] -K)/(T-K);
            }
            ans += prob[i];                         //정답에 현재 색상을 모두 뽑을 확률 더하기
        }
        System.out.println(ans);
    }
}
