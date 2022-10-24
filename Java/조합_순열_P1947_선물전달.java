// 슈도 코드 //
/*
N( 사람 수 )
D[] ( 선물을 받을 수 있는 경우의 수 )
D[1] = 0;               // 한명이 다른 사람에게 선물을 할 수 없음
D[2] = 1;               // 서로가 서로에게 선물을 한다( 맞교환 )
//점화식  :  D[i] = D[i-1] * (D[i-1] + D[i-2])
//////////////////////////////////////////////////////
//선물 교환 방식  :  (A가 B에게 선물을 주었다는 가정하에)
1). B도 A에게 선물을 주었을 경우
    : N명 중 2명이 맞교환을 했으므로 남은 경우의 수는 D[N-2]
2). B가 A가 아닌 다른 사람에게 선물을 주었을 경우
    : 본인을 제외한 경우의 수 D[N-1]
/////////////////////////////////////////////////////
for( i -> 3~N 까지 반복){
    D[i] = (i-1) * (D[i-1] + D[i-2]) % 1000000000
}
D[N] 출력하기
 */
import java.util.*;

public class 조합_순열_P1947_선물전달 {
    static int N;
    static long D[] = new long[10001];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        D[1] = 0;                   //사람이 1명이므로 선물을 줄 수 있는 경우가 없다
        D[2] = 1;                   //사람이 2명이므로 본인을 제외한 서로 선물을 교환해야 한다.
        for( int i = 3; i<=N; i++){
            D[i] = (i-1) * (D[i-1] +D[i-2]) % 1000000000;
        }
        System.out.println(D[N]);
    }
}
