import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = Integer.parseInt(br.readLine());
        int[] num = new int[11];
        num[1] = 1;
        num[2] = 2;
        num[3] = 4;
        for(int j = 4; j<=10; j++){
            num[j] = num[j-3] + num[j-2] + num[j-1];
        }
        for(int i = 0; i<count; i++){
            sb.append(num[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String args[]) throws IOException {
        new Main().solution();
    }
}