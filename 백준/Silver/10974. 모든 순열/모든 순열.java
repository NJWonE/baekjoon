import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    StringBuilder sb = new StringBuilder();
    int n;
    int[] check;
    boolean[] visit;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visit = new boolean[n];
        check = new int[n];
        dfs(0);
        System.out.println(sb);
    }

    public void dfs(int depth){
        if(depth==n){
            for(int a : check){
                sb.append(a).append(" ");
            }
            sb.append("\n");
        }
        for(int i=0; i<n; i++){
            if(!visit[i]){
                visit[i] = true;
                check[depth] = i+1;
                dfs(depth+1);
                visit[i] = false;
            }
        }
    }




    public static void main(String args[]) throws IOException {
        new Main().solution();
    }
}