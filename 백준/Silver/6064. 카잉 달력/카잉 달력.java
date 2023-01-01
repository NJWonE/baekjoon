import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = Integer.parseInt(br.readLine());

        for(int i = 0; i<count; i++){
            boolean check = false;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()) -1;
            int y = Integer.parseInt(st.nextToken()) -1;
            for(int j = x; j<lcm(m, n); j+=m){
                if(j%n ==y){
                    sb.append(j+1).append("\n");
                    check = true;
                    break;
                }
            }
            if(!check){
                sb.append("-1").append("\n");
            }
        }
        System.out.println(sb);
    }

    public int gcd(int a, int b){
        return b==0?a:gcd(b, a%b);
    }
    public int lcm(int a, int b){
        return (a*b)/gcd(a,b);
    }
    public static void main(String args[]) throws IOException {
        new Main().solution();
    }
}