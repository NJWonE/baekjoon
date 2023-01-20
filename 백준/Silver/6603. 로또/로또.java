import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    StringBuilder sb = new StringBuilder();
    int n = 1;
    int[] numArray;
    int[] result;
    boolean[] visit;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(n!=0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            numArray = new int[n];
            result = new int[6];
            visit = new boolean[n];
            for(int i=0; i<n; i++){
                numArray[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0,0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public void dfs(int index, int depth){
        if(depth==6){
            for(int a : result){
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = index; i<n; i++){
            if(!visit[i]) {
                visit[i] = true;
                result[depth] = numArray[i];
                dfs(i+1, depth + 1);
                visit[i] = false;
            }
        }
    }





    public static void main(String args[]) throws IOException {
        new Main().solution();
    }
   }