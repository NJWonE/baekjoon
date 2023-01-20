import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    StringBuilder sb = new StringBuilder();
    int n;
    int min = Integer.MAX_VALUE;
    int[] a;
    int[][] cost;
    boolean[] visit;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        cost = new int[n][n];
        a = new int[n];
        visit = new boolean[n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0, 0);
        System.out.println(min);
    }

    public void dfs(int start, int index, int depth){
        if(depth==n&&start==index) {
            int result = 0;
            for (int a : a) {
                result += a;
            }
            min = Math.min(min, result);
            return;
        }

        for(int i=0; i<n; i++){
            if(!visit[index]&&cost[index][i]!=0){
                visit[index] = true;
                a[depth] = cost[index][i];
                dfs(start, i, depth+1);
                visit[index] = false;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}