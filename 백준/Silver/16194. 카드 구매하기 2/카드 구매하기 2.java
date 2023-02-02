import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    int[] p;
    int[] dp;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        p = new int[n+1];
        dp = new int[n+1];
        for(int i=1; i<=n; i++){
            p[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=n; i++){
            dp[i] = p[i];
            for(int j=1; j<=i; j++){
                dp[i] = Math.min(dp[i], dp[j]+dp[i-j]);
            }
        }
        System.out.println(dp[n]);
    }
    public static void main(String args[]) throws IOException {
        new Main().solution();
    }
}