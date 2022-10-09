import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//슈도 코드
/*
//데이터 저장
문자열 길이S
부분 문자열 길이 P
문자열 배열 A
비밀번호 개수체크 배열 checkArr
//변수 선언
현재상태배열 : myArr
checkSecret(몇개의 문자와 관련된 개수를 충족했는지 판단하는 변수)
p 범위 ( 0~ P-1 )만큼 S베열에 적용하고, 유효한 비밀번호인지 판단하기
for(i를 p에서 S까지 반복)
{
    j 선언(i-p)
    //이 부분은 함수로 뱔도 구현하기
    한 칸씩 이동하면서 제거되는 문자열과 새로 들어오는 문자열을 처리하기
}
결과값 출력하기

별도 함수
Add(문자 더하기 함수)
{
    새로 들어온 문자를 myArr에 업데이트하거나 checkSecret 값 변경하기
}
Remove(문자 빼기 함수)
{
    제거되는 문자를 myArr에 업데이트하거나 checkSecret 값 변경하기
}
 */
public class P12891_DNA {
    static int checkArr[]; //비밀번호 체크 배열 생성
    static  int myArr[]; //현재상태배열 생성
    static  int checkSecret; // 문자와 관련된 개수를 충족했는지 판단하는 변수

    public static void main(String[] args[]) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int result =0;      //좋은 수 개수
        char A[] = new char[S];
        checkArr = new int[4];
        myArr = new int[4];
        checkSecret =0;
        A = bf.readLine().toCharArray();
        st = new StringTokenizer(bf.readLine());
        for (int i =0; i < 4; i++){
            checkArr[i] = Integer.parseInt(st.nextToken());
            if( checkArr[i] ==0)
                checkSecret++;
        }
        for (int i = 0; i < P; i++){
            Add(A[i]);
        }
        if( checkSecret == 4)
            result++;
        // 슬라이딩 윈도우 처리 부분
        for( int i = P; i < S; i++){
            int j = i-P;
            Add(A[i]);
            Remove(A[j]);
            if( checkSecret == 4)
                result++;

        }
        System.out.println(result);
        bf.close();

    }

    private static void Remove(char c) {    //제거되는 문자를 처리하는 함수
        switch (c){
            case 'A':
                if (myArr[0] == checkArr[0])
                    checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1])
                    checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2])
                    checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3])
                    checkSecret--;
                myArr[3]--;
                break;
        }
    }

    private static void Add(char c) {   //새로 들어오는 문자를 처리하는 함수
        switch (c){
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0])
                    checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1])
                    checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2])
                    checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3])
                    checkSecret++;
                break;
        }
    }

}
