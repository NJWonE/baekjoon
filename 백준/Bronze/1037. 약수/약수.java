import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] intArr = new int[count];
        for(int i = 0; i<count; i++){
            intArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(intArr);
        System.out.println(intArr[0]*intArr[count-1]);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}