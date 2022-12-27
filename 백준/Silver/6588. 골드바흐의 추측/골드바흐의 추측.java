import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Boolean[] booleans = new Boolean[1000001];
        Arrays.fill(booleans, false);
        booleans[0] = booleans[1] = true;
        for(int i=2; i<Math.sqrt(booleans.length); i++){
            if(booleans[i]) continue;
            for(int j=i*i; j<booleans.length; j+=i){
                booleans[j] = true;
            }
        }
        int number = 0;
        while((number = Integer.parseInt(br.readLine()))!=0){
            boolean check = false;
            for(int i=2; i<=number/2; i++){
                if(!booleans[i]&&!booleans[number-i]){
                    System.out.println(number + " = " + i + " + " + (number-i));
                    check = true;
                    break;
                }
            }
            if(!check){
                System.out.println("Goldbach's conjecture is wrong.");
            }
        }
    }

    public static void main(String args[]) throws IOException {
        new Main().solution();
    }
}
