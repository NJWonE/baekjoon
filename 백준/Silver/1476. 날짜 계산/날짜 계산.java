import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int earth = Integer.parseInt(st.nextToken());
        int sun = Integer.parseInt(st.nextToken());
        int moon = Integer.parseInt(st.nextToken());
        int year = 1;
        int E = 1;
        int S = 1;
        int M = 1;

        while(true){
            if(E>15) E=1;
            if(S>28) S=1;
            if(M>19) M=1;
            if(E==earth && S==sun && M == moon) break;
            E++;
            S++;
            M++;
            year++;
        }
        System.out.println(year);
    }
    public static void main(String args[]) throws IOException {
        new Main().solution();
    }
}
