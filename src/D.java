import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class D {
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();
        List<Ascensor> ascensores = new ArrayList<Ascensor>();

        int[] dp = new int[h+1];
        for(int i = 0; i < n; i++){
            ascensores.add(new Ascensor(sc.nextInt(), sc.nextInt()));
        }

        for(int j = 0; j <= h; j++){
            dp[j] = j;
        }

        for(int k = 1; k<=h; k++){
            for(Ascensor ascensor: ascensores){
                if(k == ascensor.fin){
                    dp[k] -= ascensor.fin - ascensor.inicio;
                }
            }
        }
        System.out.println(dp[h]);
    }

    public static class Ascensor{
        public int inicio;
        public int fin;

        public Ascensor(int inicio, int fin){
            this.inicio = inicio;
            this.fin = fin;
        }
    }
}
