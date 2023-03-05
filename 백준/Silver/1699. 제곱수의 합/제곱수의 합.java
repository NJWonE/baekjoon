import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int n;
    int[] dp;
    int min = 0;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        dp[1] = 1;

        for(int i=2; i<=n; i++){
            min = 100000;
            for(int j=1; j<=i/2; j++){
                if(j*j==i){
                    min = 1;
                    break;
                }else{
                    min = Math.min(min, dp[j]+dp[i-j]);
                }
            }
            dp[i] = min;
        }

        System.out.println(dp[n]);
    }



    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}