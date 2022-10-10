//슈도 코드
/*
N (수열 개수) , A[] (수열 배열), ans[] (정답 배열)
수열 배열 채우기
최고 스택 초기화하기
for( N만큼 반복){
    while (스택이 비어 있지 않고, 현재 수열 값이 top에 해당하는 수열보다 클 때까지){
        pop()
        정답 배열에 오큰수를 현재 수열로 저장
    }
    현재 수열을 스택에 push
}
while (스택이 빌 떄까지){
    스택에 있는 인덱스의 정답 배열에 -1 저장하기
}
정답배열 출력하기
 */

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class P17298_오큰수  {
    public static void main(String[] args) throws IOException{
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 수열 개수
        int A[] = new int[N]; //수열 배열 선언
        int ans[] = new int[N]; //정답 배열 선언
        String [] str = bf.readLine().split(" "); //문자열형으로 받은 수들을 공백으로 나눈다.
        for(int i = 0; i <N; i++){
            A[i] = Integer.parseInt(str[i]);    //수열 배열에 문자열형 배열에 공백으로 나누어진 수를 정수형으로 변환하여 저장
        }
        Stack<Integer> myStack = new Stack<>(); //스택 생성
        myStack.push(0);    //스택의 처음은 항상 비어 있으므로 최초의 값을 0으로 초기화한다.
        for(int i = 1; i<N;i++){    //스택의 최초의 값이 0으로 들어와있기 때문에 1부터 시작한다.
            //스택이 비어있지 않고 현재 수열이 스택top 안텍스가 가리키는 수열보다 클경우
            while(!myStack.isEmpty() && A[myStack.peek()] < A[i]){  //peek()는 top위치에 현재 있는 데이터를 단순 확인하는 연산이다.
                ans[myStack.pop()] = A[i];      //정답 배열에 오큰수를 현재 수열로 저장하기
            }
            myStack.push(i);    //신규 데이터 push
        }
        while (!myStack.empty()){       //스택이 비어있지 않다면 다 빌때까지 반복
            ans[myStack.pop()] = -1;    //스택에 쌓인 index에 -1을 넣고
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i =0; i< N; i++){
            bw.write(ans[i] + " ");
            //출력한다.
        }
        bw.write("\n");
        bw.flush();

    }
}
