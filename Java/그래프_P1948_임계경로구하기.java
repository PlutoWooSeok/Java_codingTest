///////////// 슈도 코드 /////////////
/*
N(도시 수 ), M(도로 수)
A(도시 인접 리스트) reverseA( 역방향 인접 리스트 )
도시 수만큼 인접 리스트 초기화하기
진입 차수 베열 초기화하기
for(도시 수만큼 반복하기){
    인접리스트 데이터 저장하기
    역방향 인접 리스트 데이터 저장하기
    진입차수 베열 초기 데이터 저장하기
}
//위상 정렬 수행하기
큐 생성하기
출발도시 큐에 삽입하기
result(각 도시의 최대 걸리는 시간 저장 - 임계 경로값)
while(큐가 빌 때까지){
    현재 노드 = 큐에서 데이터 poll
    현재 노드값 출력하기
    for( 현재 노드에서 갈 수 있는 노드의 개수){
        타깃 노드 진입 차수 배열--
        result = 타깃 노드의 현재 경로 값과 현재 노드의 경로값
                    + 도로 시간값 중 큰값으로 저장하기
        if( 타깃 노드의 진입 차수가 0이면)
        {
            큐에 타깃 노드 추가하기
        }
    }
}

//위상 정렬 역방향 수행하기
visited(각 도시의 방문 유무 저장하기)
도착 도시를 큐에 삽입하기
visited 배열에 도착 도시를 방문 도시로 표시하기
while( 큐가 빌 때까지){
    현재 노드 = 큐에서 데이터 poll
    for( 현재 노드에서 갈 수 있는 노드의 개수 -> 역방향 인접 리스트 기준){
        if(타깃 노드의 result값 + 도로를 지나는데 거리는 시간(에지) == 현재노드의 result 값)[
            1분도 쉬지 않고 달려야 하는 도로값 1증가
            if(아직 방문하지 않은 도시이면){
                visited 배열에 방문 도시 표시하기
                큐에 타깃 노드 추가하기
            }
        }
    }
}
 */


import java.io.*;
import java.util.*;
public class 그래프_P1948_임계경로구하기 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());            // 도시 수
        int M = Integer.parseInt(br.readLine());            // 도로 수
        int [] inDegree = new int[N+1];                     //진입 차수 배열
        ArrayList<ArrayList<node>> A = new ArrayList<>();           //도시 인접 리스트
        ArrayList<ArrayList<node>> reverseA = new ArrayList<>();        //도시 역방향 인접 리스트

        for( int i = 0; i<=N; i++){
            A.add(new ArrayList<node>());                   // 도시 인접 리스트 초기화
            reverseA.add(new ArrayList<node>());            // 도시 역방향 인접 리스트 초기화
        }
        for( int i = 1; i<=M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());               // 출발 도시 번호
            int E = Integer.parseInt(st.nextToken());               // 도착 도시 번호
            int T = Integer.parseInt(st.nextToken());               // 이동하는데 걸리는 시간
            A.get(S).add(new node(E,T));                            // 도시 인접 리스트 데이터 저장
            reverseA.get(S).add(new node(S,T));                     // 도시 역방향 인접 리스트 데이터 저장
            inDegree[E]++;                                          // 집입 차수 배열 초기 데이터 저장
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sCity = Integer.parseInt(st.nextToken());               // 최초 출발 도시 번호
        int eCity = Integer.parseInt(st.nextToken());               // 최종 도착 도시 번호

        Queue<Integer> queue = new LinkedList<>();                  // 큐 생성하기
        queue.offer(sCity);                                         // 큐에 출발 도시 저장
        int [] result = new int[N+1];
        while(! queue.isEmpty()){                                   //큐가 빌 떄까지
            int now = queue.poll();                                 //큐의 front 값이 현재 노드
            for( node next : A.get(now)){                           //현재 노드에서 갈 수 있는 노드의 개수만큼 반복
                inDegree[next.targetNode]--;                        //타깃 노드 진입 차수 배열--

                //result = 타깃 노드의 현재 경로 값과 현재 노드의 경로값 + 도로 시간값 중 큰 값으로 저장하기
                result[next.targetNode] = Math.max( result[next.targetNode], result[now] + next.value);

                //if(타깃 노드의 진입 차수가 0이면)
                if(inDegree[next.targetNode] == 0){
                    //큐에 타깃 노드 추가하기
                    queue.offer(next.targetNode);
                }
            }
        }
        // 위상 정렬 역방향 수행하기
        int resultCount = 0;                            //1분도 쉬지 않고 걸어야하는 도로의 개수
        boolean visited[] = new boolean[N+1];           //각 도시의 방문 유무 배열
        queue = new LinkedList<>();
        queue.offer(eCity);                             //도착 도시를 큐에 삽입하기
        visited[eCity] = true;                          //visited 배열에 도착 도시를 방문 도시로 표시하기
        while( !queue.isEmpty()){                       //큐가 빌 때까지 반복
            int now = queue.poll();                     //현재 노드 = 큐에서 데이터 poll
            //for9 현재 노드에서 갈 수 있는 노드의 개수 -> 역방향 인접 리스트 기준)
            for( node next : reverseA.get(now)){
                //if(타깃 노드의 result ㄱ밧 + 도로를 지나는데 걸리는 시간(에지) == 현재 노드의 result 값)
                if(result[next.targetNode] + next.value == result[now]){
                    resultCount++;                      //1분도 쉬지 않고 달려야 하는 도로값 1증가

                    //if(아직 방문하지 않은 도시이면)
                    if(visited[next.targetNode] =false){
                        //visited 배열에 방문 도시 표시하기
                        visited[next.targetNode] = true;
                        //큐에 타깃 노드 추가하기
                        queue.offer(next.targetNode);
                    }
                }
            }
        }
        System.out.println(result[sCity]);
        System.out.println(resultCount);
    }
}


class node{                 //가중치가 있는 그래프이므로 클래스 생성
    int targetNode;
    int value;
    node(int targetNode, int value){
        this.targetNode = targetNode;
        this.value = value;
    }
}
