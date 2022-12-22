import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        sumOfDivisor(num);
    }
    public void sumOfDivisor(int n){
        long result = 0;
        for(int i = 1; i<=n; i++){
            result += (n/i)*i;
        }
        System.out.println(result);
    }
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}