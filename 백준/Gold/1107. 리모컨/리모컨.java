import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int targetChannel = Integer.parseInt(br.readLine());
        int brokenButtonCount = Integer.parseInt(br.readLine());
        boolean[] brokenButton = new boolean[10];
        int result = Math.abs(targetChannel - 100);
        if(brokenButtonCount!=0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < brokenButtonCount; i++) {
                brokenButton[Integer.parseInt(st.nextToken())] = true;
            }
        }
        if(targetChannel==100) result = 0;

        for(int i=0; i<=1000000; i++){
            int size = String.valueOf(i).length();
            boolean check = false;
            for(int j=0; j<size; j++){
                if(brokenButton[String.valueOf(i).charAt(j)-'0']){
                    check = true;
                    break;
                }
            }
            if(!check){
                int min = Math.abs(targetChannel-i)+size;
                result = Math.min(result, min);
            }
        }
        System.out.println(result);
    }
    public static void main(String args[]) throws IOException {
        new Main().solution();
    }
}