import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    StringBuilder sb = new StringBuilder();
    int n;
    int[][] stat;
    boolean[] visit;
    int[] a;
    int[] b;
    int result = Integer.MAX_VALUE;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        stat = new int[n][n];
        visit = new boolean[n];
        a = new int[n/2];
        b = new int[n/2];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                stat[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println(result);
    }

    public void dfs(int index,int depth){
        if(depth==n/2){
            int index_a = 0,index_b = 0;
            for(int i=0; i<n; i++){
                if(visit[i]){
                    a[index_a++] = i;
                }else{
                    b[index_b++] = i;
                }
            }
            result = Math.min(result, Math.abs(cal(a)-cal(b)));
        }
        for(int i=index; i<n; i++){
            if(!visit[i]){
                visit[i] = true;
                dfs(i+1, depth+1);
                visit[i] = false;
            }
        }
    }

    public int cal(int[] numArray){
        int result = 0;
        for(int i=0; i<numArray.length; i++){
            for(int j=i+1; j<numArray.length; j++){
                result += stat[numArray[i]][numArray[j]] + stat[numArray[j]][numArray[i]];
            }
        }
        return result;
    }
    public static void main(String args[]) throws IOException {
        new Main().solution();
    }
}