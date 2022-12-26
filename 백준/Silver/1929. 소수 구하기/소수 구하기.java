import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Boolean[] booleans = new Boolean[1000001];
        Arrays.fill(booleans, false);
        booleans[1] = true;
        for(int i=2; i<booleans.length/2; i++){
            for(int j=2; j*i<booleans.length; j++){
                booleans[j*i] = true;
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int min = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());

        for(int i = min; i<=max; i++){
            if(booleans[i]!=true){
                System.out.println(i);
            }
        }
    }
    public static void main(String args[]) throws IOException {
        new Main().solution();
    }
}
