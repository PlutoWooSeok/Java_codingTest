import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

//슈도 코드 //
// 제곱근 형태를 이용한 빠르게 최소공통조상 구하기 방식으로 해결하기
//부모 노드 배열 점화식 : P[K][N] = P[K-1][P[K-1][N]]
/*
tree(인접 리스트 자료구조)
N(수의 개수) , M(질의 수)
depth(노드 깊이 배열) parent( 노드 조상 배열)
visited(방문 여부 저장 배열)
for( N의 개수 만큼 반복){
    tree 인접리스트의 각 ArrayList 초기화
}
for(  N-1의 개수 만큼 반복){
    tree 인접 리스트에 그래프 데이터 저장하기
}
BFS(1)                                          //depth와 부모 노드를 BFS를 이용하여 구하기
kMax(최대 가능 높이) 구하기
parent 크기 선언하기 ->[kMax +1][N+1]             //2^k까지의 부모노드 저장하기
for( kMax만큼 반복하기){
    for( 노드 개수만큼 반복){
        점화식을 이용하여 parent 구성하기 parent[K][N] = parent[K-1][parent[K-1][N]]
    }
}
for( M의 개수만큼 반복){
    a(1번 노드) , b(2번 노드)
    excuteLCA(a와 b의 LCA를 구하는 함수 호출 및 결과값 출력하기)
}

//////////////////////////////////////////////////////////////////////////////////////////////////
// LCA를 구하는 함수 구현하기
excuteLCA(1번 노드. 2번 노드){
    1번 노드가 depth가 더 작으면 1번 노드와 2번 노드 swap
    //parent 배열을 이용해 2의 제곱수로 이동하기
    두 노드의 depth를 동일하게 맞추기
    두 노드의 같은 조상이 나올 때까지 각 노드를 부모 노드로 변경하는 작업을 반복하기
    최소 공통 조상 리턴하기
}
////////////////////////////////////////////////////////////////////////////////////////////////////
//BFS{
    큐의 자료구조에 출발 노드 더하기 (add 연산)
    visited 배여ㅛㄹ에 현재 노드 방문 기록하기
    while( 큐가 빌 때까지 ){
        큐에서 노드 데이터를 가져오기 poll() 연산
        가져온 노드 출력하기
        현재 노드의 연결 노드 중 방문하지 않은 노드로 반복하기{
            큐에 데이터 삽입(add 연산)하고 visited 배열에 방문 기록하기
            parent 배열에 자신의 부모 노드 저장하기
            depth 배열에 현재 높이 저장하기
        }
        if( 이번 높이에 해당하는 모든 노드를 방문했을 때){
            현재 배열의 depth를 1개 증가
        }
    }
}

 */
public class 트리_P11438_최소공통조상 {
    static ArrayList<Integer>[] tree;
    static int depth[];
    static int parent[][];
    static int kMax;
    static boolean visited[];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < N-1; i++) {                                 //A 인접 리스트에 그래프 데이터 저장하기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree[s].add(e);
            tree[e].add(s);
        }
        depth = new int[N + 1];
        visited = new boolean[N + 1];
        int temp = 1;
        kMax = 0;
        while (temp <= N) {                                                 //최대 가능 depth 구하기
            temp <<= 1;
            kMax++;
        }
        parent = new int[kMax + 1][N + 1];
        BFS(1);                                                      //depth를 BFS를 이용해 구하기
        for (int k = 1; k <= kMax; k++) {
            for (int n = 1; n <= N; n++) {
                parent[k][N] = parent[k - 1][parent[k - 1][N]];
            }
        }
        int M = Integer.parseInt(br.readLine());                    //질의의 수
        for (int i = 0; i < M; i++) {
            //공통 조상을 구할 두 노드
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int LCA = excuteLCA(a, b);
            System.out.println(LCA);
        }
    }

    static int excuteLCA(int a, int b) {
        if (depth[a] > depth[b]) {                                          //더 깊은 depth가 b가 되도록 변경하기
            int temp = a;
            a = b;
            b = temp;
        }
        for (int k = kMax; k >= 0; k--) {             //depth를 빠르게 맞추기
            if (Math.pow(2, k) <= depth[b] - depth[a]) {
                if (depth[a] <= depth[parent[k][b]]) {
                    b = parent[k][b];
                }
            }
        }
        for (int k = kMax; k >= 0 && a != b; k--) {                             //조상 빠르게 찾기
            if (parent[k][a] != parent[k][b]) {
                a = parent[k][a];
                b = parent[k][b];
            }
        }
        int LCA = a;
        if (a != b) {
            LCA = parent[0][LCA];
        }
        return LCA;
    }

    public static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        visited[node] = true;
        int level = 1;
        int now_size = 1;
        int count = 0;
        while( !queue.isEmpty()){
            now_size = queue.poll();
            for( int next : tree[now_size]){
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                    parent[0][next] = now_size;                                 //부모 노드 저장하기
                    depth[next] = level;                                        //노드 depth 저장하기
                }
            }
            count++;
            if( count == now_size){
                count =0;
                now_size = queue.size();
                level++;
            }
        }
    }
}

