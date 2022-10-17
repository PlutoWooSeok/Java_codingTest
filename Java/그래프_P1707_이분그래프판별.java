//슈도 코드
/*
K(테스트 케이스 수)
V(노드의 개수), E(에지의 개수)
check(이분 그래프 체크 배열)     visited(방문 기록 저장 배열)    A(그래프 데이터 저장 인접 리스트)

for( K만큼 반복-테스트 케이){
    V
    E
    for( V만큼 반복 ){
        A 인접 리스트의 각 ArrayList 초기화
    }
    for( E만큼 반복 ){
        A 인접 리스트에 그래프 데이터 저장
    }
    for( V만큼 반복 ){
        각 노드에서 DFS 실행 -> 결과가 이분 그래프가 아니면 반복 종료
    }
    이분 그래프 여부를 정답으로 출력하기
}
 */

import javax.lang.model.type.ArrayType;
import java.io.InputStreamReader;
import java.util.Arrays;

//DFS 구현하기//
/*
DFS(int node){
    현재 노드 출력하기
    visited 배열에 현재 노드 방문 기록하기
    if(현재 노드의 연결 노드 중 방문하지 않은 노드로){
        현재 노드와 다른 집합으로 연결 노드 집합 저장하기
        DFS 실행하기( 재귀 형태)
    }
    else{
    //이미 방문한 노드인데, 현재 나의 노드와 같은 집합이면 이분 그래프가 아님
    }
}
 */
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;


public class 그래프_P1707_이분그래프판별 {
    static ArrayList<Integer>[] A;
    static  int[] check;
    static boolean visited[];
    static boolean IsEvwn;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        for( int t=0; t<K; t++){
            String[] s = br.readLine().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            A = new ArrayList[ V+1 ];
            visited = new boolean[V+1];
            check = new int[ V+1 ];
            IsEvwn = true;
            for( int i =1; i <= V; i++){
                A[i] = new ArrayList<Integer>();
            }
            for( int i = 0; i<=E; i++){
                s=br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                A[start].add(end);
                A[end].add(start);
            }
            //주어진 그래프가 1개로 연결되아 있다는 보장이 없으므로 모든 노드에서 수행하기
            for( int i = 1; i <=V; i++){
                if( IsEvwn )
                    DFS(i);
                else
                    break;
            }
            check[1] =0;
            if(IsEvwn)
                System.out.println("Yes");
            else
                System.out.println("NO");
        }

    }

    public static void DFS(int node){
        visited[node] = true;
        for( int i : A[node]){
            if(!visited[i]){
                //인접한 노드는 같은 집합이 아니므로 이존 노드와 다른 집합으로 처리하기
                check[i] = (check[node] +1) % 2;
                DFS(i);
            }
            else if(check[node] == check[i]){
                IsEvwn =false;
            }
        }
    }

}
