import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCasos = sc.nextInt();
        for (int i =0; i<numCasos; i++){
            int numMonedas = sc.nextInt();
            int[] monedas = new int[numMonedas];
            for (int j = 0; j <numMonedas; j++) {
                monedas[j] = sc.nextInt();
            }
            int numMalditas = sc.nextInt();
            HashSet<Integer> malditas = new HashSet<>();
            for (int j = 0; j < numMalditas; j++) {
                malditas.add(sc.nextInt());
            }
            int suma = 0;
            for (int j = 0; j < numMonedas; j++) {
                if (!malditas.contains(monedas[j])) {
                    suma+=monedas[j];
                }
            }
            System.out.println(suma);
        }

    }
}