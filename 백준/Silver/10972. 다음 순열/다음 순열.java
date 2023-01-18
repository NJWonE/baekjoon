import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    StringBuilder sb = new StringBuilder();
    int n;
    int[] inputNum;
    boolean[] visit;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        inputNum = new int[n];
        visit = new boolean[n];
        for(int i=0; i<n; i++){
            inputNum[i] = Integer.parseInt(st.nextToken());
        }

        if(permutation(inputNum)){
            for(int a : inputNum){
                sb.append(a).append(" ");
            }
        }else{
            sb.append("-1");
        }
        System.out.println(sb);
    }

    public boolean permutation(int[] a){
        int i = a.length-1;
        while(i>0 && a[i-1]>=a[i]){
            i--;
        }

        if(i<=0) return false;

        int j = a.length-1;
        while(a[i-1]>=a[j]){
            j--;
        }

        int temp = a[j];
        a[j] = a[i-1];
        a[i-1] = temp;

        j = a.length-1;
        while(i<j){
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
        return true;
    }


    public static void main(String args[]) throws IOException {
        new Main().solution();
    }
}