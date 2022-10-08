import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11659_구간합구하기 {
    public static void main(String[] args) throws IOException{
        // 입력받는 자료의 크기가 클 경우 BufferedReader를 사용한다. => Scanner 보다 더 빠르기 때문에
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((System.in)));

        //두번째 숫자가 10만개일경우 int 형으로 받기 힘들기에 String Tokenizer로 분라해서 사용한다.
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int suNo = Integer.parseInt(stringTokenizer.nextToken());
        int quizNo = Integer.parseInt(stringTokenizer.nextToken());
        //nextToken은 String을 받기 때문에 Integer.parseInt를 통해 int형으로 받아올 수 있게 한다.

        //합 배열 선언 //배열의 0번째 인덱스를 무시
        long[]s = new long[suNo+1]; //숫자형 배열을 선언시 되도록 long형을 사용
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i =1 ; i <= suNo; i++)
        {
            s[i] = s[i-1] + Integer.parseInt((stringTokenizer.nextToken()));
        }
        for (int q = 0; q < quizNo; q++)
        {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(s[j] - s[i-1]);

        }
    }

}
