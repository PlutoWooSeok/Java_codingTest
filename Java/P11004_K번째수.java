import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//퀵 정렬을 이용
//슈도코드
/*
N(숫자의 개수), K(K번 째 수) 입력
A[] (숫자 데이터저장 배열)
for ( N만큼 반복)
{
    A배열 저장
}
퀵 소트 실행하기
K번 째 수 출력

/////////퀵 소트 함수//////////
퀵소트 함수 (시작 인덱스, 종료 인덱스, K)
{
    피벗 구하기 함수(시작, 종료)
    if(피벗 == K)
        종료
    else if( K< 피벗)
        퀵소트 실행(시작, 피벗-1, K)
    else
        퀵소트 수행하기(피벗 +1, 종료, K)
}

////////////피벗 구하기 함수//////////
피벗 함수( 시작, 종료)
{
    중앙값을 피벗으로 설정하기
    i(시작점), j(종료점)
    while(i<j)
    {
        피벗보다 큰 수가 나올때 까지 i++
        피벗보다 작은 수가 나올때 까지 j--
        찾은 i와j 데이터를 swap
    }
    피벗 데이터를 나눠진 두 그룹 경계 index에 저장하기
}
 */
public class P11004_K번째수 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(bf.readLine());   //숫자의 개수 입력
        int K = Integer.parseInt(bf.readLine());;   //K번 째 수 입력
        int []A = new int[N];   //숫자 데이터 저장 배열
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());;    // 숫자 데이터 배열에 수 저장
        }
        quickSort(A,0,N-1,K-1);         //퀵소트 함수 실행( A배열, 시작 인덱스: 0 , 종료 인덱스: N-1, K: K-1)
        System.out.println(A[K-1]);

    }

    public static void quickSort(int[] A, int S, int E, int K) {
        if(S < E){
            int pivot = partition(A,S,E);
            if(pivot == K){                 //K번째 pivot이면 더 이상 구할 필요 없음
                return;
            } else if (K < pivot) {         //K가 pivot보다 작으면 왼쪽 그룹만 퀵정렬 실행
                quickSort(A, S, pivot-1, K);
            }else {                         //K가 pivot보다 크면 오른쪽 그룹만 퀵정렬 실행
                quickSort(A, pivot+1, E, K);
            }
        }
    }

    public static int partition(int[] A, int S, int E) {
        int M =(S+E)/2;
        swap(A,S,M);                //중앙값을 1번째 요소로 이동하기
        int pivot = A[S];
        int i = S, j =E;
        while (i<j){
            while(A[j] > pivot){            //피벗보다 작은 수가 나올 때까지 j--
                j--;
            }
            while ((i < j && pivot >= A[i])){       //피벗보다 큰 수가 나올 때까지 i++
                i++;
            }
            swap(A,i,i);                //찾은 i와 j를 스왑하기
        }
        // i == j 피벗값을 양쪽으로 분리한 가운데에 오도록 설정하기
        A[S] = A[i];
        A[i] = pivot;
        return i;
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}
