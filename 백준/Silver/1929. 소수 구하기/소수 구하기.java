import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        Boolean[] booleans = new Boolean[max+1];
        setPrimeNumber(booleans);
        for(int i=min; i<=max; i++){
            if(booleans[i]!=true) System.out.println(i);
        }
    }

    public void setPrimeNumber(Boolean[] booleans){
        Arrays.fill(booleans, false);
        booleans[0] = booleans[1] = true;
        for(int i=2; i<Math.sqrt(booleans.length); i++){
            if(booleans[i]) continue;
            for(int j=i*i; j<booleans.length; j+=i){
                booleans[j] = true;
            }
        }
    }
    public static void main(String args[]) throws IOException {
        new Main().solution();
    }
}
