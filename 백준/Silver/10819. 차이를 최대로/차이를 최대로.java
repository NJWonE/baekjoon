import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int[] num;
    int[] changeNum;
    boolean[] visit;
    int n;
    int max = 0;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visit = new boolean[n];
        num = new int[n];
        changeNum = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(max);
    }

    public void dfs(int depth){
        if(depth==n){
            int result = 0;
            for(int i=1; i<n; i++){
                result += Math.abs(changeNum[i-1]-changeNum[i]);
            }
            max = Math.max(max, result);
        }
        for(int i=0; i<n; i++){
            if(!visit[i]){
                visit[i] = true;
                changeNum[depth] = num[i];
                dfs(depth+1);
                visit[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}