import java.io.*;
import java.util.*;

//슈도 코드//
/*
N(도시의 수) M(교통수단 수 : 에지 개수)
A(에지 리스트 배열), cityMoney(각 도시에서 버는 수입 배열)
거리 배열은 충분히 큰 작은 수로 초기화하기( Long, Min_Value)
for( M만큼 반복){
    에지 리스트 배열에 이 에지 정보를 저장하기
    //////=> 출발 도시 , 도착 도시, 가격
}
//변형된 벨만 포드 알고리즘 수행하기
거리 배열에 출발 노드 cityMoney[출발노드]fh chrlghkgkrl
for( N + 100){          //양수 사이클이 전파되도록 충분히 큰 수로 반복하기
    for(에지 개수){
        현재 에지 데이터 가져오기
        if( 출발 노드가 방문하지 않은 노드 -> 값이 Long.MIN>VALUE)Skip
        else if(출발 노드가 양수 사이클에 연결된 노드 -> 값이 Long.MAX_VALUE)
            종료 노드를 양수 사이클에 연결된 노드로 업데이트 -> 값 = Long.MAX_VALUE
        else if( 종료 노드의 값 < 출발노드의 값 + 도착 도시에서의 수입 - 에지의 가중치)
            // 더 많은 수입을 얻는 경로가 발견될 때
            종료 노드의 값을 출발 노드의 값 + 도착 도시에서의 수입 - 에지의 가중치로 업데이트
        if(N-1 반복 이후 업데이트 될떄)
            이 종료 노드를 양수 사이클 연결 노드로 업데이트
    }
}

// 도착 도시의 값에 따른 결과 출력하기
도착 도시가 Long.MIN_VALUE -> 도착 불가 -> "gg" 출력하기
도착 도시가 Long.MAX_VALUE -> 돈을 무한대로 벌 수 있음 -> "gee" 출력하기
이외의 경우 -> 도착 도시의 값 출력하기

//에지를 담기 위한 클래스 별도 구현하기
Edge{
    start(출발 노드)
    end(종료 노드)
    value(에지의 가중치)
}

 */
public class 그래프_P1219_세일즈맨 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M, sCity, eCity;
    static long distance[], cityM[];
    static C_Edge edges[];

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer( br.readLine());
        N = Integer.parseInt(st.nextToken());
        sCity = Integer.parseInt(st.nextToken());
        eCity = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new C_Edge[M];
        distance = new long[N];
        cityM = new long[N];
        Arrays.fill(distance,Long.MIN_VALUE);       //최단 거리 배열 초기화하기
        for( int i = 0; i< M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            edges[i] = new C_Edge(start, end, price);
        }
        st = new StringTokenizer(br.readLine());
        for( int i = 0; i< N ; i++){
            cityM[i] = Long.parseLong(st.nextToken());
        }
        distance[sCity] = cityM[sCity];
        //양수 사이클이 전파 되도록 충붆; 큰 수로 반복하기
        for( int i = 0; i<=N+100; i++){
            for( int j = 0; j<M; j++){
                int start = edges[j].start;
                int end = edges[j].end;
                int price = edges[i].price;
                //출발 노드가 방문하지 않은 노드이면 skip
                if (distance[start] == Long.MIN_VALUE)
                    continue;
                //출발 노드가 양수 사이클에 연결된 노드라면 종료 노드도 연결 노드로 업데이트
                else if (distance[start] == Long.MAX_VALUE) {
                    distance[end] = Long.MAX_VALUE;
                }
                // 더 많은 돈을 벌 수 있는 새로운 경로가 발견되었을 때 새로운 경로값으로 업데이트
                else if (distance[end]< distance[start]+cityM[end] -price) {
                    distance[end] = distance[start]+cityM[end] -price;
                    //N-1 반복 이후 업데이트되는 종료 노드는 양수 사이클 노드로 변경
                    if(i >= N-1)
                        distance[end] = Long.MAX_VALUE;
                }

            }
        }
        if (distance[eCity] == Long.MIN_VALUE){
            System.out.println("gg");
        } else if (distance[eCity]==Long.MAX_VALUE) {
            System.out.println("Gee");
        }else
            System.out.println(eCity);
    }
}
    class C_Edge {
        int start;
        int end;
        int price;

        public C_Edge(int start, int end, int price){
            this.start = start;
            this.end = end;
            this.price=price;
        }

    }

