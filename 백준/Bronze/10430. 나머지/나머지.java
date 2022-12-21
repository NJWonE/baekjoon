import java.io.*;
import java.util.StringTokenizer;

public class Main {


    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int resultA = (a+b)%c;
        int resultB = ((a%c)+(b%c))%c;
        int resultC = (a*b)%c;
        int resultD = ((a%c)*(b%c))%c;
        sb.append(resultA).append('\n');
        sb.append(resultB).append('\n');
        sb.append(resultC).append('\n');
        sb.append(resultD).append('\n');
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}