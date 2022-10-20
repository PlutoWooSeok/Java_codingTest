//슈도코드//
/*
필요한 자료구조 선언하기( 그래프 정보 저장 인접리스트, 최단 거리 저장, 노드 사용 여부 저장)
N(노드 수) M(에지 수)
선언한 변수들을 초기화하기
거리 배열은 충분히 큰 수로 초기화하기
for( 노드 개수){
    그래프 정보를 저장하는 인접 리스트 초기화하기
}
다익스트라 알고리즘 수행하기
출발 노드는 우선순위 큐에 넣고 시작하기
//자동으로 거리가 최소인 노드를 선택할 수 있게 해 주는 자료구조
while(큐가 빌 떄까지){        //모든 노드가 사용될 떄까지
    현재 선택된 노드가 방문한 적이 있는지 확인하기
    현재 노드를 방문 노드로 업데이트하기
    for(현재 선택 노드의 에지 개수){
        if(타깃 노드 방문 && 현재 선택 노드 최단거리 + 비용 < 타깃 노드의 최단거리){
            타깃 노드 최단 거리 업데이트하기
            우선순위 큐에 타깃 노드 추가하
        }
    }
}

최단거리 배열에서 목적지 길이를 찾아출력하기
//가중치가 있는 그래프를 담기 위한 클래스 별도 구현하기
Edge{
    vertext(가리키는 노드)
    value(에지의 가중치)
    우선 순위 큐 정렬 기준을 위해 compareTo() 함수 구현하기
}

 */
import java.io.*;
import java.util.*;

public class 그래프_P1916_최소비용 {
    static int N,M;                     //도시 개수, 버스 개수
    static ArrayList<Node>[] list;      //인접 리스트로 그래프 표현하기
    static int[] dist;                  //최단 거리 배열
    static boolean[] visit;             //사용 노드인지 확인하는 배열
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st ;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        dist = new int[N+1];
        visit = new boolean[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for( int i =0; i <=N; i++){
            list[i] = new ArrayList<Node>();
        }
        for( int i =0; i< M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, weight));
        }
        st = new StringTokenizer(br.readLine());
        int startIndex = Integer.parseInt(st.nextToken());
        int endIndex = Integer.parseInt(st.nextToken());
        bw.write(dijkstra(startIndex, endIndex) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.offer(new Node(start,0));
        dist[start]=0;
        while (!pq.isEmpty()){
            Node nowNode = pq.poll();
            int now = nowNode.targetNode;
            if(!visit[now]){
                for(Node n : list[now]){
                    if(!visit[n.targetNode] && dist[n.targetNode] > dist[now] + n.value){
                        dist[n.targetNode] = dist[now] + n.value;
                        pq.add(new Node(n.targetNode, dist[n.targetNode]));
                    }
                }
            }
        }
        return dist[end];
    }

}

class Node implements Comparable<Node>{
    int targetNode;
    int value;
    Node(int targetNode, int value){
        this.targetNode = targetNode;
        this.value = value;
    }



    @Override
    public int compareTo(Node o) {
        return value -o.value;
    }
}
