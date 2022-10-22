//슈도 코드//
/*
N(노드 수), M(에지 수)
parent(대표 노드 저장 배열)
queue(에지 정보를 저장할 우선순위 큐)
for( M만큼 반복하기){
    queue에 에지 정보 저장하기       //우선순위 큐이므로 자동정렬
}
while(사용한 에지 수가 노드 -1이 될 때까지){
    큐에서 에지 정보 가져오기
    에지 시작점과 끝점의 부모 노드가 다르면 --> 연결해도 사이클이 생기지 않으면
    union 연산 수행하기
    에지의 가중치를 정답 변수에 더하기
}
정답 변수 출력하기
union(a,b){
    a와 b의 대표 노드 찾기
    두 원소의 대표 노드끼리 연결하기
}
find(a){
    a가 대표 노드이면 리턴하기
    아니면 a의 대표 노드값을 find(parent[a]) 값으로 저장 --> 재귀함수 형태
}
pNode implements Comparable{
    s(  출발 노드 ),e( 도착 노드 ),v( 가중치 )
    가중치의 오름차순 정렬되도록 compareTo 함수 구현하기

 */
import java.util.*;
import java.io.*;

public class 그래프_P1197_최소신장트리구하기 {
    static int[] parent;        // 대표 노드 저장 배열
    static PriorityQueue<pNode> queue;          //에지 정보를 저장할 우선순위 큐
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N  = Integer.parseInt(st.nextToken());          //노드 수
        int M = Integer.parseInt(st.nextToken());           //에지 수
        parent = new int[N+1];                              //대표 노드 배열 초기화
        for (int i = 1; i<=N; i++){
            parent[i] =i;                           // 자기 자신으로 대표 노드 저장
        }
        queue = new PriorityQueue<>();
        for( int i = 0; i<M;i++){                       //큐에 에지 정보 저장
            st = new StringTokenizer(br.readLine());
            int s  = Integer.parseInt(st.nextToken());
            int e  = Integer.parseInt(st.nextToken());
            int v  = Integer.parseInt(st.nextToken());
            queue.add(new pNode(s,e,v));
        }
        int useEdge = 0;                            // 사용한 에지 번호
        int result = 0;                             // 결과
        while(useEdge < N-1){
            pNode now = queue.poll();               //큐에서 에지 정보 가져오기
            if( find(now.s) != find(now.e)){        //에지 시작점과 끝점의 부모 노드가 다르면 ===> 같은 부모가 아니라면 사이클이 생기지 않음
                union(now.s,now.e);
                result = result + now.v;            //에지의 가중치를 결과 값에 더하기
                useEdge++;                          //사용한 노드 번호 넘어가기
            }
        }
        System.out.println(result);                 //결과 값 출력하기
    }

    ////////////Union() 함수  구현하기//////////////
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if( a!=b){
            parent[b] =a;
        }
    }
    ///////////////////////////////////////////

    ///////////find() 함수 구현하기///////////////
    public static int find(int a){
        if(a ==parent[a]){
            return a;
        }
        else{
            return parent[a] = find(parent[a]);
        }
    }
}

class pNode implements Comparable<pNode> {
    int s;
    int e;
    int v;
    pNode( int s, int e, int v){
        this.s = s;
        this.e = e;
        this.v = v;
    }

    @Override
    public int compareTo(pNode o) {       //가중치를 기준으로 오름차순 정렬을 하기 위헤 compareTo 재정의하기
        return this.v-o.v;
    }
}
