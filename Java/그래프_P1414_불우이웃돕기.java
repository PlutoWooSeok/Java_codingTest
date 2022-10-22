//슈도 코드 //
/*
N(컴퓨터의 개수) , sum(모든 랜선의 합 저장하기)
parent(대표 너드 저장 배열)
queue( 랜선 정보를 저장하기 위한 우선순위 큐)
for( N만큼 반복) {
    for(N만큼 반복){
        랜선의 총합 저장하기 --> 소문자 일 경우 : 현재 문자 -'a' +1;
                         --> 대문자 일 경우 : 현재 문자 -'A' +1;
        i와 j가 다르면 랜선 정보를 큐에 저장하기
    }
}
while( 큐가 빌 떄까지){
    큐에서 에지 정보를 가져오기
        에지 시작점과 끝점의 부모 노드가 다르면 --> 연결해도 사이클이 생기지 않으면
        union 연산 수행하기
        에지의 가중치를 정답 변수에 저장
}
사용한 에지가 노드 -1만큼이면 모든 랜선의 합에서 최소 신장 트리의 결과값을 뺀 값을 출력,
아니면 -1 출력하기

/////union() 연산 구현하기///////
union(int a. int b){
    a = find(a);
    b = find(b);
    if ( a != b){
        parent[a] =a;
    }
}
/////////////////////////////
///////////find() 매서드 구현 ////////////
find( int a){
    if( a == parent[a])
        return a;
    else
        parent[a] = find(parent[a]);
}
////////////////////////////////////////
 */
import java.io.*;
import java.util.*;

public class 그래프_P17472_다리만들기 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static PriorityQueue<lEdge> queue ;
    static int [] parent;
    static int N,sum;

    public static void main(String[] argds) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        queue = new PriorityQueue<>();
        for( int i = 0; i<N ; i++){
            st = new StringTokenizer(br.readLine());
            char[] tempc = st.nextToken().toCharArray();
            for( int j=0; j <N; j++){
                int temp = 0;
                if( tempc[j] >='a' && tempc[j]<='z'){
                    temp = tempc[j] - 'a' + 1;
                } else if (tempc[j] >='A' && tempc[j]<='Z') {
                    temp = tempc[j] - 'A' + 27;
                }
                sum += temp;
                if( i != j && temp != 0)
                    queue.add(new lEdge(i,j, temp));
            }
        }
        parent = new int[N];
        for ( int i = 0; i< parent.length; i++){
            parent[i] =i;
        }
        int useEdge =0;
        int result =0;
        while (!queue.isEmpty()){
            lEdge now = queue.poll();
            if( find(now.s) != find(now.e)){
                union(now.s, now.e);
                result = result + now.v;
                useEdge++;
            }
        }
        if( useEdge == N-1)
            System.out.println(sum - result);
        else
            System.out.println(-1);
    }

    public static void union(int a,int b){
        a = find(a);
        b = find(b);
        if( a!=b )
            parent[b] = a;
    }
    public static int find(int a){
        if( a == parent[a])
            return a;
        else
            return parent[a] = find(parent[a]);
    }
}
class lEdge implements Comparable<lEdge>{
    int s,e,v;
    lEdge(int s, int e, int v){
        this.s = s;
        this.e = e;
        this.v = v;
    }

    @Override
    public int compareTo(lEdge o) {
        return this.v - o.v;
    }
}