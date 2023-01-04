import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    StringBuilder sb = new StringBuilder();
    int[] num;
    boolean[] check;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        num = new int[m];
        check = new boolean[n];
        dfs(n, m, 0);
        System.out.println(sb);
    }
    public void dfs(int n, int m, int depth){
        if(depth==m){
            for(int a : num){
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<i; j++){
                check[j] = true;
            }
            if(!check[i]){
                num[depth] = i+1;
                dfs(n,m, depth+1);
            }
            for(int j = 0; j<i; j++){
                check[j] = false;
            }
        }
    }


    public static void main(String args[]) throws IOException {
        new Main().solution();
    }
}
