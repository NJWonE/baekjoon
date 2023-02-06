import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    long[] dp;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new long[91];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        for(int i=4; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[n]);
    }


    public static void main(String args[]) throws IOException {
        new Main().solution();
    }
}