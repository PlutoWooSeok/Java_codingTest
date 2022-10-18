//////////////////////////슈도코드///////////////////////////////////
/*
N(사람 수) M( 파티 수)
T(진실을 아는 사람 수)      trueP(진실을 아는 사람의 데이터)   PD(파티 데이터 )
parent( 대표 노드 저장 배열)
데이터를 입력받아서 각자의 자료구조에 저장
for( N만큼 반복){
    대표 노드를 자신의 인덱스 번호로 저장
}
for( M만큼 반복 ){
    firstPeople(i번째 파티의 1번째 사람)
    for( j -> i번째 파티의 사함 수만큼 반복 ){
        union(firstPeople, j)       //각 파티에 참여한 사람들을 1개의 그룹으로 만들기
    }
}

for( i -> M 만큼 반복 ){
    firstPeople(i번째 파티의 사람)
    for( j -> 진실을 아는 사람들의 수만큼 반복하기 ){
        //각 파티의 대표노드와 진실을 아는 사람들의 대표노드가 같다면 과장할 수 없다.
        find(firstPeople),find(j) 비교하기
    } 모두 다른 경우 결과값 +1
}
결과값 출력하기
*/
///////////////////////////////////////////////////////////////////////

/////////union 함수 선언 /////////
/*
union(int a, int b){
    a와 b의 대표 노드 찾기
    두 원소의 대표 노드끼리 연결하기
}
*/
///////////////////////////////

////////////////////////find 함수 선언/////////////////////////////
/*find( int a){
    a가 대표 노드이면 리턴하기
    아니면 a의 대표 노드값을 find(parent[a]) 값으로 저장 -> 재귀 함수 형태
}
 */
////////////////////////////////////////////////////////////////


import java.util.*;
public class 그래프_P1043_거짓말쟁이 {
    public static int [] parent;            //대표 노드 저장 배열
    public static int [] trueP;             //진실을 아는 사람 데이터
    public static ArrayList<Integer> [] party ; //파티 데이터
    public static int result;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();        //사람수
        int M = sc.nextInt();           //party 수
        int T = sc.nextInt();           //진실을 아는 사람 수
        result = 0;
        trueP = new int[T];             //진실의 아는 사람 수의 크기만큼의 데이터배열 초기화
        for( int i = 0; i <T ; i++){
            trueP[i] = sc.nextInt();
        }
        party = new ArrayList[M];           //파티 데이터 초기화
        for( int i =0; i<M ;i++){
            party[i] = new ArrayList<Integer>();       //파티 배열에 각 ArrayList 초기화
            int party_size = sc.nextInt();          //파티 참여자 수
            for (int j = 0; j < party_size; j++){
                party[i].add(sc.nextInt());         //파티에 참여한 사람의 번호 저장
            }
        }
        parent = new int [N+1];
        for( int i = 0; i <= N ;i++){
            parent[i] = i;              //대표 노드를 자신의 번호로 저장
        }

        for( int i=0; i<M; i++){
            int firstPeople = party[i].get(0);      //파티의 첫번째 사람 번호 가져오기
            for( int j = 1; j<party[i].size(); j++){
                union(firstPeople, party[i].get(j));            //파티의 첫번째 사람과 다른 사람들의 번호를 한 그룹으로 합치기
            }
        }

        //각 파티의 대표 노드와 진실을 아는 사람들의 대표 노드가 같다면 과장할 수 없다.
        for( int i =0; i< M ; i++){
            boolean lie = true;
            int cur = party[i].get(0);
            for (int j =0; j< trueP.length; j++){
                if( find(cur) == find(trueP[j])){
                    lie = false;
                    break;
                }
            }
            if( lie )
                result++;
        }
        System.out.println(result);
    }

    ///////////////////// union 함수 구현부 ///////////////////////
    public static void union( int a, int b){
        a = find(a);
        b = find(b);
        if( a != b) {
            parent[b] = a;
        }
    }
    /////////////////////////////////////////////////////////////

    ///////////////////////find 함수 구현부/////////////////////////
    public static int find(int a){
        if( a == parent[a]){
            return a;
        }else{
            return parent[a] = find(parent[a]);     //재귀 함수 형태
        }
    }
}
