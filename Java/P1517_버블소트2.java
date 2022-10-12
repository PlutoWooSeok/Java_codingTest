import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//슈도코드
/*
N(정렬할 수 개수)
A(정렬할 배열)선언하기
tmp (정렬시 데이터를 잠시 저장할 배열)선언하기
for( N만큼 반복)
{
    A배열에 데이터 저장
}
병합 정렬 함수 실행하기
결과값 출력
//병합정렬 함수 생성
병합정렬(S,E){
    S(시작), E(종점), M(중간점)
    //재귀함수 형태로 구현하기
    병합 정렬(S,M)
    병합 정렬(M+1, E)
    for( S~E )
    {
        tmp 배열 저장
    }
    //두 그룹을 병합하는 로직
    index1 : 앞쪽 그룹 시작점
    index2 : 뒤쪽 그룹 시작점
    while( index1 <= 중간점 && index1 <= 종료점)
    {
        뒤쪽 데이터 값이 더 작아 선택될 때
        swap이 일어났다고 가정하고, 현재 남아 있는 앞쪽 데이터 개수만큼 결과값을 더함
    }
    반복문이 끝난 후 남아있는 데이터 정리하기
 */
public class P1517_버블소트2 {
    public static  int A[],tmp[];
    public static long result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        tmp = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for( int i=0; i<N; i++)
        {
            A[i] = Integer.parseInt(st.nextToken());
        }
        result = 0;
        merget_sort(1,N);       //시작지점 1번부터 N번째 인덱스
        System.out.println(result);
    }

    private static void merget_sort(int S, int E) {
        if( E-S < 1){
            return;
        }
        int M = S + (E-S)/2;    //중간점 찾는 공삭
        //재귀함수로 표현하기
        merget_sort(S, M);
        merget_sort(M+1, E);
        for(int i =S; i<= E; i++){
            tmp[i] = A[i]; //본래 데이터를 잠시 임시로 저장함
        }
        int k = S;
        int index1 = S;         // 앞쪽 시작 인데스
        int index2 = M+1;       //뒤쪽 시작 인덱스
        while( index1 <= M && index2 <= E){
            if(tmp[index1] > tmp[index2]){
                A[k] = tmp[index2];
                result = result + index2 -k;        //뒤쪽 데이터 값이 작은 경우 result 업데이트
                k++;
                index2++;
            }else {
                A[k] = tmp[index1];
                k++;
                index1++;
            }
        }
        while (index1 <= M){
            A[k] = tmp[index1];
            k++;
            index1++;
        }
        while (index2 <= E){
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}
