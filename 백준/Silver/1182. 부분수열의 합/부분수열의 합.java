import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int[] numArray;
    int n;
    int s;
    int count = 0;
    int[] resultArray;
    StringBuilder sb = new StringBuilder();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        numArray = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            numArray[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++){
            resultArray = new int[i+1];
            dfs(0, 0, i+1);
        }
        System.out.println(count);
    }

    public void dfs(int index, int depth, int size){
        if(depth==size){
            int result = 0;
            for(int a : resultArray){
                result += a;
            }
            if(result==s){
                count++;
            }
            return;
        }
        for(int i=index; i<n; i++){
            resultArray[depth] = numArray[i];
            dfs(i+1, depth+1, size);
        }
    }

    public static void main(String args[]) throws IOException {
        new Main().solution();
    }
   }