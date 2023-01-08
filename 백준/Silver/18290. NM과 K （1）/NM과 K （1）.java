import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int result = Integer.MIN_VALUE;
    int[][] num;
    boolean[][] check;
    int n;
    int m;
    int k;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        num = new int[n][m];
        check = new boolean[n+1][m+1];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0,0,0);
        System.out.println(result);
    }

    public void dfs(int x, int y, int sum, int depth){
        if(depth == k){
            result = Math.max(sum, result);
            return;
        }
        for(int i = x; i<n; i++){
            for(int j = y; j<m; j++){
                if(!check[i][j]){
                    if(check(i, j)){
                        check[i][j] = true;
                        dfs(x,y, sum+num[i][j], depth+1);
                        check[i][j] = false;
                    }
                }
            }
        }
    }

    public boolean check(int x, int y){
        boolean flag = true;
        for(int i=0; i<4; i++){
            int currentX = x+dx[i];
            int currentY = y+dy[i];
            if(currentX>=0&&currentX<n&&currentY>=0&&currentY<m){
                if(check[currentX][currentY]){
                    flag = false;
                }
            }
        }
        return flag;
    }

    public static void main(String args[]) throws IOException {
        new Main().solution();
    }
}