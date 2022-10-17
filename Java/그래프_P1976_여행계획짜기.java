import java.util.*;

public class 그래프_P1976_여행계획짜기 {
    static int []parent;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();       //도시개수
        int M = sc.nextInt();       //여행경로 데이터
        int connect[][] = new int[N][N];    //도시간의 이동 가능 여부판단 배열
        for(int i = 1; i<=N; i++){
            for(int j =i; j<=N; j++){
                connect[i][j] = sc.nextInt();           //연결된 곳은 1, 연결이 되지 않은 부분은 0
            }
        }
        int [] route = new int[M];                  //여행 경로
        for( int i =1; i<=M;i++){
            route[i] = sc.nextInt();            //경로 선택 저장
        }
        parent = new int[N];                    //대표노드 배열 선언
        for(int i = 1 ; i<=N; i++){
            parent[i] =i;                       //대표 노드를 본인의 인덱스 번호로 초기화
        }
        for(int i =1; i<=N;i++){
            for( int j =1; j<=N; i++){
                if( connect[i][j] == 1){        //연결이 가능하다면
                    union(i,j);                 //두 노드를 하나로
                }
            }
        }
        //여행 계획 도시들이 1개의 대표 도시로 연결돼 있는지 확인하기
        int index = find(route[1]);             //현재 인덱스는 처음 출발지
        for( int i = 2; i< route.length; i++){
            if( index != find(route[i])){       //만약 연결이 되어있지 않는다면
                System.out.println("No");           //NO를 출력하고
                return;        //돌아간다.
            }
        }
        System.out.println("Yes");              //그게 아니라면 Yes 출력
    }

    ///////// UNION 함수 생성 //////////
    public static void union(int a, int b){             //union 연산 : 대표 노드끼리 연결하기
        a = find(a);
        b = find(b);
        if(a != b) {
            parent[b] = a;
        }
    }

    ///////// find 연산 함수 생상 ////////
    public static int find(int a){
        if(a == parent[a])
            return a;
        else
            return parent[a]=find(parent[a]);           // 재귀 함수의 형태로 구현 -> 경로 압축 부분
    }
}