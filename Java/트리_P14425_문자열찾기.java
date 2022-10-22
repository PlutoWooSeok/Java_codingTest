//슈도 코드//
/*
N(집합 S의 문자열 개수) M(검사할 문자열 개수)
while(N만큼 반복하기){
   text(집합 S의 문자열)
   현재 노드를 루트 노드로 설정하기
   for( i를 text 문자열 길이만큼 반복하기){
        C(i번째 문자)
        if( C변수에 해당하는 다음 노드가 null) 신규노드 생성하기
            현재 노드를 C 변수 노드로 변경하기
        if( i가 문자열의 마지막이면)
            isEnd 변수를 true로 설정하기
   }
}
count(정답변수)
while( m만큼 반복하기){
    text(검색 문자열)
    현재 노드를 루트 노드로 설정하기
    for( i를 text 문자열 길이만큼 반복하기){
        C( i번째 문자)
        if( C변수에 해당하는 다음 노드가 null) 이 문자열 검색 종료
            현재 노드를 C 변수 노드로 변경하기
        if(i가 문자열의 마지막이고, 현재 노드의 isEnd 값이 true 이면) count 값 올리기
    }
}
count 출력하기
///////////////////////////////////////////////////////////////////////////
/////////////////트라이 자료구조를 위한 t노드 class 구현하기////////////////////////
class tNode{
    next(다음 노드 배열)          //26size 배열로 선언하기
    isEnd(마지막 문자열 여부 표시하기)
}
 */
import java.util.*;

public class 트리_P14425_문자열찾기 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();               //집합 S의 문자열 개수
        int M = sc.nextInt();               //검사할 문자열 개수

        //트라이 자료구조 알고리즘 구축하기
        tNode root = new tNode();
        while (N > 0) {
            String text = sc.next();            //집합 S의 문자열
            tNode now = root;                   //현재 노드를 루트 문자열로 설정
            for( int i = 0; i< text.length();i++){
                char c = text.charAt(i);            //i번째 문자

                //26개 알파벳의 배열의 위치를 배열 index로 나타내기 위해 -'a' 수행하기
                if( now.next[c-'a'] == null){
                    now.next[ c-'a'] = new tNode();         //신규 노드 생성하기
                }
                now = now.next[c-'a'];              //현재 노드를 c 변수노드로 변경하기
                if( i==text.length()-1)
                    now.isEnd = true;               // 현재 문자열은 마지막 문자열임::::isEnd : 마지막 문자열을 확인하는 변수
            }
            N--;
        }
        int count =0;                   //정답변수
        while(M>0){
            String text = sc.next();
            tNode now = new tNode();
            for(int i = 0; i<text.length(); i++){
                char c = text.charAt(i);
                if( now.next[c-'a'] ==null){                //공백 노드라면 이 문자열을 포함하지 않음
                    break;
                }
                now = now.next[c-'a'];
                if( i == text.length() - 1 && now.isEnd)      //문자열의 끝이고 현재까지 모두 일치
                    count++;                                //정답 ++ <<===== S 집합에 포함되는 문자열이다.
            }
            M--;
        }
        System.out.println(count);
    }
}
class tNode {
    tNode[] next = new tNode[26];
    boolean isEnd;                          //문자열의 마지막 유무를 확인
}
