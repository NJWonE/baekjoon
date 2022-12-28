import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    String[] candyColor;
    int n = 0;
    int max = 0;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i<n; i++){
            sb.append(br.readLine());
        }
        candyColor = sb.toString().split("");
        max = game();
        for(int i = 0; i<n*n; i+=n){
            for(int j = 0; j<n-1; j++){
                swap(i + j, i + j + 1);
                int checkCandy = game();
                if (checkCandy > max) {
                    max = checkCandy;
                }
                swap(i + j, i + j + 1);
            }
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j+i+n<n*n; j+=n) {
                swap(i+j, i+j+n);
                int checkCandy = game();
                if(checkCandy > max){
                    max = checkCandy;
                }
                swap(i+j, i+j+n);
            }
        }
        System.out.println(max);
    }

    public void swap(int a, int b){
        String temp = candyColor[a];
        candyColor[a] = candyColor[b];
        candyColor[b] = temp;
    }

    public int game(){
        int result = 0;
        int countX = 0;
        int countY = 0;
        for(int i = 0; i <n*n; i+=n){
            countX = 0;
            for(int j = 0; j<n-1; j++) {
                if (candyColor[i+j].equals(candyColor[i+j+1])) {
                    countX++;
                    if(countX>result) result = countX;
                }else{
                    countX = 0;
                }
            }
        }
        for(int i = 0; i<n; i++){
            countY = 0;
            for(int j = 0; j+i+n<n*n; j+=n) {
                if (candyColor[i+j].equals(candyColor[i+j+n])) {
                    countY++;
                    if(countY>result) result = countY;
                }else{
                    countY = 0;
                }
            }
        }
        return result+1;
    }
    
    public static void main(String args[]) throws IOException {
        new Main().solution();
    }
}
