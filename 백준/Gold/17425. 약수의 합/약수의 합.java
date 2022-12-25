import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long[] numArray = new long[1000001];
        Arrays.fill(numArray,1);
        for(int i = 2; i<numArray.length; i++){
            for(int j = 0; j*i<numArray.length; j++){
                numArray[i*j] += i;
            }
            numArray[i] = numArray[i-1] + numArray[i];
        }
        int count = Integer.parseInt(br.readLine());
        while(count-->0){
            int inputNum = Integer.parseInt(br.readLine());
            sb.append(numArray[inputNum]).append("\n");
        }
        System.out.print(sb);
    }
    public static void main(String args[]) throws IOException {
        new Main().solution();
    }
}
