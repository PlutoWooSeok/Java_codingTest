//슈도코드
/*
N(노드 개수) , M(에지개수), S(시작점)
A(그래프 데이터 저장 인접 리스트) visited(방문 기록 저장 배열)
for(  N만큼 반복 )
{
    A 인접 배열 ArrayList 초기화
}
for ( N만큼 반복)
{
    A 인접 리스트에 그래프 데이터 저장
}
 */
//방문할 수 있는 노드가 여러 개일 경우에는 번호가 작은 것을 먼저 방문하기 위해 정렬하기
/*
for( N만큼 반복 ){
    각 노드와 관련된 에지 정하기
}
visited 배열 초기화
DFS 실행하기
visited 배열 초기화
BFS 실행하기
 */
//DFS구현하기
/*
DFS{
    현재 노드 풀력하기
    visited 배열에 현쟈 노드 방문기록하기
    현재 노드의 연결 노드 중 방문하지 않은 노드로 DFS 실행하기(재귀 함수 형태)
}
 */
//BFS 구현하기
/*
BFS{
    큐 자료구조에 시작노드 삽입하기( add 연산 )
    visited 배열에 현재 노드 방문 기록하기
    while( 큐가 비어 있을 때까지){
        큐에서 노드 데이터를 가져오기(poll 연산)
        가져온 노드 출력하기
        현재 노드의 연결 노드 중 미방문 노드를 큐에 삽입(add 연산)하고 방문 배열에 기록하기
    }
}
 */

import java.util.*;

public class P1206_DFS와BFS {
    static int N,M,S;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        S = sc.nextInt();
        A = new ArrayList[N+1];
        visited = new boolean[N+1];
        for( int i = 1; i<N+1; i++){
            A[i] = new ArrayList<Integer>();
        }
        for( int i = 1 ; i < N+1; i++){
            int S = sc.nextInt();
            int E = sc.nextInt();
            A[S].add(E);
            A[E].add(S);
        }

        //방문할 수 있는 노드가 여러 개일 경우에는 번호가 작은 것을 먼저 방문하기 위해 정렬
        for( int i= 1; i< N+1; i++){
            Collections.sort(A[i]);
        }
        visited = new boolean[N+1];
        DFS(S);
        System.out.println();
        visited = new boolean[N+1];
        BFS(S);

    }

    //## DFS 선언하기 ##//
    public static void DFS( int node ){
        System.out.print(node + " ");
        visited[node] = true;
        for( int i : A[node]){
            if( !visited[i]) {
                DFS(i);
            }
        }
    }
    //## BFS 선언하기 ##//
    public static void BFS( int node ){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add( node);
        visited[node] = true;

        while( !queue.isEmpty()){
            int now_Node = queue.poll();
            System.out.print(now_Node + " ");
            for ( int i : A[now_Node]){
                if( !visited[i]){
                    visited [i]= true;
                    queue.add(i);
                }
            }
        }

    }


}
