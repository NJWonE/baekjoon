import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    Integer[] dp;
    int[] num;
    int max = Integer.MIN_VALUE;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp = new Integer[n];
        num = new int[n];
        for(int i=0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = num[0];
        max = num[0];

        recur(n-1);
        System.out.println(max);
    }

    public int recur(int n){
        if(dp[n]==null){
            dp[n] = Math.max(recur(n-1)+num[n], num[n]);
            max = Math.max(max, dp[n]);
        }
        return dp[n];
    }



    public static void main(String args[]) throws IOException {
        new Main().solution();
    }
}