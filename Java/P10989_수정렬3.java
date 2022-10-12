import java.io.*;

//슈도코드
/*
N(정렬할 수 개수)
A(정렬할 배열 선언하기)
for(N만큼 반복)
{
    A 배열 데이터 값 저장
}
기수 정렬 함수 실행하기
정렬된 A배열 출력하기

//기수정렬 생성
//변수 선언부
bucket(현재 자릿수들의 분포를 합 배열의 형태로 알려주는 배열)
    ex:bucket[4] -> 현재 기준 자릿값이 0~4까지 몇 개의 데이터가 있는지 저장하기
output(임시 정렬을 위한 배열)
jarisu(현재 자릿수를 표현하는 수)

//로직부분
while( 최대 자릿수만큼 반복하기 )
{
    현재 기준 자릿수를 기준으로 A배열 데이터를 bucket에 count
    합 배열 공식으로 bucket을 합 배열 형태로 변경하기
    for( N만큼 반복 )
    {
        bucket값을 이용해 현재 기준 자릿수로 데이터 정렬하기
        output 배열에 저장하기
    }
    for( N마큼 반복)
    {
        다음 자릿수 이동을 위해 A 배열에 output 데이터 저장하기
    }
    jarisu = jarisu * 10
}
 */
public class P10989_수정렬3 {
    public static int[] A;
    public static  long result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   //버퍼리더로 문자열 받기
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());        //데이터 수 입력받기
        A = new int[N];
        for( int i = 0 ; i < N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        br.close();                 //입력 중단
        Radix_sort(A, 5);           //기수 정렬 실행
        for( int i = 0 ; i < N; i++){
            bw.write(A[i] + "\n");              // 줄나눔으로 출력
        }
        bw.flush();             //나머지 데이터
        bw.close();
    }


    /////////////////Radix_sort(기수 정렬) 선언/////////////////
    public static void Radix_sort(int[] A, int max) {           //max는 최대 자리수
         int output[] = new int[A.length];                  //임시 저장 배열(크기는 A배열과 같다.)
         int num = 1;       // 자릿수
         int  count = 0;
         while ( count != max){                     //최대 자릿수만큼 반복하기
             int[] bucket = new int[10];
             for (int i = 0; i<A.length ; i++){
                 bucket[(A[i] / num) % 10]++;       //각각의 인덱스의 값 -> 일의 자리부터 시작
             }
             for( int i = 1; i < 10; i++ ){         //이전 인덱스의 값을 더하는 합배열을 이용하여 index 계산하기
                 bucket[i] += bucket[i-1];
             }
             for (int i =A.length; i >=0; i--){     //현재 자릿수를 기준으로 정렬하기
                 output[bucket[(A[i] / num % 10)] -1] = A[i];
                 bucket[(A[i] / num) %10]--;
             }
             for( int i =0; i<A.length;i++){
                 //다음 자리수를 이동하기 위해 현재 자리수 기준 정렬 데이터 저장하기
                 A[i] = output[i];
             }
             num = num *10;             //자리수 증가시키기
             count++;
         }
    }
}



