import java.util.Scanner;

//슈도 코드 작성하기
/*
    N 입력받기(수열의 개수)
    M 입력받기(나누어떨어져야 하는 수)
    S 선언하기(합 배열)
    C 선언하기(같은 나머지의 인덱스를 카운트하는 배열)

    for(i -> 1~N){
        S[i] = S[i-1]+A[i] //합 배열 저장
    }
    for(i -> 0~N){
        remainder = S[i] % M // 합 배열을 M으로 나눈 나머지 값
        if(remaider == 0) //정답을 1 증가시키기
        C[remainder]의 값을 1 증가시키기
    }
    for(i -> 0 ~ M){
        C[i](i가 나머지인 인덱스의 개수)에서 2가지를 뽑는 경우의 수를 정답에 더하기
        //C[i]개 중 2개를 뽑는 경우의 수 계산 공식 : C[i] * (C[i]-1)/2
    }
    결과값(answer) 출력
 */
public class P10986_나머지합 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long[] s = new long[N];
        long[] C = new long[M];
        long result = 0;
        s[0] = sc.nextInt();
        for ( int i = 1; i<N; i++){    //수열 합 배열 만들기
            s[i] = s[i-1] + sc.nextInt();   //수를 입력 받으면서 바로 합 배열 생성
        }

        for( int i = 0; i < N; i++){    //합 뱌열의 모든 값에 % 연산 수행하기
            int remainder = (int)(s[i]%M);  //배열의 값을 M으로 나누었을 때의 나머지
            if(remainder == 0) // 나머지가 0일 경우 정답을 1 증가
                result++;

            C[remainder]++; //같은 나머지의 값을 가진 배열을 1증가
        }

        for (int i = 0; i < M; i++){
            if(C[i] >1){
                //나머지가 같은 인덱스 중 2개를 뽑는 경우의 수를 더하기 => 연속된 부분의 합이 M으로 나누어 떨어지는 개수
                result = result + (C[i] * (C[i]-1) /2);
            }
        }
        System.out.println(result);

    }
}
