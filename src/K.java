import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class K {
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        int numCasos = sc.nextInt();
        for (int i = 0; i < numCasos; i++) {
            List<Integer> cambio = new ArrayList<>();
            int valor = sc.nextInt();
            int base = sc.nextInt();

            while (true) {
                cambio.add(valor % base);
                if (valor / base < base) {
                    if (valor / base != 0) cambio.add(valor / base);
                    break;
                }
                valor = valor / base;
            }
            StringBuilder sb = new StringBuilder();
            for (Integer j : cambio) {
                sb.append(j);
            }
            System.out.println(sb.reverse());
        }
    }
}
