import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

//슈도 코드
/*
N(노드의 개수), E(에지 개수)
A( 방문 배열 선언하기)
L(인접 리스트 선언하기)
for( N만큼 반복)
{
    L 인접리스트의 각 ArrayList를 초기화
}
for( E만큼 반복)
{
    L 인접리스트에 A방문 배열 데이터 저장
}
for( N만큼 반복)
{
    if( 방문하지 않은 노드가 있을 경우){
        연결 요소 개수++;
        DFS실행하기
    }
}

//DFS구현하기
DFS{
    if( 현재 노드 == 방문 노드) return;
    A배열에 현재 노드 방문 기록하기
    현재 노드의 연결 노드 중 방문하지 않은 노드로 DFS실행하기(재귀함수 형태 )
}
결과
 */
public class P11724_연결요소개수구하기 {
    public static boolean A[];
    public static ArrayList<Integer> L[];
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        L = new ArrayList[N+1];
        A = new boolean[N+1];
        for( int i = 1 ; i < N+1 ; i++ ){
            L[i] = new ArrayList<Integer>();
        }
        for( int i = 0 ; i < E ;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());           //시작점
            int e = Integer.parseInt(st.nextToken());           //끝점
            L[s].add(e);                                        //양방향 에지이므로 양쪽에 에지를 구하기
            L[e].add(s);
            /*
            1 : 2 | 5
            2 : 1 | 5
            3 : 4
            4 : 3 | 6
            5 : 2 | 1
            6 : 4
             */
        }
        int count = 0;                                            //DFS 총 횟수
        for(int i = 1 ; i < N+1 ; i++ ){
            if( !A[i]){                                             //방문하지 않은 노드가 없을 때까지 반복하기 //디폴트 값 true
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }

    public static void DFS(int v) {
        if( A[v]){
            return;
        }
        A[v] = true;
        for( int i : L[v] ){                    //연결 노드 중 방문하지 않았던 노드만 탐색하기 //L[v]에서 차례대로 객체를 꺼내서 i에다가 넣겠다
            if (A[i] == false)
                DFS(i);
        }
    }

}
