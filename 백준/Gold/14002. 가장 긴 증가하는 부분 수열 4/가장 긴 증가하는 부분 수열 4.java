import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    int[] dp;
    int[] num;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        dp = new int[n];
        num = new int[n];
        for(int i=0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<n; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(num[i]>num[j]&&dp[i]<dp[j]+1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }


        int max = 0;
        for(int i=0; i<n; i++){
            max = Math.max(max, dp[i]);
        }
        int value = max;
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1; i>=0; i--){
            if(value==dp[i]){
                stack.push(num[i]);
                value--;
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(max);
        System.out.println(sb);
    }



    public static void main(String args[]) throws IOException {
        new Main().solution();
    }
}