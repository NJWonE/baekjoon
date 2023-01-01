import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int[][] paper = null;
    boolean[][] check = null;
    int result = 0;
    int n = 0;
    int m = 0;

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public void solution() throws IOException {
        initPaperAndCheck();

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                check[i][j] = true;
                dfs(i, j, paper[i][j], 1);
                check[i][j] = false;
            }
        }
        System.out.println(result);
    }

    public void dfs(int x, int y, int sum, int length){
        if(length==4){
            result = Math.max(result, sum);
            return;
        }
        for(int i = 0; i<4; i++){
            int currentX = x + dx[i];
            int currentY = y + dy[i];

            if(currentX < 0 || currentX >= n || currentY < 0 || currentY >= m) continue;

            if(!check[currentX][currentY]){

                if(length==2){
                    check[currentX][currentY] = true;
                    dfs(x, y,sum+paper[currentX][currentY], length+1);
                    check[currentX][currentY] = false;
                }
                check[currentX][currentY] = true;
                dfs(currentX, currentY, sum+paper[currentX][currentY], length+1);
                check[currentX][currentY] = false;
            }
        }
    }

    public void initPaperAndCheck() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        paper = new int[n][m];
        check = new boolean[n][m];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    public static void main(String args[]) throws IOException {
        new Main().solution();
    }
}