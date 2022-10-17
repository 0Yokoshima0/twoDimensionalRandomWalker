import java.util.Scanner;

public class twoDimensionalRandomWalker {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input an even to evaluate the length of a space.");
        int len = sc.nextInt();
        System.out.println("Please input an number to evaluate the number of trials.");
        int trials = sc.nextInt();
        int deadEnds = 0;
        for (int i = 0; i < trials; i++) {
            boolean[][] arr = new boolean[len][len];
            int x = len/2, y = len/2;
            while(x > 0 && x < len - 1 && y > 0 && y < len - 1){
                if(arr[x - 1][y] && arr[x + 1][y] && arr[x][y - 1] && arr[x][y + 1]){
                    deadEnds++;
                    break;
                }
                arr[x][y] = true;
                double r = Math.random();
                if(r < 0.25) {
                    if (!arr[x + 1][y]) {
                        x++;
                    }
                }
                else if(r < 0.50) {
                    if (!arr[x - 1][y]) {
                        x--;
                    }
                }
                else if(r < 0.75) {
                    if (!arr[x][y + 1]) {
                        y++;
                    }
                }
                else if(r < 1.00) {
                if (!arr[x][y - 1]) {
                    y--;
                    }
                }
            }
        }
        System.out.println("The probability of the walker get out of the space is " + 100*deadEnds/trials + "%");
    }
}
