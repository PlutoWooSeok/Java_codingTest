import java.util.*;

public class 그래프_P1717_집합표현 {
    static int[] parent;        //대표 노드 저장 배열
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        parent = new int[N];
        for( int i =1; i<=N; i++){
            parent[i] = i;
        }
        for( int i = 0; i<M;i++){
            int select =sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(select == 0){
                union(a,b);
            } else if (select ==1) {
                if(checkSame(a,b))
                {
                    System.out.println("Yes");
                }else
                    System.out.println("No");
            }
        }

    }

    private static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);
        if(a == b)
            return  true;
        else
            return false;
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b)
            parent[b]= a;
    }

    public static int find(int k){
        if( parent[k] == k)
            return k;
        else
            return parent[k] = find(parent[k]);
    }
}
