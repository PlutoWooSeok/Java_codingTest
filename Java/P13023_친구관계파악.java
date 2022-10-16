import java.util.ArrayList;
import java.util.Scanner;

//슈도코드
/*
N(사람 수) M(친구 관계수)
A(그래프 데이터 저장 인접 리스트)
visited(방문 기록 저장 배열)
arrive(도착 확인 변수)
for ( N(사람 수)만큼 반복 )
{
    A 인접 리스트의 각 ArrayList 초기화
}
for( N만큼 반복)
{
    각 노드마다 DFS실행하기
    if( arrive)
        반복문 종료
}
if( arrive) 1 출력
else 0출

//DFS 구현하기
DFS{
    if (깊이가 5 || arrive){
        arrive = true;
        함수종료
    }
    방문 배열에 현재 노드 방문 기록하기
    현재 노드의 연결 노드 중 방문하지 않은 노드로 DFS 실행하기(호출마다 깊이는 1 ++)
}
*/
//깊이가 5인 이유는 A,B,C,D,E의 노드를 연결하는 것이기때문
public class P13023_친구관계파악 {
    static ArrayList<Integer> A[];
    static int N;
    static boolean visited[];
    static boolean arrive;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();   //사람 수
        int M = sc.nextInt();   //  에지(친구관계) 수
        arrive = false;
        A= new ArrayList[N];        //인접리스트를 사람수 크기로 선언
        visited = new boolean[N];   //노드 방문을 알 수 있는 배열을 사람 수 크기로 선언
        for (int i= 0; i < N; i++){
            A[i] = new ArrayList<Integer>();        //각 노드의 ArrayList 초기화
        }
        for(int i = 0 ; i< M; i++){
            //양 방향 에지
            int s = sc.nextInt();
            int e = sc.nextInt();
            A[s].add(e); //시작점에 e넣기
            A[e].add(s); //끝점에 s넣기
        }
        for( int i = 0; i <N ; i++){
            DFS(i,1);   //depth 1
            if (arrive)
                break;
        }
        if (arrive)
            System.out.println("1");    //깊이가 5, 즉 A,B,C,D,E 5개의 노드가 연결되어 있다면 1을 출력
        else
            System.out.println("0");    //깊이가 5가 되지 못한다면, 0 출력
        }
//////////////////////////////////////////////////////////////////////////////////////////////////////////
        static void DFS(int now, int depth){
        if(depth == 5 || arrive){
            arrive = true;
            return;
        }
        visited[now] = true;
        for(int i : A[now]){
            if(!visited[i]){
                DFS(i, depth + 1);          //재귀 호출이 될때마다 depth를 1씩 증가
            }
        }
        visited[now] = false;
    }
}

