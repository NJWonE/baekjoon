import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                stat[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1; i<n/2+1; i++){
            a = new int[i];
            b = new int[n-i];
            dfs(0, 0, i);
        }
        System.out.println(result);
    }

    public void dfs(int index,int depth,int length){
        if(depth==length){
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
                dfs(i+1, depth+1, length);
                visit[i] = false;
            }
        }
    }

    public int cal(int[] numArray){
        int result = 0;
        if(numArray.length==1){
            return 0;
        }
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