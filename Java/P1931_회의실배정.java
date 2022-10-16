import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P1931_회의실배정 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [][]H = new int[N][2];          //각 회의의 시작, 종료 시점을 저장하는 배열
        for( int i = 0; i < N; i++){
            H[i][0] = sc.nextInt();         //시작 시간
            H[i][1] = sc.nextInt();         //종료 시간
        }
        Arrays.sort(H, new Comparator<int[]>() {
            @Override
            public int compare(int[] S, int[] E) {
                if (S[1]==E[1]){                    //종료시간이 같을 때
                    return S[0] -S[1];
                }
                return S[1] - E[1];

            }
        });

        int count =0;
        int end =-1;
        for (int i = 0; i < N; i++){
            if (H[i][0] >= end){            //겹치지 않는 다음회의가 나온 경우
                end = H[i][1];              //종료시간 업데이트
                count++;
            }
        }

        System.out.println(count);
    }
}
