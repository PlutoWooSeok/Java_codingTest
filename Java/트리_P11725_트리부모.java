//슈도 코드//
/*
N(노드 개수)
A( 그래프 데이터 저장 인접 리스트 )
visited( 방문 기록 저장 배열 )
ans( 부모 노드 저장 정답 배열 )
for( N의 개수 만큼 반복 ){
    A 인접 리스트의 각 ArrayList 초기화하기
}
for( N-1의 개수만큼 반복하기 ){
    A 인접 리스트에 그래프 데이터 저장하기
}
1번 노드부터 DFS 실행하기
for( 2 ~ N 만큼 반복하기){
    ans 배열 출력하기
}
DFS{
    visited 배열에 현재 노드 방문 기록하기
    현재 노드의 연결 노드 중 방문하지 않은 노드로
    부모노드저장하기
    DFS실행하기 (재귀 함수 형태 )
}
 */
import java.util.*;

public class 트리_P11725_트리부모 {
    static int N;                           //노드 개수
    static boolean visited[];               //방문 저장 배열
    static ArrayList<Integer> tree[];       //그래프 데이터 저장 인접 리스트
    static int ans[];                        //부모 노드 저장 배열
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        visited = new boolean[N+1];
        tree = new ArrayList[N+1];
        ans = new int[N+1];
        for( int i = 0; i< tree.length; i++){
            tree[i] = new ArrayList<>();                    //A 인접 리스트에 각 ArrayList 초기화하기
        }
        for( int i =1;i<N;i++){                             //A 인접 리스트에 그래프 데이터 저장하기
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            tree[n1].add(n2);
            tree[n2].add(n1);
        }
        DFS(1);                             //시작 노드를 1로 하여 DFS 실행하기
        for( int i =2; i<=N;i++){
            System.out.print(ans[i] + " ");
        }
    }

    //////DFS() 매서드 ///////////
    static void DFS(int number){
        visited[number] =true;                          //방문한 노드 체크
        for (int i : tree[number]){
            if(!visited[i]){                        //노드에 방문하지 않았다면
                ans[i] = number;                    //정답 배열에 노드번호 저장
                DFS(i);                             //다시 DFS실행 ==> 재귀함수 형태
            }
        }
    }

}
