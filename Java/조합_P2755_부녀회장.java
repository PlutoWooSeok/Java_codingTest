import java.util.Scanner;

public class 조합_P2755_부녀회장 {
    public static void main(String[] args){
        int D[][] = new int [15][15];
        for( int i = 0; i<=14;i++){
            D[i][1] =1;
            D[0][i] =i;
        }
        for(int i =1; i<15;i++){
            for( int j=2;j<15;j++){
                D[i][j] = D[i-1][j] + D[i][j-1];
            }
        }
        Scanner sc = new Scanner(System.in);
        int T= sc.nextInt();            //질의 수
        for( int i = 0; i<T; i++) {
            int a = sc.nextInt();             //
            int b = sc.nextInt();
            System.out.println(D[a][b]);
        }
    }
}
