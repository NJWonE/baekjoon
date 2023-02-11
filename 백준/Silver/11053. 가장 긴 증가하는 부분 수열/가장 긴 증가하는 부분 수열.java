import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int[] dp;
    int[] num;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp = new int[n];
        num = new int[n];
        for(int i=0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<n; i++){
            dp[i] = 1;
            for(int j = 0; j<i; j++){
                if(num[i]>num[j]&&dp[i]<dp[j]+1){
                    dp[i] = dp[j]+1;
                }
            }
        }

        int max = 0;
        for(int i=0; i<n; i++){
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
//    public int lis(int n){
//        if(dp[n]==0){
//            dp[n] = 1;
//            for(int i=n-1; i>=0; i--){
//                if(num[i]<num[n]){
//                    dp[n] = Math.max(dp[n], lis(i)+1);
//                }
//            }
//        }
//        return dp[n];
//    }

    public static void main(String args[]) throws IOException {
        new Main().solution();
    }
}