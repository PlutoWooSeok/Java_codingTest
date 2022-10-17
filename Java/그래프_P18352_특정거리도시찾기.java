//슈도코드//
/*
N(노드 개수) M(에지 개수) K(목표거리) X(시작점)
answer( 정답 리스트)
A(그래프 데이터 저장 인접 리스트)    visited(방문 거리 저장 배열)
for(N만큼 반복)
{
    A 인접 리스트의 각 ArrayList 초기화하기
}
for( M만큼 반복 )
{
    A 인접 리스트에 그래프 데이터 저장하기
}
visited 배열 초기화하기
BFS(X) 실행하기
for( N만큼 반복 )
{
    방문 거리가 K인 노드의 숫자를 정답 배열에 더하기
}
정답 배열 오름차순 정렬해 출력하기
 */
////BFS////
/*
BFS(int x){
    큐 자료구조에 출발 노드 더하기(add 연산)
    visited 배열에 현재 노드 방문 기록하기
    while(큐가 빌 때까지){
        큐에서 노드 데이터를 가져오기(poll 연산)
        가져온 노드 출력하기
        현재 노드의 연결 노드 중 방문하지 않는 노드로
        큐에 데이터 삽입(add 연산)하고 visited 배열에 방문 거리 기록하기
        -> 이전 노드의 방문 노드 거리 +1
    }
}
 */
import java.util.*;

public class 그래프_P18352_특정거리도시찾기 {
    static int visited [];          //방문 거리 저장 배열
    static ArrayList<Integer>[] A;      //그래프 데이터 저장 인접 리스트
    static int N,M,K,X;
    static List<Integer> answer;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N= sc.nextInt();
        M= sc.nextInt();
        K= sc.nextInt();
        X= sc.nextInt();
        A = new ArrayList[N+1];
        answer = new ArrayList<>();
        for( int i =1 ; i<N+1 ; i++){
            A[i] = new ArrayList<Integer>();
        }
        for( int i = 0; i<M ; i++ ){
            int s = sc.nextInt();
            int e = sc.nextInt();
            A[s].add(e);
        }
        visited = new int[N+1];
        for( int i = 0; i<=N; i++){
            visited[i] =-1;
        }
        BFS(X);
        for( int i =0; i <=N; i++){
            if(visited[i] ==K){
                answer.add(i);
            }
        }
        if(answer.isEmpty()){
            System.out.println("-1");
        }
        else {
            Collections.sort(answer);           //answer는 리스트이므로 리스트의 오름차순정렬은 Collection.sort()를 사용한다.
            for(int temp : answer){
                System.out.println(temp);
            }
        }
    }
    private static void BFS( int x){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(x);
        visited[x]++;
        while (!queue.isEmpty()){
            int now_node = queue.poll();
            for(int i : A[now_node]){
                visited[i] = visited[now_node]+1;
                queue.add(i);
            }
        }
    }


}
