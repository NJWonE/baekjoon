import java.util.Scanner;


public class Main {
    public void solution(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int num = sc.nextInt();
            int checkNumber = 0;
            int count = 0;
            while(true){
                checkNumber = (checkNumber*10+1)%num;
                if(checkNumber==0){
                    count++;
                    System.out.println(count);
                    break;
                }
                count++;
            }
        }
    }

    public static void main(String[] args){
        new Main().solution();
    }
}