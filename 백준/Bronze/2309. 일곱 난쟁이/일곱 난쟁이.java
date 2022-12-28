import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Integer[] height = new Integer[9];
        int sum = 0;
        for(int i = 0; i < 9; i++){
            int number = Integer.parseInt(br.readLine());
            height[i] = number;
            sum += number;
        }
        ArrayList<Integer> numArray = new ArrayList<>(Arrays.asList(height));
        check:for(int i = 0; i < 9; i++){
            for(int j = i+1; j < 9; j++){
                if(i!=j&&height[i]+height[j]==sum-100){
                    numArray.remove(height[i]);
                    numArray.remove(height[j]);
                    break check;
                }
            }
        }
        Collections.sort(numArray);
        for(int i = 0; i < numArray.size(); i++){
            sb.append(numArray.get(i)).append("\n");
        }
        System.out.println(sb);
    }
    public static void main(String args[]) throws IOException {
        new Main().solution();
    }
}
