import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    StringBuilder sb = new StringBuilder();
    int[] num;
    int[] inputNumber;
    boolean[] check;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer stt = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        num = new int[m];
        check = new boolean[n];
        inputNumber = new int[n];
        for(int i = 0; i<n; i++){
            inputNumber[i] = Integer.parseInt(stt.nextToken());
        }
        Arrays.sort(inputNumber);

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
            if(!check[i]){
                num[depth] = inputNumber[i];
                dfs(n,m, depth+1);
            }
        }
    }


    public static void main(String args[]) throws IOException {
        new Main().solution();
    }
}
