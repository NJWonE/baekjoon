import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    boolean[] set = new boolean[21];

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = Integer.parseInt(br.readLine());
        for(int i=0; i<count; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String request = st.nextToken();
            switch (request){
                case "all" :
                    Arrays.fill(set, true);
                break;
                case "empty" :
                    Arrays.fill(set, false);
                break;
                default:
                    int number = Integer.parseInt(st.nextToken());
                    switch (request){
                        case "add" : set[number] = true;
                            break;
                        case "remove" : set[number] = false;
                            break;
                        case "check" :
                            if(set[number]){
                                sb.append("1").append("\n");
                            }else {
                                sb.append("0").append("\n");
                            }
                            break;
                        case "toggle" : set[number] = !set[number];
                            break;
                    }
            }
        }
        System.out.println(sb);
    }

    public static void main(String args[]) throws IOException {
        new Main().solution();
    }
   }