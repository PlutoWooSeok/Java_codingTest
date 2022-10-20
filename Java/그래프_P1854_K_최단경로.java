//슈도코드//
/*
N(노드 개수) M(에지 개수)
K(몇 번째 최단 경로를 구해야 하는지 나타내는 변수)
W(그래프 정보 저장인접 행렬)
거리 배열은 충분히 큰 수로 초기화하기
for( 노드 개수 +1){
    최단 거리 큐 배열 초기화하기
}
for(에지 개수){
    인접 행렬에 이 에지 정보를 저장하기
}
다익스트라 알고리즘 수행하기
출발 노드는 우선순위 큐에 넣고 시작하기                      //자동으로 거리가 최소인 노드를 선탹할 수 있음
while(큐가 빌 때까지){                                //모든 노드가 사용될 때까지
    for( 노드 개수 만큼 반복하기){                        //시간 복잡도 측면애서 인접 행렬 구조가 불리함
        if(해당 노드와 현재 노드가 연결돼 있으면){
            if(최단 거리 배열 큐에 해당 노드에 관해 저장된 경로가 K보다 작으면){
                 최단거리 큐배열에 거리 정보 삽입하고 큐에 선택 노드를 추가하기
             }
            else if( 최단 거리 큐의 마지막 값 > 이전 노드의 값+ 두 노드 사이의 에지 가중치){
            해당 노드에 최단 거리 큐에 마지막값 삭제하고 신규값으로 업데이트하기
             }
        }
    }
}
for( 노드 개수){                                                //최단거리 배열 큐를 이용해 각 노드의 K번째 경로를 출력함
    우선순위 큐 크기가 K이면 큐의 값 출력, 아니면 -1 출력
}

Node{                                                           //가중치가 있는 그래프를 담기 위한 별도의 클래스구현하기
    node(가리키는 노드)
    cost(에지의 가중치)
        우선순위 큐 정렬 기준을 위해 compareTo() 함수 구현하기
}
 */
import java.io.*;
import java.util.*;


public class 그래프_P1854_K_최단경로 {
    static final int IMF = 100000000;

    public void main(String[] args) throws IOException {
        int N, M, K;
        int[][] W = new int[1001][1001];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer>[] dq = new PriorityQueue[N + 1];
        Comparator<Integer> cp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? 1 : -1;
            }
        };
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            W[a][b] = c;
        }
        PriorityQueue<wNode> pq = new PriorityQueue<>();
        pq.add(new wNode(1, 0));
        dq[1].add(0);
        while (!pq.isEmpty()) {
            wNode u = pq.poll();
            for (int adjNode = 1; adjNode <= N; adjNode++) {
                //연결된 모든 노드로 검색하기 (시간 복잡도 측면에서 인접 행렬이 불리한 이유)
                if (W[u.node][adjNode] != 0) {
                    //저장된 경로가 K개가 안 될 때는 그냥 추가하기
                    if (dq[adjNode].size() < K) {
                        dq[adjNode].add(u.cost + W[u.node][adjNode]);
                        pq.add(new wNode(adjNode, u.cost + W[u.node][adjNode]));
                    } else if (dq[adjNode].peek() > u.cost + W[u.node][adjNode]) {
                        dq[adjNode].poll();
                        dq[adjNode].add(u.cost + W[u.node][adjNode]);
                        pq.add(new wNode(adjNode, u.cost + W[u.cost][adjNode]));
                    }
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if (dq[i].size() == K) {
                bw.write(dq[i].peek() + "\n");
            } else {
                bw.write(-1 + "\n");
                ;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

    class   wNode implements Comparable<wNode> {
        int node;
        int cost;

        wNode(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(wNode o) {
            return this.cost < o.cost ? -1 : 1;
        }
    }


