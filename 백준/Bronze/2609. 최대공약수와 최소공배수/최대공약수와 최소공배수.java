import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int gcd = greatestCommonDivisor(a, b);
        System.out.println(gcd);
        System.out.println(greatestCommonMultiple(a,b, gcd));
    }

    public int greatestCommonDivisor(int a, int b){
        if(b%a==0){
            return a;
        }else{
            return greatestCommonDivisor(b%a, a);
        }
    }

    public int greatestCommonMultiple(int a, int b, int c){
        return a*b/c;
    }
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}