import java.util.Scanner;

//슈도코드
/*
N(동전 종류) , K(목표 금액)
A[]( 동전 종류를 저장할 배열)
fof( N만큼 반복)
{
    A 배열에 동전의 종류 저장
}
for (int i = N-1; i >=0; i--){
    if( K < A[i]){
        동전수  += k / A[i]
        목표금액 = K%a[i]
    }
}

동전수 출력
 */
public class P11047_동전개수최솟값 {
    public static void main( String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int []A= new int[N];
        for( int i =0 ; i<N; i++){
            A[i] = sc.nextInt();
        }
        int count =0;

        for ( int i = N-1; i >= 0 ; i --){
            if( K >=A[i]){
                count += K/A[i];
                K = K%A[i];
            }
        }
        System.out.println(count);
    }
}
