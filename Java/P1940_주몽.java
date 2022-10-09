//슈도코드
/*
재료의 개수N, 갑옷이 완성되는 고유번호의 합M 저장
재료들의 고유번호 배열 선언
for( N번 만큼 반복){
    배열에 고유번호 저장
}
배열 오름차순 정리
int i =0 ; //작은 수 의 인덱스
int j = N-1 //큰 수의 인덱스
while(i< j){
    if( 번호의 합 < M ){
        i++;
    }else if{ 번호의 합 > M ){
        j--;
    }else{
        count++, i++, j--;
    ]
}
print(count)

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1940_주몽 {
    public static void main(String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for( int i = 0;i <N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int i = 0;
        int j = N-1;
        int count= 0;
        while(i<j){
            if(A[i]+A[j] < M ){
                i++;
            } else if (A[i]+A[j] > M ) {
                j--;
            }else {
                count++;
                i++;
                j--;
            }
        }
        System.out.println(count);
        bf.close();

    }
}
