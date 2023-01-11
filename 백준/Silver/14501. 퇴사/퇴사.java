import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int[] t;
    int[] p;
    boolean[] visit;
    int n;
    int result = 0;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        t = new int[n];
        p = new int[n];
        visit = new boolean[n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        System.out.println(result);
    }
    public void dfs(int index, int sum){
        if(index==n){
            result = Math.max(result, sum);
            return;
        }

        if(index>n) return;

        dfs(index+t[index], sum+p[index]);

        dfs(index+1, sum);
    }



    public static void main(String args[]) throws IOException {
        new Main().solution();
    }
}