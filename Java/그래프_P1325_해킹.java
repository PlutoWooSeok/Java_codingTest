//슈도코드
/*
N(노드의 개수)   M(에지의 개수)
visited( 방문 기록 저장 배열)
A( 그래프 데이터 저장 인접 리스트)
answer( 정답배열)
for( N만큼 반복)
{
    A 인접 리스트에 ArrayList 초기화
}

for( N만큼 반복)
{
    A 인접리스트에  그래프 데이터 저장하기
}
for( i~N까지 반복){
    visited 배열 초기화 하기
    BFS(i)
}
for( N만큼 반복){
    answer 배열에서 최댓값 찾기

}
 */
import java.util.*;
public class 그래프_P1325_해킹 {
    static int N,M;
    static int []answer;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        A = new ArrayList[N+1];

        answer = new int[N+1];
        for(int i =1 ; i <=N; i++){
            A[i] = new ArrayList<Integer>();
        }
        for( int i = 1; i <=M; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            A[s].add(e);
        }
        for( int i =1; i<=N; i++){
            visited = new boolean[N+1];
            BFS(i);
        }
        int Max=0;
        for( int i = 1; i<=N ; i++){
            Max = Math.max(Max, answer[i]);
        }
        for( int i =1; i<=N; i++){
            if( answer[i] == Max){
                System.out.println(i + " ");
            }
        }

    }
    private static void BFS(int node){
        Queue<Integer> queue  =new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        while(!queue.isEmpty()){
            int now_node = queue.poll();
            for( int i : A[now_node]){
                if( visited[i] == false){
                    visited[i] = true;
                    answer[i]++;
                    queue.add(i);
                }
            }

        }

    }


}
