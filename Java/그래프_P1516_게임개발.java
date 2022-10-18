import java.io.*;
import java.sql.ResultSet;
import java.util.*;

public class 그래프_P1516_게임개발 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());            //건물 종류 저장
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();        //그래프 데이터 인접리스트 생성
        for( int i = 0; i <=N ; i++){
            A.add(new ArrayList<>());
        }
        int [] inDegree = new int[N+1];         //진입차수 배열
        int [] selfBuild = new int [N+1];       //자신의 건물을 짓는데 걸리는 시간
        for (int i= 1; i<=N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            selfBuild[i] = Integer.parseInt(st.nextToken());        //건물을 짓는 데 걸리는 시간
            while (true) {
                int preBuilding = Integer.parseInt(st.nextToken());         //현재 건물을 짓기 전 지어야 하는 건물 번호
                if (preBuilding == -1) {             //만약 -1이 입력되면 선 건축 필요 없음.
                    break;
                }
                A.get(preBuilding).add(i);
                inDegree[i]++;                      //진입ㅂ차수배열 초기화
            }
        }

            //위상 정렬
            Queue<Integer> queue = new LinkedList<>();
            for( int i =1; i<=N; i++){
                if( inDegree[i] == 0){
                    queue.offer(i);
                }
            }
            int[] result = new int[N+1];
            while(!queue.isEmpty()){
                int now = queue.poll();
                for( int next : A.get(now)){
                    inDegree[next]--;
                    //시간 업데이트하기
                    result[next] = Math.max(result[next], result[now] + selfBuild[now]);
                    if( inDegree[next] == 0){
                        queue.offer(next);
                    }
                }
            }
            for( int i = 1; i<=N; i++){
                System.out.println(result[i]+ selfBuild[i]);
            }
        }

    }

